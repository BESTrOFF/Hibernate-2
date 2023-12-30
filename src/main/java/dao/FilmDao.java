package dao;

import entities.Actor;
import entities.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FilmDao extends AbstractDao<Film> {
    public FilmDao(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }
}
