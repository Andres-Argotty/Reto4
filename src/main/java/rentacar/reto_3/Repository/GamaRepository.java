package rentacar.reto_3.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rentacar.reto_3.Model.Car;
import rentacar.reto_3.Model.Gama;
import rentacar.reto_3.Repository.CRUD.CarCrudRepository;
import rentacar.reto_3.Repository.CRUD.GamaCrudRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class GamaRepository {
    @Autowired //Pasa el contexto a SpringBoot
    private GamaCrudRepository gamaCrudRepository;

    public List<Gama> findAll(){
        return (List<Gama>) gamaCrudRepository.findAll();
    }
    public Optional<Gama> getGama(int id){
        return gamaCrudRepository.findById(id);
    }
    public Gama save(Gama gama){
        return gamaCrudRepository.save(gama);
    }
    public void delete(Gama gama){
        gamaCrudRepository.delete(gama);
    }
}
