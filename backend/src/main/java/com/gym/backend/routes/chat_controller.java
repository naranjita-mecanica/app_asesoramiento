package com.gym.backend.routes;


import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.gym.backend.entities.Consulta;

import com.gym.backend.services.consulta_service;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/ia")
@CrossOrigin
public class chat_controller
{
    
    private final ChatClient chatClient;

    @Autowired
    private consulta_service consultaService;

    
    public chat_controller(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/{userInput}")
    public String generation(@PathVariable("userInput") String userInput) {
        return this.chatClient.prompt()
            .user(userInput)
            .call()
            .content();
    }

    /*public Consulta postConsulta(Consulta consulta)
    {
        return consultaService.guardarConsulta(consulta);
    }*/

    @PostMapping("/consulta")
    public String consultar(@Valid @RequestBody Consulta consulta)
    {
        
        //consulta = postConsulta(consulta);

        return this.chatClient.prompt()
            .messages(new UserMessage(consulta.getMensaje()))
            .call()
            .content();
            
    } 
}