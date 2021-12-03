package spring.project.phonebook.dto.request;

import lombok.Data;

@Data
public class ContactRequestDto {
    private String nickname;
    private String phoneNumber;
    private String contactType;
}
