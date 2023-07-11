package hiber.service;

import hiber.model.*;

import java.util.List;
import java.util.Optional;


public interface CarService {
    void add(Car car);
    List<Car> listCars();
    public Optional<User> getUserByCar(String model, int series);
}