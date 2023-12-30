package dao;

import entities.Actor;
import entities.Payment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PaymentDao extends AbstractDao<Payment> {
    public PaymentDao(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}
