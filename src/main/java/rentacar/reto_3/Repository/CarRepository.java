package rentacar.reto_3.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rentacar.reto_3.Model.Car;
import rentacar.reto_3.Repository.CRUD.CarCrudRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class CarRepository {
    @Autowired //Pasa el contexto a SpringBoot
    private CarCrudRepository carCrudRepository;

    public List<Car> findAll(){
        return (List<Car>) carCrudRepository.findAll();
    }
    public Optional<Car>getCar(int id){
        return carCrudRepository.findById(id);
    }
    public Car save(Car car){
        return carCrudRepository.save(car);
    }
    public void delete(Car car){
        carCrudRepository.delete(car);
    }
}
