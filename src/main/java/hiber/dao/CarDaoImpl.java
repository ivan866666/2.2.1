package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
@Repository
public class CarDaoImpl implements CarDao{
    private final SessionFactory sessionFactory;

    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);

    }

    @Override
    public List<Car> listCars() {
        TypedQuery<Car> query = sessionFactory
                .getCurrentSession()
                .createQuery("from Car");
        return query.getResultList();
    }

    @Override
    public Optional<User> getUserByCar(String model, int series) {
        TypedQuery<User> query = sessionFactory
                .getCurrentSession()
                .createQuery("from User user where user.cars.model" +
                        " = :model and user.cars.series = :series");
        return query.getResultStream()
                .findAny();
    }
}