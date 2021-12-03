package spring.project.phonebook.dto.request;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PersonalInfoRequestDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private Long contactId;
}
