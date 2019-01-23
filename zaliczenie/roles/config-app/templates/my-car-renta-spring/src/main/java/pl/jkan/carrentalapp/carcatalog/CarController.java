package pl.jkan.carrentalapp.carcatalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
class CarController {

    CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    List<Car> list() {
        ArrayList<Car> cars = new ArrayList();
        carRepository.findAll()
                .forEach((car) -> cars.add(car));

        return cars;
    }

    @GetMapping("/cars/{id}")
    Car carDetails(@PathVariable Long id) {
        return carRepository.findById(id)
                .orElseThrow(() ->new IllegalStateException());
    }

    @PostMapping("/cars")
    void createCar(@RequestBody Car car) {
        carRepository.save(car);
    }

    @DeleteMapping("/cars/{id}")
    void deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
    }

    @PutMapping("/cars/{id}")
    void updateCar(@PathVariable Long id, @RequestBody Car car) {
        Car loaded = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("no such car"));

        loaded.setModel(car.getModel());
        loaded.setName(car.getName());
        loaded.setSegment(car.getSegment());
        loaded.setCapacity(car.getCapacity());

        carRepository.save(loaded);
    }
}
