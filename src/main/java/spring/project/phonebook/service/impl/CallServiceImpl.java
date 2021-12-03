package spring.project.phonebook.service.impl;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import spring.project.phonebook.dto.request.CallRequestDto;
import spring.project.phonebook.dto.response.CallResponseDto;
import spring.project.phonebook.model.OurCall;
import spring.project.phonebook.repository.CallRepository;
import spring.project.phonebook.service.CallService;
import spring.project.phonebook.service.mapping.RequestDtoMapper;
import spring.project.phonebook.service.mapping.ResponseDtoMapper;

@Service
public class CallServiceImpl implements CallService {
    private final RequestDtoMapper<OurCall, CallRequestDto> callRequestDtoMapper;
    private final ResponseDtoMapper<OurCall, CallResponseDto> callResponseDtoMapper;
    private final CallRepository callRepository;

    public CallServiceImpl(RequestDtoMapper<OurCall, CallRequestDto> callRequestDtoMapper,
                           ResponseDtoMapper<OurCall, CallResponseDto> callResponseDtoMapper,
                           CallRepository callRepository) {
        this.callRequestDtoMapper = callRequestDtoMapper;
        this.callResponseDtoMapper = callResponseDtoMapper;
        this.callRepository = callRepository;
    }

    @Override
    public CallResponseDto create(CallRequestDto callRequestDto) {
        return callResponseDtoMapper.toDto(callRepository.save(callRequestDtoMapper.toModel(callRequestDto)));
    }

    @Override
    public List<CallResponseDto> findAll(Long contactId) {
        return callRepository.findAllCallByContactId(contactId)
                .stream()
                .map(callResponseDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        callRepository.deleteById(id);
    }
}
