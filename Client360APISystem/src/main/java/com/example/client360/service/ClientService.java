package com.example.client360.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.client360.entity.Client;
import com.example.client360.Repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository repo;

    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    public List<Client> getAllClients() {
        return repo.findAll();
    }

    public Client getClientById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client createClient(Client client) {
        return repo.save(client);
    }

    public Client updateClient(Long id, Client updatedClient) {
        Client existing = getClientById(id);
        existing.setName(updatedClient.getName());
        existing.setEmail(updatedClient.getEmail());
        existing.setPhone(updatedClient.getPhone());
        existing.setCountry(updatedClient.getCountry());
        return repo.save(existing);
    }

    public void deleteClient(Long id) {
        repo.deleteById(id);
    }
}
