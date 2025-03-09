package com.otto.javamail.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.otto.javamail.dto.EmailDTO;
import com.otto.javamail.model.User;
import com.otto.javamail.repository.UserRepository;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final UserRepository repository;

    @Value("${passwordSecret}")
    private String secret;

    public void enviarEmail(EmailDTO emailDTO) {
        try {
            Optional<User> optionalUser = repository.findByEmail(emailDTO.getEmail());

            if(optionalUser.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email não cadastrado");
            }

            String senha = hashSenha(secret);

            User user = optionalUser.get();

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom("noreply@gmail.com");
            helper.setSubject("Teste de envio de email");
            helper.setTo("osouza@minsait.com");

            String template = montarTemplateEmail();

            template = template.replace("#{nome}", user.getName());
            template = template.replace("#{email}", user.getEmail());
            template = template.replace("#{senha}", senha);

            helper.setText(template, true);

            javaMailSender.send(message);

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Error ao enviar email");
        }
    }


    public  String hashSenha(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }
    public String montarTemplateEmail() throws IOException {
        ClassPathResource resource = new ClassPathResource("template-email.html");
        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }
}
