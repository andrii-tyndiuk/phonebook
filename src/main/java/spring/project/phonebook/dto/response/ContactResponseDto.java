package spring.project.phonebook.dto.response;

import lombok.Data;

@Data
public class ContactResponseDto {
    private Long id;
    private String nickname;
    private String phoneNumber;
    private String contactType;
}
