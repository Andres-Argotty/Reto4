package rentacar.reto_3.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rentacar.reto_3.Model.Car;
import rentacar.reto_3.Model.Client;
import rentacar.reto_3.Repository.CRUD.CarCrudRepository;
import rentacar.reto_3.Repository.CRUD.ClientCrudRepository;

import java.util.List;
import java.util.Optional;
@Repository
public class ClientRepository {
    @Autowired //Pasa el contexto a SpringBoot
    private ClientCrudRepository clientCrudRepository;

    public List<Client> findAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
}
