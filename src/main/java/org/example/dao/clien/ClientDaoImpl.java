package org.example.dao.clien;

import org.example.enitty.Client;
import org.example.enitty.Project;
import org.example.enitty.Worker;
import org.example.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClientDaoImpl implements ClientDao {

    @Override
    public Client findById (Long clientId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            System.out.println("----> start query <-----");
            Client client = session.get(Client.class, clientId);
            System.out.println("----> finish query <-----");

//            // TODO: for lazy loading. Initiate get projects
//            client.getProjects().forEach(Project::getId);
            return client;
        }
    }

    @Override
    public boolean createClient(Client client) {
        boolean result = false;
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                client.setId(null);
                session.persist(client);
                transaction.commit();
                result = true;
            } catch(Exception ex) {
                ex.printStackTrace();
                transaction.rollback();
            }
        }
        return result;
    }

    @Override
    public void deleteClientById (Long clientId) {
        try (Session session = HibernateUtils.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Client existing = session.get(Client.class, clientId);
            session.remove(existing);
            transaction.commit();
        }
    }
}
