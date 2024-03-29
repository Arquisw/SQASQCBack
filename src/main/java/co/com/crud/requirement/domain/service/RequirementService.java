package co.com.crud.requirement.domain.service;

import co.com.crud.requirement.domain.exception.RequirementNotFoundException;
import co.com.crud.requirement.domain.model.Requirement;
import co.com.crud.requirement.domain.model.queryresult.IPerfectOrNotPerfectRequirement;
import co.com.crud.requirement.domain.model.queryresult.IRequirementByGradeAndCauseError;
import co.com.crud.requirement.domain.model.queryresult.IRequirementsByFilterCauseError;
import co.com.crud.requirement.domain.model.queryresult.ITypeConsultingProject;
import co.com.crud.requirement.domain.repository.RequirementDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static co.com.crud.requirement.domain.exception.validation.DomainValidator.*;

@Service
public class RequirementService {

    private final RequirementDomainRepository requirementDomainRepository;

    @Autowired
    public RequirementService(RequirementDomainRepository requirementDomainRepository) {
        this.requirementDomainRepository = requirementDomainRepository;
    }

    public Requirement
    saveRequirement(Requirement requirement) {
        validateMandatory(requirement.getName(), NAME_FIELD_MANDATORY);
        validateMandatory(requirement.getDescription(), DESCRIPTION_FIELD_MANDATORY);
        validateMandatory(requirement.getTypeRequirement(), TYPE_FIELD_MANDATORY);
        validateMinMaxLength(requirement.getDescription(), 5, 3000, MAX_MIN_NANE_LENGTH_MESSAGE);
        boolean exists = requirementDomainRepository.existsByProjectAndName(requirement.getName(), requirement.getProjectId());
        validateEquals(exists, false, NAME_ALREADY_EXISTS);
        requirement.setQualified(false);
        return requirementDomainRepository.saveRequirement(requirement);
    }

    public List<Requirement> getAllRequirements() {
        return requirementDomainRepository.getAllRequirements();
    }

    public Optional<Requirement> getRequirementById(Integer id) {
        Optional<Requirement> requirements = requirementDomainRepository.getRequirementById(id);
        if (requirements.isEmpty()) {
            throw new RequirementNotFoundException(id);
        }
        return requirements;
    }

    public boolean deleteRequirement(Integer requirementId) {
        return getRequirementById(requirementId).map(requirement -> {
            requirementDomainRepository.deleteRequirement(requirementId);

            return true;
        }).orElse(false);
    }

    public IRequirementsByFilterCauseError countRequirementsByFilterCauseError(Integer requirementId, Integer projectId) {
        return requirementDomainRepository.countRequirementsByFilterCauseError(requirementId, projectId);
    }

    public IRequirementByGradeAndCauseError countRequirementsByGradeAndCauseError(String typeRequirement, String causeError, Integer projectId) {
        return requirementDomainRepository.countRequirementsByGradeAndCauseError(typeRequirement, causeError, projectId);
    }

    public IPerfectOrNotPerfectRequirement countPerfectRequirements(String typeRequirement, Integer projectId) {
        return requirementDomainRepository.countPerfectRequirements(typeRequirement, projectId);
    }

    public List<Requirement> getRequirementsByProjectId(Integer projectId) {
        return requirementDomainRepository.getRequirementsByProyectoId(projectId);
    }

    public int countAllRequirements(String typeRequirement, Integer projectId) {
        return requirementDomainRepository.countAllRequirements(typeRequirement, projectId);
    }

    public void updateQualifiedByRequirementId(Integer requirementId) {
        requirementDomainRepository.updateQualifiedByRequirementId(requirementId);
    }

    public void updateProjectStatus(Integer projectId) {
        requirementDomainRepository.updateProjectStatus(projectId);
    }

    public void deleteDataRoleSelection(Integer projectId) {
        requirementDomainRepository.deleteDataRoleSelection(projectId);
    }

    public void deleteDataRoleUser(Integer projectId) {
        requirementDomainRepository.deleteDataRoleUser(projectId);
    }

    public ITypeConsultingProject getTypeOfConsulting(Integer projectId) {
        return requirementDomainRepository.getTypeOfConsulting(projectId);
    }

}