package com.example.bootstrap;

import com.example.entity.Car;
import com.example.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    CarRepository carRepository;

    public DataGenerator(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run (String... args) throws Exception{
        Car c1 = new Car("BMW", "M3");
        Car c2 = new Car("Honda", "Civic");
        Car c3 = new Car("Toyota", "Yaris");

        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);

    }
}
