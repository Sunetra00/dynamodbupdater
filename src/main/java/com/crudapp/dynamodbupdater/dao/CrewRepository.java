package com.crudapp.dynamodbupdater.dao;

import com.crudapp.dynamodbupdater.dto.CrewDTO;
import com.crudapp.dynamodbupdater.model.CrewEntity;

import java.util.List;

public interface CrewRepository {
    public CrewEntity saveCrew(CrewEntity entity);
    public CrewEntity loadCrew(String crewID);
    public boolean deleteCrew(String crewid);
    public List<CrewEntity> loadAllCrews();
    public CrewEntity updateCrew(String id, CrewDTO dto);


}
