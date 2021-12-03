package spring.project.phonebook.dto.response;

import java.time.LocalDate;
import lombok.Data;

@Data
public class PersonalInfoResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private Long contactId;
}
