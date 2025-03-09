package com.otto.javamail.controller;

import com.otto.javamail.dto.EmailDTO;
import com.otto.javamail.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService  service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void enviarEmail(@RequestBody EmailDTO emailDTO) {
        service.enviarEmail(emailDTO);
    }
}
