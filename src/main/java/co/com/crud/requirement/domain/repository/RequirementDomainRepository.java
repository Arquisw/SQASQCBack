package co.com.crud.requirement.domain.repository;

import co.com.crud.requirement.domain.model.Requirement;
import co.com.crud.requirement.domain.model.queryresult.IPerfectOrNotPerfectRequirement;
import co.com.crud.requirement.domain.model.queryresult.IRequirementByGradeAndCauseError;
import co.com.crud.requirement.domain.model.queryresult.IRequirementsByFilterCauseError;

import java.util.List;
import java.util.Optional;

public interface RequirementDomainRepository {

    Requirement saveRequirement(Requirement requirement);

    List<Requirement> getAllRequirements();

    Optional<Requirement> getRequirementById(Integer id);

    Optional<List<Requirement>> getRequirementByType(String type);

    void deleteRequirement(Integer requirementId);

    IRequirementsByFilterCauseError countRequirementsByFilterCauseError(Integer requirementId);

    IRequirementByGradeAndCauseError countRequirementsByGradeAndCauseError(String typeRequirement, String causeError, Integer projectId);

    IPerfectOrNotPerfectRequirement countPerfectRequirements1(String typeRequirement, Integer projectId);

    IPerfectOrNotPerfectRequirement countPerfectRequirements(Integer projectId);

    IPerfectOrNotPerfectRequirement countImperfectRequirements();

    List<Requirement> getRequirementsByProyectoId(Integer proyectoId);
}