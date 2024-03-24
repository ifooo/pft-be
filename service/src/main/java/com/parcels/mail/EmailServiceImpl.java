package com.parcels.mail;

import com.parcels.transaction.dto.TransactionDto;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    private final Configuration configuration;

    @Override
    public void sendMonthlyOverviewEmail(String email, String subject, List<TransactionDto> transactions) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("shurbanovski.i@gmail.com", "Ivo Shurbanovski");
        helper.setTo(email);

        helper.setSubject(subject);
        helper.setText(getEmailContent(transactions), true);

        mailSender.send(message);
    }

    private String getEmailContent(List<TransactionDto> transactions) {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("ccss", transactions);
        try {
            configuration.getTemplate("monthly-overview.ftl").process(model, stringWriter);
        } catch (TemplateException | IOException e) {
            throw new RuntimeException(e);
        }
        return stringWriter.getBuffer().toString();
    }
}
