package hiber.service;

import hiber.dao.CarDao;
import hiber.model.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
public class CarServiceImp implements CarService{
    private final CarDao carDao;

    public CarServiceImp(CarDao carDao){
        this.carDao = carDao;
    }
    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);

    }
    @Transactional(readOnly = true)
    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }

    @Override
    public Optional<User> getUserByCar(String model, int series) {
        return carDao.getUserByCar(model, series);
    }
}