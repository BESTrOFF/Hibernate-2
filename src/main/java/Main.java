import dao.*;
import entities.*;

import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Properties;

public class Main {

    private final SessionFactory sessionFactory;

    private final ActorDao actorDao;
    private final AddressDao addressDao;
    private final CategoryDao categoryDao;
    private final CityDao cityDao;
    private final CountryDao countryDao;
    private final CustomerDao customerDao;
    private final FilmDao filmDao;
    private final FilmTextDao filmTextDao;
    private final InventoryDao inventoryDao;
    private final LanguageDao languageDao;
    private final PaymentDao paymentDao;
    private final RentalDao rentalDao;
    private final StaffDao staffDao;
    private final StoreDao storeDao;

    public Main() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        properties.put(Environment.DRIVER, "com.p6spy.engine.spy.P6SpyDriver");
        properties.put(Environment.URL, "jdbc:p6spy:mysql://localhost:3306/project");
        properties.put(Environment.USER, "root");
        properties.put(Environment.PASS, "Anna_Bologan_27");
        properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        properties.put(Environment.HBM2DDL_AUTO, "validate");

        sessionFactory = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Category.class)
                .addAnnotatedClass(City.class)
                .addAnnotatedClass(Country.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Film.class)
                .addAnnotatedClass(FilmText.class)
                .addAnnotatedClass(Inventory.class)
                .addAnnotatedClass(Language.class)
                .addAnnotatedClass(Payment.class)
                .addAnnotatedClass(Rental.class)
                .addAnnotatedClass(Staff.class)
                .addAnnotatedClass(Store.class)
                .addProperties(properties)
                .buildSessionFactory();

        actorDao = new ActorDao(sessionFactory);
        addressDao = new AddressDao(sessionFactory);
        categoryDao = new CategoryDao(sessionFactory);
        cityDao = new CityDao(sessionFactory);
        countryDao = new CountryDao(sessionFactory);
        customerDao = new CustomerDao(sessionFactory);
        filmDao = new FilmDao(sessionFactory);
        filmTextDao = new FilmTextDao(sessionFactory);
        inventoryDao = new InventoryDao(sessionFactory);
        languageDao = new LanguageDao(sessionFactory);
        paymentDao = new PaymentDao(sessionFactory);
        rentalDao = new RentalDao(sessionFactory);
        staffDao = new StaffDao(sessionFactory);
        storeDao = new StoreDao(sessionFactory);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.createNewCustomer();
    }

    private Customer createNewCustomer() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            City city = session.get(City.class, 1);
            Country country = session.get(Country.class,1);
            city.setCity("Solnechnogorsk");
            city.setCountry(country);

            Store store = session.get(Store.class, 1);

            Address address = session.get(Address.class, 1);
            address.setAddress("Solnechnogorsk");
            address.setDistrict("CMIS");
            address.setCity(city);
            address.setPhone("89629471519");
            session.save(address);

            Customer customer = new Customer();
            customer.setStore(store);
            customer.setFirstName("Anna");
            customer.setLastName("Cat");
            customer.setAddress(address);
            session.save(customer);

            transaction.commit();
            return customer;
        }
    }
}