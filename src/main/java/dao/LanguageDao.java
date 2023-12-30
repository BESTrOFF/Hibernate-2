package dao;

import entities.Actor;
import entities.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LanguageDao extends AbstractDao<Language> {
    public LanguageDao(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}
