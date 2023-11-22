package org.example;

import org.example.dao.clien.ClientDao;
import org.example.dao.clien.ClientDaoImpl;
import org.example.dao.project.ProjectDaoImpl;
import org.example.enitty.Client;
import org.example.enitty.Project;
import org.example.hibernate.HibernateUtils;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main (String[] args) {
//        List<Project> result = new ProjectDaoImpl().getLongestProjects();
//        result.forEach(p -> System.out.println(p.getName()));

//        Client client = new Client();
//        client.setName("222 Client");
//        Project project = new Project();
//        project.setName("222 project");
//        project.setStartDate(LocalDate.now());
//        project.setFinishDate(LocalDate.now().plusMonths(3));
//        project.setClient(client);
//        client.getProjects().add(project);
//
//        ClientDao dao = new ClientDaoImpl();
//        boolean result = dao.createClient(client);
//        System.out.println("result ===> " + result);

        ClientDao dao = new ClientDaoImpl();
        dao.deleteClientById(2L);
    }
}