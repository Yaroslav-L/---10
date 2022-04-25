package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.User;
import com.example.demo.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> findAllClient() { return clientRepo.findAll();}

    public Client findClientById(Integer id){
        return clientRepo.getOne(id);
    }

    public Client saveClient(Client client){
        return  clientRepo.save(client);
    }

    public void deleteClientById(Integer id){
        clientRepo.deleteById(id);
    }
}
