package dockertp1.services;

import dockertp1.entities.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarServiceTest {

    private CarService carService;

    @BeforeEach
    public void setUp() {
        carService = new CarService();
    }

    @Test
    public void testAddCar() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        Car result = carService.addCar(car);

        assertEquals("ABC123", result.getPlateNumber());
        assertEquals(1, carService.getCars().size());
    }

    @Test
    public void testGetCars() {
        carService.addCar(new Car("ABC123", "Toyota", 15000.0));
        carService.addCar(new Car("DEF456", "Renault", 20000.0));

        List<Car> cars = carService.getCars();
        assertEquals(2, cars.size());
    }

    @Test
    public void testGetCarByPlateNumber() {
        carService.addCar(new Car("ABC123", "Toyota", 15000.0));
        carService.addCar(new Car("DEF456", "Renault", 20000.0));

        Car found = carService.getCarByPlateNumber("DEF456");
        assertNotNull(found);
        assertEquals("Renault", found.getBrand());
        assertEquals(20000.0, found.getPrice());
    }

    @Test
    public void testGetCarByPlateNumberNotFound() {
        Car found = carService.getCarByPlateNumber("UNKNOWN");
        assertNull(found);
    }
}
