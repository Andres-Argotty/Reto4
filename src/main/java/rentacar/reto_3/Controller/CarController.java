package rentacar.reto_3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rentacar.reto_3.Model.Car;
import rentacar.reto_3.Service.CarService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods ={RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Car") //Endpoint Base
public class CarController {

    @Autowired
    private CarService carService;
    @GetMapping("/all") // Al ser una petición Get utilizamos el GetMapping, la ruta sería localhost.../api/Car/all
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}") //Para poder enviar el id a la hora de realizar la petición ej. /api/Car/12
    public Optional<Car> getCar (@PathVariable int id){ //PathVariable especifica que el valor del {id} sea el que
        return carService.getCar(id);        //Entra por parametro desde la url.
    }
    @PostMapping("/save")
    @ResponseStatus (HttpStatus.CREATED)
    //Necesitamos especificar el cuerpo de la petición
    public Car save (@RequestBody Car car){
        return carService.save(car);
    }



}
