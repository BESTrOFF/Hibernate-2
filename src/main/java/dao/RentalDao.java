package dao;

import entities.Actor;
import entities.Rental;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class RentalDao extends AbstractDao<Rental> {
    public RentalDao(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }
}
