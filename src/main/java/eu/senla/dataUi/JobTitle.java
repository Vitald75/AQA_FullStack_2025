package eu.senla.dataUi;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JobTitle {
 private String jobTitle;
 private String jobDescription;
 private String note;
}
