package rentacar.reto_3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rentacar.reto_3.Model.Car;
import rentacar.reto_3.Repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Optional<Car> getCar(int id) {
        return carRepository.getCar(id);
    }

    public Car save(Car car) {
        //Validaciones:
        if (car.getIdCar() == null) { //Si el carro no tiene id entonces los guardamos
            return carRepository.save(car);
        } else {
            Optional<Car> carFinded = getCar(car.getIdCar());
            if (carFinded.isEmpty()) { //Si el carro encontrado no tiene ID, entonces lo guardamos
                return carRepository.save(car);
            } else {
                return car; //En caso contrario; es decir, si tiene id returnamos ese carro con el ID
            }
        }
    }

    public Car update(Car car) {
        if (car.getIdCar() != null) { //Si tiene un ID para modificar.
            Optional<Car> carFinded = getCar(car.getIdCar()); //Buscamos ese carro.
            if (carFinded.isPresent()) {//Si existe entonces validamos sus valores:
                if (car.getBrand() != null) { //Tiene un valor en la marca, podemos sobreescribir.
                    carFinded.get().setBrand(car.getBrand());
                }
                if (car.getName() != null) {
                        carFinded.get().setName(car.getName());
                    }
                if (car.getGama() != null) {
                        carFinded.get().setGama(car.getGama());
                    }
                if (car.getYear() != null) {
                        carFinded.get().setYear(car.getYear());
                    }
                if (car.getDescription() != null) {
                        carFinded.get().setDescription(car.getDescription());
                    }
                    return carRepository.save(carFinded.get());
                }else {
                return car;
            }
        }else {
            return car;
        }
    }

    public boolean deleteCar (int id){
        Boolean respuesta= getCar(id).map(car -> {  //Vamos a intentar eliminar el carro,
            carRepository.delete(car);              //si se puede borrar el car, entonces devuelve true, sino entonces false
            return true;
        }).orElse(false);
        return respuesta;
    }




}