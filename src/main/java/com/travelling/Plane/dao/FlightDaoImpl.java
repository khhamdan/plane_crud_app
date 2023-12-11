package com.travelling.Plane.dao;

import com.travelling.Plane.bean.Flight;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Repository("flightDao")
public class FlightDaoImpl implements FlightDao{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addFlight(Flight flight) {
        sessionFactory.getCurrentSession().saveOrUpdate(flight);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Flight> getFlights() {
        return (List<Flight>) sessionFactory.getCurrentSession().createCriteria(Flight.class).list();
    }

    @Override
    public Flight getFlight(int flightId) {
        return (Flight) sessionFactory.getCurrentSession().get(Flight.class,flightId);
    }
    @Transactional
    @Override
    public void deleteFlight(int flightId) {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Flight WHERE flightId = "+flightId).executeUpdate();
    }
    }


