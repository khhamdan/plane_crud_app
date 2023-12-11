package com.travelling.Plane.service;

import com.travelling.Plane.bean.Plane;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PlaneService
{
    public void addPlane(Plane plane);

    public List<Plane> getPlanes();

    public Plane getPlane(int planeId);

    public void deletePlane(int planeId);

}
