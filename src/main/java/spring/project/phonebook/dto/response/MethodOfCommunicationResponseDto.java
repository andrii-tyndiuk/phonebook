package spring.project.phonebook.dto.response;

import lombok.Data;

@Data
public class MethodOfCommunicationResponseDto {
    private Long id;
    private String communicationType;
    private String number;
    private String description;
    private Long contactId;
}
