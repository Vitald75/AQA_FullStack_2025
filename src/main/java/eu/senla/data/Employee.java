package eu.senla.data;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Data

public class Employee {

  private Integer empNumber;

  private String lastName;

  private String firstName;

  private String middleName;

  private String employeeId;

  private String otherId;

  private String drivingLicenseNo;

  private String drivingLicenseExpiredDate; // Use String for flexibility

  private String gender;

  private String maritalStatus;

  private String birthday; // Use String for flexibility

  private String terminationId;

  private Nationality nationality;

}


