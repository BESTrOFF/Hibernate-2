package dao;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AbstractDao<T> {
    private final Class<T> clazz;
    private SessionFactory sessionFactory;

    public AbstractDao(Class<T> clazz, SessionFactory session) {
        this.clazz = clazz;
        this.sessionFactory = session;
    }

    public T getById(final long id) {
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }

    public List<T> getList(int offset, int max) {
        Query query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName(), clazz);
        query.setFirstResult(offset);
        query.setMaxResults(max);
        return query.getResultList();
    }

    public List<T> getAll(){
        Query query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName(), clazz);
        return query.getResultList();
    }

    public T save(T entity){
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    public T update(T entity){
        return (T) sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(T entity){
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void deleteById(long id){
        T entityToDelete = getById(id);
        delete(entityToDelete);
    }
}
