package dockertp1.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dockertp1.entities.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RentServiceRestTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testAddCar() throws Exception {
        Car car = new Car("ABC123", "Toyota", 15000.0);

        mockMvc.perform(post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCars() throws Exception {
        mockMvc.perform(get("/cars"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCarByPlateNumber() throws Exception {
        // D'abord ajouter une voiture
        Car car = new Car("TEST001", "Peugeot", 18000.0);
        mockMvc.perform(post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(car)))
                .andExpect(status().isOk());

        // Puis la récupérer par plaque
        mockMvc.perform(get("/cars/TEST001"))
                .andExpect(status().isOk());
    }
}
