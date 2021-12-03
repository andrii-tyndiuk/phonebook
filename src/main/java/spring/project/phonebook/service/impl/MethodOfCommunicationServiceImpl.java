package spring.project.phonebook.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import spring.project.phonebook.dto.request.MethodOfCommunicationRequestDto;
import spring.project.phonebook.dto.response.MethodOfCommunicationResponseDto;
import spring.project.phonebook.model.MethodOfCommunication;
import spring.project.phonebook.repository.MethodOfCommunicationRepository;
import spring.project.phonebook.service.MethodOfCommunicationService;
import spring.project.phonebook.service.mapping.RequestDtoMapper;
import spring.project.phonebook.service.mapping.ResponseDtoMapper;

@Service
public class MethodOfCommunicationServiceImpl implements MethodOfCommunicationService {
    private MethodOfCommunicationRepository mocRepository;
    private RequestDtoMapper<MethodOfCommunication, MethodOfCommunicationRequestDto> mocRequestDtoMapper;
    private ResponseDtoMapper<MethodOfCommunication, MethodOfCommunicationResponseDto> mocResponseDtoMapper;

    public MethodOfCommunicationServiceImpl(MethodOfCommunicationRepository mocRepository,
                                            RequestDtoMapper<MethodOfCommunication, MethodOfCommunicationRequestDto> mocRequestDtoMapper,
                                            ResponseDtoMapper<MethodOfCommunication, MethodOfCommunicationResponseDto> mocResponseDtoMapper) {
        this.mocRepository = mocRepository;
        this.mocRequestDtoMapper = mocRequestDtoMapper;
        this.mocResponseDtoMapper = mocResponseDtoMapper;
    }

    @Override
    public MethodOfCommunicationResponseDto save(MethodOfCommunicationRequestDto requestDto) {
        return mocResponseDtoMapper
                .toDto(mocRepository.save(mocRequestDtoMapper.toModel(requestDto)));
    }

    @Override
    public MethodOfCommunicationResponseDto getById(Long id) {
        return mocResponseDtoMapper.toDto(mocRepository.getById(id));
    }

    @Override
    public List<MethodOfCommunicationResponseDto> getByContactId(Long contactId) {
        return mocRepository.getByContactId(contactId)
                .stream()
                .map(mocResponseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MethodOfCommunicationResponseDto update(MethodOfCommunicationRequestDto requestDto, Long id) {
        MethodOfCommunication methodOfCommunication = mocRequestDtoMapper.toModel(requestDto);
        methodOfCommunication.setId(id);
        return mocResponseDtoMapper.toDto(mocRepository.save(methodOfCommunication));
    }

    @Override
    public List<MethodOfCommunicationResponseDto> getByContactIdAndType(Long contactId, String type) {
        return mocRepository.getByContactIdAndType(contactId, type)
                .stream()
                .map(mocResponseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        mocRepository.deleteById(id);
    }
}
