package spring.project.phonebook.dto.response;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.Data;
import spring.project.phonebook.model.OurCall;

@Data
public class CallResponseDto {
    private Long id;
    private OurCall.Type type;
    private LocalDateTime time;
    private Duration duration;
    private Long fromContactId;
    private Long toContactId;
}
