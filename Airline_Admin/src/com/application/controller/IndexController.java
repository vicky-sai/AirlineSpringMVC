package com.application.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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
	@Autowired
	private FlightService flightService;
	
	@Autowired
	public HttpSession session;
	 @InitBinder
	 public void initBinder(WebDataBinder binder) {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        sdf.setLenient(true);
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	 
	 @RequestMapping("/index")
	    protected ModelAndView index()
		{
		 if(session.getAttribute("admin")==null)
			 return new ModelAndView("login");
			ModelAndView modelandview = new ModelAndView("index");
			modelandview.addObject("message", "Click on the tabs for actions..");
	        return modelandview;
	    }
	 @RequestMapping("/login")
	 protected String login() {
		 if(session.getAttribute("admin")!=null)
			 return "index";
	      return "login";
	 }
	 @RequestMapping("/signup")
	 protected String signup() {
		 if(session.getAttribute("admin")!=null)
			 return "index";
	        return "signup";
	 }
	
	@RequestMapping("/validateLogin")
    protected ModelAndView validLogin(@RequestParam("userName")String userName, @RequestParam("password")String password)
	{
		Admin a = flightService.checkAdmin(userName, password);
        if(a==null)
		{
        	ModelAndView modelandview = new ModelAndView("login");
			modelandview.addObject("error","Invalid login credentials!!");
			return modelandview;
		}
		else if(a.getUserName().equals(userName)&&a.getPassword().equals(password))
		{
			//session.
			session.setAttribute("admin", a);
			return new ModelAndView("index","message", "Click on the tabs for actions..");
		}
		else
		{
			ModelAndView modelandview = new ModelAndView("index");
			modelandview.addObject("error","Invalid login credentials..");
			return modelandview;
		}
    }
	
	@RequestMapping("/registration")
    protected String registration(@ModelAttribute("admin") Admin admin,BindingResult result) {
		if(result.hasErrors())
			return "signup";
		flightService.insertAdmin(admin);
        return "login";
    }
	
	@RequestMapping("/add_airline")
	protected String addAirline()
	{
		if(session.getAttribute("admin")==null)
			 return "login";
        return "add_airline";
	}
	@RequestMapping("/insert_airline")
	protected ModelAndView insertAirline(@ModelAttribute("airplane") Airplane airplane, BindingResult result)
	{
		if(session.getAttribute("admin")==null)
			 return new ModelAndView("login");
		ModelAndView modelandview = new ModelAndView("index");
		if(result.hasErrors())
		{
			modelandview.addObject("message","Please fill the signup form correctly..");
			return modelandview;
		}
		flightService.insertAirline(airplane);
		modelandview.addObject("message", "Airline details entered Successsfully");
        return modelandview;
	}
	@RequestMapping("/add_flight")
	protected ModelAndView addFlight()
	{
		if(session.getAttribute("admin")==null)
			 return new ModelAndView("login");
		ModelAndView modelandview = new ModelAndView("add_flight");
		List<Airplane> list = flightService.getAllAirplanes();
		modelandview.addObject("airplane_list", list);
        return modelandview;
	}
	@RequestMapping("/insert_flight")
	protected ModelAndView insertFlight(@ModelAttribute("flight") FlightDetails flight, BindingResult result )
	{
		if(session.getAttribute("admin")==null)
			 return new ModelAndView("login");
		ModelAndView modelandview = new ModelAndView("index");
		if(result.hasErrors())
		{
			modelandview.addObject("message","Please fill the signup form correctly..");
			return modelandview;
		}
		flightService.insertFlight(flight);
		modelandview.addObject("message", "Flight details entered Successsfully");
        return modelandview;
	}
	@RequestMapping("/display_flights")
	protected ModelAndView displayFlights()
	{
		if(session.getAttribute("admin")==null)
			 return new ModelAndView("login");
		ModelAndView modelandview = new ModelAndView("display_flights");
		List<FlightDetails> list = flightService.getAllFlights();
		modelandview.addObject("message", "List of all flights");
		modelandview.addObject("allFlights", list);
        return modelandview;
	}
	@RequestMapping("/update_flight")
	protected ModelAndView updateFlight()
	{
		if(session.getAttribute("admin")==null)
			 return new ModelAndView("login");
		ModelAndView modelandview = new ModelAndView("update_flight");
		List<FlightDetails> list = flightService.getAllFlights();
		modelandview.addObject("allFlightId", list);
        return modelandview;
	}
	@RequestMapping("/update")
	protected ModelAndView updateFlightMethod(@ModelAttribute("flight") FlightDetails flight, BindingResult result )
	{
		if(session.getAttribute("admin")==null)
			 return new ModelAndView("login");
		ModelAndView modelandview = new ModelAndView("index");
		if(result.hasErrors())
		{
			modelandview.addObject("message","Please update the flight with correct details..");
			return modelandview;
		}
		flightService.updateFlightDetails(flight);
		modelandview.addObject("message", "Flight details updated Successsfully");
        return modelandview;
	}
	@RequestMapping("/delete_flight")
	protected ModelAndView deleteFlight()
	{
		if(session.getAttribute("admin")==null)
			 return new ModelAndView("login");
		ModelAndView modelandview = new ModelAndView("delete_flight");
		List<FlightDetails> list = flightService.getAllFlights();
		modelandview.addObject("message", "List of all flights");
		modelandview.addObject("allFlights", list);
        return modelandview;
	}
	@RequestMapping("/deleteFli")
	protected ModelAndView deleteFlightMethod(@RequestParam("fId") Long fId)
	{
		if(session.getAttribute("admin")==null)
			 return new ModelAndView("login");
		ModelAndView modelandview = new ModelAndView("index");
		FlightDetails fd = flightService.getFlightById(fId);
		flightService.deleteFl(fd);
		modelandview.addObject("message", "Flight deleted successfully..");
        return modelandview;
	}
	@RequestMapping("/logout")
	protected String logout()
	{
		session.setAttribute("admin", null);
		session.invalidate();
        return "login";
	}
}


