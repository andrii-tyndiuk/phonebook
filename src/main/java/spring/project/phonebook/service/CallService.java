package spring.project.phonebook.service;

import java.util.List;
import spring.project.phonebook.dto.request.CallRequestDto;
import spring.project.phonebook.dto.response.CallResponseDto;

public interface CallService {
    CallResponseDto create(CallRequestDto callRequestDto);

    List<CallResponseDto> findAll(Long contactId);

    void deleteById(Long id);
}
