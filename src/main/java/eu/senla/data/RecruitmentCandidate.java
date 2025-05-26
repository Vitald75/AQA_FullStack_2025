package eu.senla.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class RecruitmentCandidate {
  private String firstName;
  private String middleName;
  private String lastName;
  private String email;
  private String contactNumber;
  private String keywords;
  private String notes;
}
