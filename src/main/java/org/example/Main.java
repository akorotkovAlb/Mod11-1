package org.example;

import org.example.dao.project.ProjectDaoImpl;
import org.example.enitty.Project;

import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<Project> result = new ProjectDaoImpl().getLongestProjects();
        result.forEach(p -> System.out.println(p.getName()));
    }
}