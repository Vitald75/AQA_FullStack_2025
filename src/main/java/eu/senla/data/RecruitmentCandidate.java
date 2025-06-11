package eu.senla.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecruitmentCandidate {
  private String firstName;
  private String middleName;
  private String lastName;
  private String email;
  private String contactNumber;
  private String keywords;
  private String notes;
}
