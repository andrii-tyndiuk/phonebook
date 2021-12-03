package spring.project.phonebook.dto.request;

import lombok.Data;
import spring.project.phonebook.model.MethodOfCommunication;

@Data
public class MethodOfCommunicationRequestDto {
    private MethodOfCommunication.CommunicationType communicationType;
    private String number;
    private String description;
    private Long contactId;
}
