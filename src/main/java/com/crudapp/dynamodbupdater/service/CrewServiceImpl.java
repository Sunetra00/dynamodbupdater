package com.crudapp.dynamodbupdater.service;

import com.crudapp.dynamodbupdater.dao.CrewRepository;
import com.crudapp.dynamodbupdater.model.CrewDTO;
import com.crudapp.dynamodbupdater.model.CrewEntity;
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
    public CrewDTO createNewProduct(CrewDTO crewDTO) {
        CrewEntity entity = new CrewEntity();
        BeanUtils.copyProperties(crewDTO, entity);
        CrewEntity savedCrew=crewRepository.saveCrew(entity);
        return convertToDTO(savedCrew);
    }

    @Override
    public CrewDTO updateProduct(String id, CrewDTO crewDTO) {
        CrewEntity entity = new CrewEntity();
        BeanUtils.copyProperties(crewDTO, entity);
        CrewEntity updatedCrew=crewRepository.updateCrew(id, crewDTO);
        return convertToDTO(updatedCrew);
    }

    @Override
    public void deleteProduct(String id) {
        crewRepository.deleteCrew(id);
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
