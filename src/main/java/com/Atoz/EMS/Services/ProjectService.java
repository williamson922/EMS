package com.Atoz.EMS.Services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.Atoz.EMS.Model.DTO.ProjectDTO;
import com.Atoz.EMS.Model.Entity.Project;
import com.Atoz.EMS.Repositories.ProjectRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepo projectRepo;
    private final ModelMapper modelMapper;

    public ProjectService(ProjectRepo projectRepo, ModelMapper modelMapper) {
        this.projectRepo = projectRepo;
        this.modelMapper = modelMapper;
    }

    public List<ProjectDTO> getProjects() {
        List<Project> projects = projectRepo.findAll();
        return projects.stream()
                .map(
                        project -> modelMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toList());
    }

    public ProjectDTO getProject(Long id) {
        Optional<Project> optProject = projectRepo.findById(id);
        return modelMapper.map(optProject, ProjectDTO.class);
    }

    public ProjectDTO addNewProject(ProjectDTO dto) {
        Project project = modelMapper.map(dto, Project.class);
        projectRepo.save(project);
        return modelMapper.map(project, ProjectDTO.class);
    }

    public ProjectDTO updateProject(Long id, ProjectDTO dto) {
        return null;
    }

    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }
}
