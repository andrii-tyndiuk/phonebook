package spring.project.phonebook.model;

import java.time.Duration;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class OurCall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private Type type;
    private LocalDateTime time;
    private Duration duration;
    @ManyToOne
    private Contact fromContact;
    @ManyToOne
    private Contact toContact;

    public enum Type {
    INPUT, OUTPUT, REJECTED, MISSED
}
}
