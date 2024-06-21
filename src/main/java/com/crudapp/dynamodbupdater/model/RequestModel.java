package com.crudapp.dynamodbupdater.model;

import com.crudapp.dynamodbupdater.dto.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "operationType",
        "id",
        "crew"
})
@Data
public class RequestModel {
    @JsonProperty("operationType")
    private String operationType;
    @JsonProperty("id")
    private String crewid;
    @JsonProperty("crew")
    private CrewDTO crewDTO;
}
