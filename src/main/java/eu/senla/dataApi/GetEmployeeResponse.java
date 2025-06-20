package eu.senla.dataApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetEmployeeResponse {
    @JsonProperty("data")
    private EmployeeApi data;
    @JsonProperty("meta")
    private List<Object> meta;
    @JsonProperty("rels")
    private List<Object> rels;
}
