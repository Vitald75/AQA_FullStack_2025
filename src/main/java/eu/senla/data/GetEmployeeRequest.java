package eu.senla.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetEmployeeRequest {
    @JsonProperty("data")
    private Employee data;
    @JsonProperty("meta")
    private Object[] meta;
    @JsonProperty("rels")
    private Object[] rels;
}
