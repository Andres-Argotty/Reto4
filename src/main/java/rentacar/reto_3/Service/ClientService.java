package rentacar.reto_3.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rentacar.reto_3.Model.Client;
import rentacar.reto_3.Repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save(Client client) {
        //Validaciones:
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> clientFinded = getClient(client.getIdClient());
            if (clientFinded.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> clientFinded = getClient(client.getIdClient());
            if (clientFinded.isPresent()) {
                if (client.getEmail() != null) {
                    clientFinded.get().setEmail(client.getEmail());
                }
                if (client.getName() != null) {
                    clientFinded.get().setName(client.getName());
                }
                if (client.getAge() != null) {
                    clientFinded.get().setAge(client.getAge());
                }
                if (client.getPassword() != null) {
                    clientFinded.get().setPassword(client.getPassword());
                }
                return clientRepository.save(clientFinded.get());
            }else {
                return client;
            }
        }else {
            return client;
        }
    }

    public boolean deleteClient (int id){
        Boolean respuesta= getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return respuesta;
    }

}
