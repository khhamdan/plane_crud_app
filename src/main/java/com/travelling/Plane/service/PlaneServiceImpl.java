package com.travelling.Plane.service;

import com.travelling.Plane.bean.Plane;
import com.travelling.Plane.dao.PlaneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("planeService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class PlaneServiceImpl implements PlaneService
{
    @Autowired
    private PlaneDao planeDao;

    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void addPlane(Plane plane)
    {
            planeDao.addPlane(plane);
    }

    @Override
    public List<Plane> getPlanes() {
        return planeDao.getPlanes();
    }

    @Override
    public Plane getPlane(int planeId)
    {
        return planeDao.getPlane(planeId);
    }

    @Override
    public void deletePlane(int planeId)
    {
        planeDao.deletePlane(planeId);
    }
}
