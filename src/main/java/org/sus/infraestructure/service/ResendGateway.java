package org.sus.infraestructure.service;

import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;
import com.resend.services.emails.model.CreateEmailResponse;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.sus.application.gateway.EnviaNotificacaoGateway;
import org.sus.domain.Notificacao.model.Notificacao;

import java.io.IOException;
import java.net.http.HttpClient;
import com.resend.*;

@ApplicationScoped
public class ResendGateway implements EnviaNotificacaoGateway {

    @ConfigProperty(name = "resend.api-key")
    String apiKey;

    @ConfigProperty(name = "resend.from-email")
    String fromEmail;

    private final HttpClient client = HttpClient.newHttpClient();

    @Override
    public void execute(Notificacao notificacao) {
        Resend resend = new Resend(apiKey);

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from(fromEmail)
                .to(notificacao.getTo())
                .subject(notificacao.getDescricao())
                .html("<strong>Vaga Confirmada</strong>")
                .build();

        try {
            CreateEmailResponse data = resend.emails().send(params);
            System.out.println(data.getId());
        } catch (ResendException e) {
            e.printStackTrace();
        }
    }
}

