package dockertp1.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void testCarConstructor() {
        Car car = new Car("ABC123", "Toyota", 15000.0);
        assertEquals("ABC123", car.getPlateNumber());
        assertEquals("Toyota", car.getBrand());
        assertEquals(15000.0, car.getPrice());
    }

    @Test
    public void testDefaultConstructor() {
        Car car = new Car();
        assertNull(car.getPlateNumber());
        assertNull(car.getBrand());
        assertEquals(0.0, car.getPrice());
    }

    @Test
    public void testSetters() {
        Car car = new Car();
        car.setPlateNumber("XYZ789");
        car.setBrand("Renault");
        car.setPrice(20000.0);

        assertEquals("XYZ789", car.getPlateNumber());
        assertEquals("Renault", car.getBrand());
        assertEquals(20000.0, car.getPrice());
    }
}
