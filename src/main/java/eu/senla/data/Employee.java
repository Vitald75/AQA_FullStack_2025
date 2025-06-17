package eu.senla.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
  public class Nationality {
    private String id;
    private String name;
  }

  private String empNumber;
  private String firstName;
  private String middleName;
  private String lastName;
  private String employeeId;
  private String otherId;
  private String drivingLicenseNo;
  private String drivingLicenseExpiredDate;
  private String gender;
  private String martialStatus;
  private String birthday;
  private String terminationId;
  private Nationality nationality;
  @JsonProperty("nickname")
  private String nickName;
  private boolean smoker;
  private boolean militaryService;
}


