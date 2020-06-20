package com.github.calvegh.controller;

import com.github.calvegh.model.Message;
import com.github.calvegh.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
@RequiredArgsConstructor
public class BaseExceptionHandler {

    private final MessageRepository messageRepository;

    @ExceptionHandler(Exception.class)
    public void handleError(Exception e) {
        messageRepository.save(new Message(e.getClass().getSimpleName() + " " + e.getLocalizedMessage()));
    }
}