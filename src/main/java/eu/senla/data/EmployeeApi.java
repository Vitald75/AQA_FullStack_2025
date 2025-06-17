package eu.senla.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeApi {
    @JsonProperty("empNumber")
    private Integer empNumber;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("middleName")
    private String middleName;
    @JsonProperty("employeeId")
    private String employeeId;
    @JsonProperty("otherId")
    private String otherId;
    @JsonProperty("drivingLicenseNo")
    private String drivingLicenseNo;
    @JsonProperty("drivingLicenseExpiredDate")
    private String drivingLicenseExpiredDate; // Use String for flexibility
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("martialStatus")
    private String maritalStatus;
    @JsonProperty("birthday")
    private String birthday; // Use String for flexibility
    @JsonProperty("terminationId")
    private String terminationId;
    @JsonProperty("nationality")
    private Nationality nationality;
}
