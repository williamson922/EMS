package com.Atoz.EMS.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Atoz.EMS.Model.DTO.ProjectDTO;
import com.Atoz.EMS.Model.Entity.Project;
import com.Atoz.EMS.Repositories.ProjectRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    private ProjectDTO convertToDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setProjectName(project.getProjectName());
        return dto;
    }

    private List<ProjectDTO> convertToDTOs(List<Project> projects) {
        return projects.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private Project convertProjectDTOtoEntity(ProjectDTO dto) {
        return new Project(dto.getId(), dto.getProjectName());
    }

    public List<ProjectDTO> getProjects() {
        return convertToDTOs(projectRepo.findAll());
    }

    public ProjectDTO getProject(Long id) {
        Optional<Project> optProject = projectRepo.findById(id);
        if (optProject.isPresent()) {
            Project project = optProject.get();
            ProjectDTO dto = convertToDTO(project);
            return dto;
        }
        return null;
    }

    public ProjectDTO addNewProject(ProjectDTO dto) {
        Project project = convertProjectDTOtoEntity(dto);
        projectRepo.save(project);
        return dto;
    }

    public ProjectDTO updateProject(Long id, ProjectDTO dto) {
        return null;
    }

    public void deleteProject(Long id) {
        projectRepo.deleteById(id);
    }
}
