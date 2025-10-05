package org.sus.infraestructure.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.sus.application.gateway.EnviaNotificacaoGateway;
import org.sus.domain.Notificacao.model.Notificacao;

import java.io.IOException;

@ApplicationScoped
public class SendGridEmailGateway implements EnviaNotificacaoGateway {

    private final SendGrid sendGrid;
    private final String fromEmail;

    public SendGridEmailGateway(
            @ConfigProperty(name = "sendgrid.api-key") String apiKey,
            @ConfigProperty(name = "sendgrid.from-email") String fromEmail) {
        this.sendGrid = new SendGrid(apiKey);
        this.fromEmail = fromEmail;
    }



    @Override
    public void execute(Notificacao notificacao) throws IOException {

            Email from = new Email(fromEmail);
            Email to = new Email(notificacao.getTo());
            Content content = new Content("text/html", notificacao.getDescricao());
            Mail mail = new Mail(from, notificacao.getTitulo(), to, content);

            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            sendGrid.api(request);
    }
}
