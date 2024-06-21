package com.crudapp.dynamodbupdater.service;

import com.crudapp.dynamodbupdater.dto.CrewDTO;
import com.crudapp.dynamodbupdater.model.RequestModel;
import com.crudapp.dynamodbupdater.model.ResponseModel;


import java.util.List;

public interface CrewService {
    public List<CrewDTO> getAllcrews();

    public CrewDTO getCrewById(String id);

    public CrewDTO createNewCrew(CrewDTO crewDTO);

    public CrewDTO updateCrew(String id, CrewDTO crewDTO);

    public void deleteCrew(String id);

    public ResponseModel doOperation(RequestModel requestModel);

}
