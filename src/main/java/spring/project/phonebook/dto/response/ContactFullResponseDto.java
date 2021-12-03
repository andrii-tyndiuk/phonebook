package spring.project.phonebook.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class ContactFullResponseDto {
    private Long id;
    private String nickname;
    private String phoneNumber;
    private String contactType;
    private List<MethodOfCommunicationResponseDto> methodOfCommunication;
    private PersonalInfoResponseDto personalInfo;
}
