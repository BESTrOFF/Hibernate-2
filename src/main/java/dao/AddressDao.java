package dao;

import entities.Actor;
import entities.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddressDao extends AbstractDao<Address>{
    public AddressDao(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}
