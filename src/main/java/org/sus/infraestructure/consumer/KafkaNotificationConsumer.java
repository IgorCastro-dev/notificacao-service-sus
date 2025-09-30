package org.sus.infraestructure.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.sus.domain.Notificacao.model.Notificacao;
import org.sus.usecase.EnviaNotificacaoUseCase;

@ApplicationScoped
public class KafkaNotificationConsumer {

    @Inject
    private EnviaNotificacaoUseCase enviaNotificacaoUseCase;

    @Incoming("notificacao")
    public void consumir(Notificacao notificacao) {
        enviaNotificacaoUseCase.execute(notificacao);
    }
}
