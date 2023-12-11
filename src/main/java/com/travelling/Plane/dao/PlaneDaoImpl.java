package com.travelling.Plane.dao;

import com.travelling.Plane.bean.Plane;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("planeDao")
public class PlaneDaoImpl implements PlaneDao
{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void addPlane(Plane plane)
    {
    sessionFactory.getCurrentSession().saveOrUpdate(plane);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Plane> getPlanes() {
        return (List<Plane>) sessionFactory.getCurrentSession().createCriteria(Plane.class).list();
    }

    @Override
    public Plane getPlane(int planeId) {
        return (Plane) sessionFactory.getCurrentSession().get(Plane.class,planeId);
    }

    @Transactional
    @Override
    public void deletePlane(int planeId)
    {
        sessionFactory.getCurrentSession().createQuery("DELETE FROM Plane WHERE planeId="+planeId).executeUpdate();
    }
}
