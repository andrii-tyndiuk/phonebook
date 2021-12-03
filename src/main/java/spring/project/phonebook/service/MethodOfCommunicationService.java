package spring.project.phonebook.service;

import java.util.List;
import spring.project.phonebook.dto.request.MethodOfCommunicationRequestDto;
import spring.project.phonebook.dto.response.MethodOfCommunicationResponseDto;

public interface MethodOfCommunicationService {
    MethodOfCommunicationResponseDto save(MethodOfCommunicationRequestDto requestDto);

    MethodOfCommunicationResponseDto getById(Long id);

    List<MethodOfCommunicationResponseDto> getByContactId(Long contactId);

    MethodOfCommunicationResponseDto update(MethodOfCommunicationRequestDto requestDto, Long id);
    void deleteById(Long id);

    List<MethodOfCommunicationResponseDto> getByContactIdAndType(Long contactId, String type);
}
