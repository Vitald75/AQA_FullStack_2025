package eu.senla.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetEmployeeRequest {
    @JsonProperty("data")
    private EmployeeApi data;
    @JsonProperty("meta")
    private List<Object> meta;
    @JsonProperty("rels")
    private List<Object> rels;
}
