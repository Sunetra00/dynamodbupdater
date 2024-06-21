package com.crudapp.dynamodbupdater.service;

import com.crudapp.dynamodbupdater.model.CrewDTO;


import java.util.List;

public interface CrewService {
    public List<CrewDTO> getAllcrews();

    public CrewDTO getCrewById(String id);

    public CrewDTO createNewProduct(CrewDTO crewDTO);

    public CrewDTO updateProduct(String id, CrewDTO crewDTO);

    public void deleteProduct(String id);

}
