package dao;

import entities.Actor;
import entities.Inventory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class InventoryDao extends AbstractDao<Inventory> {
    public InventoryDao(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }
}
