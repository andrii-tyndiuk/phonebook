package spring.project.phonebook.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.project.phonebook.dto.request.MethodOfCommunicationRequestDto;
import spring.project.phonebook.dto.response.MethodOfCommunicationResponseDto;
import spring.project.phonebook.service.MethodOfCommunicationService;

@RestController
@RequestMapping("/method-of-communication")
public class MethodOfCommunicationController {
    private final MethodOfCommunicationService methodOfCommunicationService;

    public MethodOfCommunicationController(MethodOfCommunicationService methodOfCommunicationService) {
        this.methodOfCommunicationService = methodOfCommunicationService;
    }

    @PostMapping("/add")
    public MethodOfCommunicationResponseDto create(@RequestBody MethodOfCommunicationRequestDto requestDto) {
        return methodOfCommunicationService.save(requestDto);
    }

    @GetMapping("/{id}")
    public MethodOfCommunicationResponseDto getById(@PathVariable Long id) {
        return methodOfCommunicationService.getById(id);
    }

    @GetMapping("/by-contact/{contactId}")
    public List<MethodOfCommunicationResponseDto> getByContactId(@PathVariable Long contactId) {
        return methodOfCommunicationService.getByContactId(contactId);
    }

    @GetMapping
    public List<MethodOfCommunicationResponseDto> getByContactIdAndType(@RequestParam Long contactId,
                                                                        @RequestParam String type) {
        return methodOfCommunicationService.getByContactIdAndType(contactId, type);
    }

    @PutMapping("/update/{id}")
    public MethodOfCommunicationResponseDto update(@RequestBody MethodOfCommunicationRequestDto dto,
                                                   @PathVariable Long id) {
        return methodOfCommunicationService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        methodOfCommunicationService.deleteById(id);
    }
}
