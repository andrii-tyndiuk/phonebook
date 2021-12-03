package spring.project.phonebook.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.project.phonebook.dto.request.CallRequestDto;
import spring.project.phonebook.dto.response.CallResponseDto;
import spring.project.phonebook.service.CallService;

@RestController
@RequestMapping("/call")
public class CallController {
    private final CallService callService;


    public CallController(CallService callService) {
        this.callService = callService;
    }

    @PostMapping("/create")
    public CallResponseDto create(@RequestBody CallRequestDto callRequestDto) {
        return callService.create(callRequestDto);
    }

    @GetMapping("/all")
    public List<CallResponseDto> getAll(@RequestParam Long contactId) {
        return callService.findAll(contactId);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        callService.deleteById(id);
    }
}
