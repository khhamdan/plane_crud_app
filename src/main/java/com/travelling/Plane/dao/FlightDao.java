package com.travelling.Plane.dao;

import com.travelling.Plane.bean.Flight;

import java.util.List;

public interface FlightDao
{
    public void addFlight(Flight flight);

    public List<Flight> getFlights();

    public Flight getFlight(int flightId);

    public void deleteFlight(int flightId);
}
