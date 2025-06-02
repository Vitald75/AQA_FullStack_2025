package eu.senla.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {
  private String firstName;
  private String middleName;
  private String lastName;
}
