package spring.project.phonebook.dto.request;

import java.time.Duration;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CallRequestDto {
    private String type;
    private LocalDateTime time;
    private Duration duration;
    private Long fromContactId;
    private Long toContactId;
}
