package dao;

import entities.Actor;
import entities.FilmText;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class FilmTextDao extends AbstractDao<FilmText> {
    public FilmTextDao(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}
