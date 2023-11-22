package org.example.dao.clien;

import org.example.enitty.Client;

public interface ClientDao {

    Client findById(Long clientId);

    boolean createClient(Client client);

    void deleteClientById (Long clientId);
}
