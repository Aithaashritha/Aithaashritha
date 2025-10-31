package com.example.client360.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.client360.entity.Client;
import com.example.client360.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    // GET all clients
    @GetMapping
    public List<Client> getAllClients() {
        return service.getAllClients();
    }

    // GET client by ID
    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return service.getClientById(id);
    }

    // POST create new client
    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return service.createClient(client);
    }

    // PUT update client
    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        return service.updateClient(id, updatedClient);
    }

    // DELETE client
    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
        return "Client with ID " + id + " deleted successfully!";
    }
}
