package eu.senla.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@ToString
@Getter
public class Employee {
  private String firstName;
  private String middleName;
  private String lastName;
}
