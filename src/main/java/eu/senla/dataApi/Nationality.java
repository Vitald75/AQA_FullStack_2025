package eu.senla.dataApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Nationality {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
}
