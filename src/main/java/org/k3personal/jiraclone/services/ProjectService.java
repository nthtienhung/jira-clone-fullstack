package org.k3personal.jiraclone.services;

import org.k3personal.jiraclone.domain.Project;
import org.k3personal.jiraclone.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    //service to relate to db
    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        //all the logic goes in here

        return projectRepository.save(project);
    }
}
