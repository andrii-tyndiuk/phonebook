package spring.project.phonebook.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class MethodOfCommunication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private CommunicationType communicationType;
    private String number;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private Contact contact;

    public enum CommunicationType {
        WORK_NUMBER, HOME_NUMBER, EMAIL, SKYPE, ANOTHER
    }
}
