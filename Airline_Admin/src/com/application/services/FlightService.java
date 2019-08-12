package com.application.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.domain.Admin;
import com.application.domain.Airplane;
import com.application.domain.FlightDetails;

@Service
public class FlightService {

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
	public void insertFlight(FlightDetails flightObj) {
		sessionFactory.getCurrentSession().save(flightObj);
	}
	
	@Transactional
	public void insertAdmin(Admin admin) {
		sessionFactory.getCurrentSession().save(admin);
	}
	
	@Transactional
	public Admin checkAdmin(String userName, String password)
	{
		criteria = sessionFactory.getCurrentSession().createCriteria(Admin.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password",password));
		return (Admin)criteria.uniqueResult();
	}

	@Transactional
	public List<FlightDetails> getAllFlights() {
		List<FlightDetails> list = sessionFactory.getCurrentSession().createCriteria(FlightDetails.class).list();
		return list;
	}
	@Transactional
	public List<Airplane> getAllAirplanes() {
		criteria = sessionFactory.getCurrentSession().createCriteria(Airplane.class);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	
	@Transactional
	public void insertAirline(Airplane airplane) {
		sessionFactory.getCurrentSession().save(airplane);
	}

	@Transactional
	public void updateFlightDetails(FlightDetails flight) {
		sessionFactory.getCurrentSession().update(flight);
	}
	
	@Transactional
	public FlightDetails getFlightById(Long fId) {
		criteria = sessionFactory.getCurrentSession().createCriteria(FlightDetails.class);
		criteria.add(Restrictions.eq("flight_id", fId));
		return (FlightDetails)criteria.uniqueResult();
	}

	@Transactional
	public void deleteFl(FlightDetails fd) {
		sessionFactory.getCurrentSession().delete(fd);
	}

}
