package dao;

import entities.Actor;
import entities.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CityDao extends AbstractDao<City>{

    public CityDao(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }
}
