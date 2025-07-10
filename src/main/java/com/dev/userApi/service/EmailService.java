package com.dev.userApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(String to, String token) {
        String subject = "Confirme seu e-mail";
        String confirmationUrl = "http://localhost:8080/api/users/verify?token=" + token;

        String htmlContent = "<html>" +
                "<body>" +
                "<h2>Bem-vindo!</h2>" +
                "<p>Clique no botão abaixo para confirmar seu e-mail:</p>" +
                "<a style='display:inline-block;padding:10px 20px;background-color:#4CAF50;color:white;text-decoration:none;border-radius:5px;' href='"
                + confirmationUrl + "'>Confirmar E-mail</a>" +
                "<p>Ou copie e cole o link no navegador: <br>" + confirmationUrl + "</p>" +
                "</body>" +
                "</html>";

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true); // true = envia como HTML
            helper.setFrom("noreply@suaapi.com");

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Erro ao enviar e-mail", e);
        }
    }

    public void sendTestEmail(String to) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Teste de envio de e-mail");
        message.setText("Este é um e-mail de teste enviado via Mailtrap.");
        message.setFrom("noreply@suaapi.com");

        mailSender.send(message);
    }
}
