package org.example.dao.project;

import org.example.enitty.Project;

import java.util.List;

public interface ProjectDao {

    void deleteById (Long id);

    List<Project> getLongestProjects();
}
