package com.travelling.Plane.dao;

import com.travelling.Plane.bean.Plane;

import java.util.List;

public interface PlaneDao
{

    public void addPlane(Plane plane);

    public List<Plane> getPlanes();

    public Plane getPlane(int planeId);

    public void deletePlane(int planeId);
}
