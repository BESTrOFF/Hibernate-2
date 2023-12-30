package dao;

import entities.Actor;
import entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CategoryDao extends AbstractDao<Category> {
    public CategoryDao(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
