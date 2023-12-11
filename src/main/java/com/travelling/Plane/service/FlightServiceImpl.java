package com.travelling.Plane.service;

import com.travelling.Plane.bean.Flight;
import com.travelling.Plane.dao.FlightDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("flightService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FlightServiceImpl implements FlightService
{
    @Autowired
    private FlightDao flightDao;

    @Transactional(propagation = Propagation.REQUIRED,readOnly =false)
    public void addFlight(Flight flight)
    {
        flightDao.addFlight(flight);
    }
    @Override
    public List<Flight> getFlights() {
        return flightDao.getFlights();
    }

    @Override
    public Flight getFlight(int flightId) {
        return flightDao.getFlight(flightId);
    }

    @Override
    public void deleteFlight(int flightId)
    {
        flightDao.deleteFlight(flightId);
    }
}
