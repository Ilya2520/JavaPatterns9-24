package ru.emelyanov.prac14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.emelyanov.prac14.models.Post;
import ru.emelyanov.prac14.models.User;

@Service
public class EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Async
    public void sendAddUserEmail(User user){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("ilyaemel87@gmail.com");
        message.setTo("ilyaemel87@gmail.com");
        message.setSubject("Message from Spring Boot Application");
        message.setText(user.toString());

        emailSender.send(message);
        System.out.println("Email successfully sent!");
    }

    @Async
    public void sendAddPostEmail(Post post){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("ilyaemel87@gmail.com");
        message.setTo("ilyaemelyanov2003@mail.ru");
        message.setSubject("Message from Spring Boot Application");
        message.setText(post.toString());

        emailSender.send(message);
        System.out.println("Email successfully sent!");
    }
}
