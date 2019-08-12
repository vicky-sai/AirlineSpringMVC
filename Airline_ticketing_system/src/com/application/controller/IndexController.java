package com.application.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.io.ByteArrayOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.application.services.*;
import com.application.domain.*;

@Controller
@Scope("session")
public class IndexController
{
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        sdf.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	@Autowired
	public PassengerService passengerService;
	@Autowired
	public HttpSession session;
	
	@RequestMapping("/index")
    protected String index()
	{
		if(session.getAttribute("passenger")==null)
			return "index";
		else
			return "searchflight";
    }
	
	@RequestMapping("/login")
    protected ModelAndView login(@RequestParam("username")String username,@RequestParam("password")String password)
	{
		//passengerService.saveUserObj(passObj);
		Passenger p = passengerService.checkUser(username, password);
		if(p==null)
		{
			ModelAndView modelandview = new ModelAndView("index");
			modelandview.addObject("error","Invalid login credentials!!");
			return modelandview;
		}
		else if(p.getUserName().equals(username)&&p.getPassword().equals(password))
		{
			session.setAttribute("passenger", p);
			return new ModelAndView("searchflight");
		}
		else
		{
			ModelAndView modelandview = new ModelAndView("index");
			modelandview.addObject("error","Invalid login credentials..");
			return modelandview;
		}
    }
	@RequestMapping("/searchflight")
    protected String searchFlight()
	{
		if(session.getAttribute("passenger")==null)
			return "index";
        return "searchflight";
    }
	
	
	@RequestMapping("/signup")
    protected ModelAndView signup(@ModelAttribute("passenger") Passenger passObj, BindingResult result)
	{
		ModelAndView modelandview = new ModelAndView("index");
		if(result.hasErrors())
		{
			
			modelandview.addObject("error","Please fill the signup form correctly");
			return modelandview;
		}
		passengerService.saveUserObj(passObj); 
        return modelandview;
    }

	@RequestMapping("/display_availability")
	protected ModelAndView displayAvailability(@RequestParam("source")String source,@RequestParam("dest")String dest,
    		@RequestParam("travelClass")String travelClass, @RequestParam("date")String date,@RequestParam("count")Integer count ) throws ParseException {
		if(session.getAttribute("passenger")==null)
			return new ModelAndView("index");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	     java.util.Date d1 = sdf.parse(date);
	     java.sql.Date sqlDate = new java.sql.Date(d1.getTime());
	     @SuppressWarnings("unchecked")
	     List<FlightDetails> list = passengerService.getSelectedFlights(source, dest, travelClass, sqlDate); 
	     ModelAndView modelandview = new ModelAndView("display_availability");			
		modelandview.addObject("message", "List of all flights");
		modelandview.addObject("allFlights", list);
		modelandview.addObject("count", count);
	      return modelandview;
	}
	@RequestMapping("/bookFlight")
	protected ModelAndView bookFlight(@RequestParam("flightId")long flightId,@RequestParam("count")Integer count)
	{
		if(session.getAttribute("passenger")==null)
			return new ModelAndView("index");
		
		FlightDetails fd = 	passengerService.getFlightById(flightId);
		if(fd.getAvailableSeats()<=0)
			return new ModelAndView("index","message", "All seats are already booked..");
		else if(fd.getAvailableSeats()-count<0)
			return new ModelAndView("index","message", "No sufficient vacancies available..");
		fd.setAvailableSeats(fd.getAvailableSeats()-count);
		passengerService.updateFlight(fd);
		
		Ticket t = new Ticket(count, fd.getAmount()*count,(Passenger)session.getAttribute("passenger"),fd );
		passengerService.saveTicket(t);
		ModelAndView modelandview = new ModelAndView("mid");
		modelandview.addObject("message", "Ticket is booked successfully..");
		return modelandview;
	}
	
	@RequestMapping("/mid")
    protected ModelAndView mid()
	{
		if(session.getAttribute("passenger")==null)
			return new ModelAndView("index");
		ModelAndView modelandview = new ModelAndView("mid");
		
        return modelandview;
    }
	@RequestMapping("/cancel")
    protected ModelAndView cancel(@RequestParam("ticketId")long ticket_id )
	{
		if(session.getAttribute("passenger")==null)
			return new ModelAndView("index");
		ModelAndView modelandview = new ModelAndView("mid");
		passengerService.cancelTicket(passengerService.getTicketById(ticket_id));
		modelandview.addObject("message", "Ticket is cancelled successfully..");
        return modelandview;
    }
	@RequestMapping("/mybooked")
    protected ModelAndView myBooked()
	{
		if(session.getAttribute("passenger")==null)
			return new ModelAndView("index");
		ModelAndView modelandview = new ModelAndView("mybooked");
		Passenger p = (Passenger)session.getAttribute("passenger");
		List<Ticket> allTickets = passengerService.getPassTickets(p);
		modelandview.addObject("allTickets", allTickets);
        return modelandview;
    }
	@RequestMapping("/print")
	public void downloadTicket(@RequestParam("ticketId")long ticketId, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	//	if(session.getAttribute("passenger")==null)
		//	return "index";
		Ticket t = passengerService.getTicketById(ticketId);
		Passenger passenger = t.getPassenger();
		FlightDetails flightDetail = t.getFlightDetails();
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy zzzz");  
		try{
		
		response.setContentType("application/pdf");
		
		Document document = new Document();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();
        
        Paragraph title = new Paragraph("\n-----------------------------------------------------------------------------------------------------------------------"+
        		"\n----------------------------------------------Ticket Confirmation-----------------------------------------------"+
        		"\n-------------------------------------Vicky Airline Management System-------------------------------------"+
        		"\n-----------------------------------------------------------------------------------------------------------------------");
        
        Paragraph name = new Paragraph("Passenger name : Mr./Ms./Mrs. "+passenger.getPassengerName());
        Paragraph flight = new Paragraph("Flight ID :  "+flightDetail.getFlight_id()+"\nSource : "+flightDetail.getSource()+"\nDestination : "+flightDetail.getDest());
        Paragraph deptDetails = new Paragraph("Departure Date :  "+formatter.format(flightDetail.getDeptDate()));
        Paragraph arrDetails = new Paragraph("Source Departure Time : "+flightDetail.getDeptTime()+"\nDestination Arrival Time : "+flightDetail.getArrivalTime());
        Paragraph end = new Paragraph("-----------------------------------------------------------------------------------------------------------------------");
        document.add(title);
        document.add(name);
        document.add(flight);
        document.add(deptDetails);
        document.add(arrDetails);
        document.add(end);
        document.close();
        
        ServletOutputStream out = response.getOutputStream();
        baos.writeTo(out);
        out.flush();
        
        
		}
		
		catch(Exception e)
		{
			System.out.println("Could not add ticket object"+e.getMessage());
		}
		
		//return "mybooked";
		
	}
	@RequestMapping("/logout")
	protected ModelAndView logout()
	{
		session.setAttribute("passenger", null);
		session.invalidate();
		ModelAndView modelandview = new ModelAndView("index");
		return modelandview;
	}
}


