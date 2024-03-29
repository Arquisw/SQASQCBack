package co.com.crud.requirement.domain.repository;

import co.com.crud.requirement.domain.model.TypeErrorCharacteristic;
import co.com.crud.requirement.domain.model.queryresult.IErrorDistributionAllRequirements;
import co.com.crud.requirement.domain.model.queryresult.IRequirementsByTypeAndCauseError;

import java.util.List;
import java.util.Optional;

public interface TypeErrorCharacteristicDomainRepository {

    List<TypeErrorCharacteristic> getAllTypesErrors();

    Optional<TypeErrorCharacteristic> getTypeErrorById(Integer id);

    int countRequirementsByTypeAndCauseError(String typeRequirement, String causeError);

    int countRequirementByCauseErrorDDE();

    int countRequirementByCauseErrorDII();

    int countRequirementByCauseErrorVAR();

    int countRequirementsByCauseErrorAndRequirementId(Integer requirementId, Integer typeErrorId, String causeError);

    int countTypeErrorEIEByRequirement(Integer requirementId);

    int countTypeErrorEIEAndCauseErrorDDEByRequirement(Integer requirementId);

    int countTypeErrorEIEAndCauseErrorDIIByRequirement(Integer requirementId);

    int countTypeErrorEIEAndCauseErrorVARByRequirement(Integer requirementId);

    int countTypeErrorMCCByRequirement(Integer requirementId);

    int countTypeErrorMCCAndCauseErrorDDEByRequirement(Integer requirementId);

    int countTypeErrorMCCAndCauseErrorDIIByRequirement(Integer requirementId);

    int countTypeErrorMCCAndCauseErrorVARByRequirement(Integer requirementId);

    int countTypeErrorsByRequirements(Integer typeErrorId, Integer requirementId);

    int countAllTypeErrorsByRequirement(Integer requirementId);

    int countAllCauseErrorsByRequirement(Integer requirementId);

    IRequirementsByTypeAndCauseError causeErrorByCharacteristicForRequirements(String typeRequirement, Integer projectId);

    IErrorDistributionAllRequirements errorDistributionAllRequirements(String typeRequirement, Integer projectId);

}