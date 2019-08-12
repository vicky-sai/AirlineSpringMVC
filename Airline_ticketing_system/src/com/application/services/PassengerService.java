package com.application.services;


import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.domain.Address;
import com.application.domain.FlightDetails;
import com.application.domain.Passenger;
import com.application.domain.Ticket;


@Service
public class PassengerService  {

	Criteria criteria = null;
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	@Transactional
	public void saveUserObj(Passenger userObj) {
		sessionFactory.getCurrentSession().save(userObj);
	}
	
	@Transactional
	public Passenger checkUser(String userName, String password)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(Passenger.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password",password));
		return (Passenger)criteria.uniqueResult();
	}
	@Transactional
	public FlightDetails getFlightById(long flight_id)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(FlightDetails.class);
		criteria.add(Restrictions.eq("flight_id", flight_id));
		return (FlightDetails)criteria.uniqueResult();
	}
	@Transactional
	public List<FlightDetails> getSelectedFlights(String source, String dest, String travelClass, Date deptDate) {
		criteria = sessionFactory.getCurrentSession().createCriteria(FlightDetails.class);
		criteria.add(Restrictions.like("source", source));
		criteria.add(Restrictions.like("dest",dest));
		criteria.add(Restrictions.like("travelClass",travelClass));
		criteria.add(Restrictions.like("deptDate",deptDate));
		return criteria.list();
	}
	@Transactional
	public List<Ticket> getPassTickets(Passenger p) {
		criteria = sessionFactory.getCurrentSession().createCriteria(Ticket.class);
		//criteria.createAlias("ticket", "t");
		criteria.add(Restrictions.eq("passenger.passenger_id", p.getPassenger_id()) );
		return criteria.list();
		
	/*	String hql = "FROM Ticket T WHERE T.passenger_id = "+p.passenger_id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		*/
	}
	@Transactional
	public void saveTicket(Ticket t) {
		sessionFactory.getCurrentSession().save(t);
	}
	@Transactional
	public Ticket getTicketById(long ticket_id)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(Ticket.class);
		criteria.add(Restrictions.eq("ticket_id", ticket_id));
		return (Ticket)criteria.uniqueResult();
	}
	@Transactional
	public void cancelTicket(Ticket t) {
		FlightDetails f =  t.getFlightDetails();
		f.setAvailableSeats(t.getFlightDetails().getAvailableSeats()+t.getCount());
		sessionFactory.getCurrentSession().update(f);
		sessionFactory.getCurrentSession().delete(t);
	}

	@Transactional
	public void updateFlight(FlightDetails fd) {
		sessionFactory.getCurrentSession().update(fd);
	}
}

