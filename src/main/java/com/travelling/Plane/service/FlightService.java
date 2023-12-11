package com.travelling.Plane.service;

import com.travelling.Plane.bean.Flight;

import java.util.List;

public interface FlightService
{
    public void addFlight(Flight flight);
    public List<Flight> getFlights();
    public Flight getFlight(int flightId);
    public void deleteFlight(int flightId);



}
