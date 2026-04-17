package dockertp1.services;

import dockertp1.entities.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private final List<Car> cars = new ArrayList<>();

    public Car addCar(Car car) {
        cars.add(car);
        return car;
    }

    public List<Car> getCars() {
        return cars;
    }

    public Car getCarByPlateNumber(String plateNumber) {
        return cars.stream()
                .filter(car -> car.getPlateNumber().equals(plateNumber))
                .findFirst()
                .orElse(null);
    }
}
