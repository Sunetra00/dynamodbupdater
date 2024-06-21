package com.crudapp.dynamodbupdater.service;

import com.crudapp.dynamodbupdater.dao.CrewRepository;
import com.crudapp.dynamodbupdater.dto.CrewDTO;
import com.crudapp.dynamodbupdater.model.CrewEntity;
import com.crudapp.dynamodbupdater.model.RequestModel;
import com.crudapp.dynamodbupdater.model.ResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrewServiceImpl implements CrewService{

    CrewRepository crewRepository;

    @Override
    public List<CrewDTO> getAllcrews() {
        List<CrewEntity> crewEntities =crewRepository.loadAllCrews();
        return crewEntities.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public CrewDTO getCrewById(String id) {
        CrewEntity crew =crewRepository.loadCrew(id);
        return convertToDTO(crew);
    }

    @Override
    public CrewDTO createNewCrew(CrewDTO crewDTO) {
        CrewEntity entity = new CrewEntity();
        BeanUtils.copyProperties(crewDTO, entity);
        CrewEntity savedCrew=crewRepository.saveCrew(entity);
        return convertToDTO(savedCrew);
    }

    @Override
    public CrewDTO updateCrew(String id, CrewDTO crewDTO) {
        CrewEntity entity = new CrewEntity();
        BeanUtils.copyProperties(crewDTO, entity);
        CrewEntity updatedCrew=crewRepository.updateCrew(id, crewDTO);
        return convertToDTO(updatedCrew);
    }

    @Override
    public void deleteCrew(String id) {
        crewRepository.deleteCrew(id);
    }

    @Override
    public ResponseModel doOperation(RequestModel requestModel) {
        String operationType=requestModel.getOperationType();
        String id = requestModel.getCrewid();
        CrewDTO crewDTO = requestModel.getCrewDTO();
        ResponseModel responseModel = new ResponseModel();
        switch (operationType){
            case "READALL":
                List<CrewDTO> crews = getAllcrews();
                if (crews !=null && !crews.isEmpty()) {
                    responseModel.setOperationType(operationType);
                    responseModel.setCrews(crews);
                    responseModel.setStatusCode("200");
                    responseModel.setStatus("Found");
                    break;
                }else {
                    throw new RuntimeException("NO DATA FOUND IN TABLE");
                }
            case "READ":
                var crew = getCrewById(id);
                if (crew !=null ) {
                    responseModel.setOperationType(operationType);
                    responseModel.setRequestedCrewId(id);
                    responseModel.getCrews().add(crew);
                    responseModel.setStatusCode("200");
                    responseModel.setStatus("Found");
                    break;
                }else {
                    throw new RuntimeException("NO DATA FOUND IN TABLE");
                }
            case "CREATE":
                var savedcrew = createNewCrew(crewDTO);
                if (crewDTO !=null ) {
                    responseModel.setOperationType(operationType);
                    responseModel.setRequestedCrewId(id);
                    responseModel.getCrews().add(savedcrew);
                    responseModel.setStatusCode("200");
                    responseModel.setStatus("CREATED");
                    break;
                }else {
                    throw new RuntimeException("ERROR IN CREATING CREW");
                }
            case "UPDATE":
                var updatedCrew = updateCrew(id,crewDTO);
                if (crewDTO !=null ) {
                    responseModel.setOperationType(operationType);
                    responseModel.setRequestedCrewId(id);
                    responseModel.getCrews().add(updatedCrew);
                    responseModel.setStatusCode("200");
                    responseModel.setStatus("UPDATED");
                    break;
                }else {
                    throw new RuntimeException("ERROR IN UPDATING CREW");
                }
            case "DELETE":
                try{
                deleteCrew(id);
                    responseModel.setOperationType(operationType);
                    responseModel.setRequestedCrewId(id);
                    responseModel.setStatusCode("200");
                    responseModel.setStatus("deleted");
                    break;
                }
               catch (Exception e){
                    throw new RuntimeException("ERROR IN UPDATING CREW");
                }
        }

        return responseModel;
    }

    public CrewServiceImpl(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    private CrewDTO convertToDTO(CrewEntity crew) {
        CrewDTO dto = new CrewDTO();
        BeanUtils.copyProperties(crew, dto);
        return dto;
    }
}
