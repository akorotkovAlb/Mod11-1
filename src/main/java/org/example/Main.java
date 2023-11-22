package org.example;

import org.example.dao.clien.ClientDaoImpl;
import org.example.dao.project.ProjectDaoImpl;
import org.example.enitty.Client;
import org.example.enitty.Project;
import org.example.hibernate.HibernateUtils;

import java.util.List;

public class Main {
    public static void main (String[] args) {
//        List<Project> result = new ProjectDaoImpl().getLongestProjects();
//        result.forEach(p -> System.out.println(p.getName()));

        Client client = new ClientDaoImpl().findById(1L);
        System.out.println("===>>> " + client.getName());

        client.getProjects().forEach(p -> System.out.println(p.getName()));
    }
}