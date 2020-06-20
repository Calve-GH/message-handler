package com.github.calvegh.controller;

import com.github.calvegh.model.Message;
import com.github.calvegh.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.StringJoiner;

@RestController
@RequestMapping(value = BaseController.REST_URL)
@RequiredArgsConstructor
public class BaseController {
    public static final String REST_URL = "/api/";

    private final MessageRepository messageRepository;

    private static ResponseEntity<String> getResponseEntity(List<Message> messages) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        for (Message message : messages) {
            sj.add(message.toString());
        }
        return new ResponseEntity<>(sj.toString(), HttpStatus.OK);
    }

    @PostMapping(path = "message-handle")
    public void handleMsg(@RequestBody String msgBody) {
        messageRepository.save(new Message(msgBody));
    }

    @GetMapping(path = "messages")
    public ResponseEntity<String> handleMsg() {
        return getResponseEntity(messageRepository.findAll());
    }
}