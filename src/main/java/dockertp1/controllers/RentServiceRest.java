package dockertp1.controllers;

import dockertp1.entities.Car;
import dockertp1.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentServiceRest {

    @Autowired
    private CarService carService;

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping("/cars")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping("/cars/{plateNumber}")
    public Car getCarByPlateNumber(@PathVariable String plateNumber) {
        return carService.getCarByPlateNumber(plateNumber);
    }
}
