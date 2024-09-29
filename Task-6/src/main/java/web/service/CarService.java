package web.service;


import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class CarService {

    private final List<Car> cars = Arrays.asList(
            new Car("Porshe","CUV",30000),
            new Car("BWM","Sedan",20000),
            new Car("Mercedes-Benz","Off-road",10000),
            new Car("Audi","Micro",15000),
            new Car("Honda","Pickup",25000)
    );

    public List<Car> getCars(Integer count) {
        if(count >= cars.size() || count == null) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
