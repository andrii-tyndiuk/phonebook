package spring.project.phonebook.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickname;
    private String phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private ContactType contactType;
    @OneToMany(mappedBy = "contact",cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<MethodOfCommunication> methodOfCommunication;
    @OneToOne(mappedBy = "contact", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private PersonalInfo personalInfo;

    public enum ContactType {
        FAVOURITE, JOB, SCHOOL, FAMILY
    }
}
