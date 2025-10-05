package org.sus.infraestructure.configuration.desserializador;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import org.sus.domain.Notificacao.model.Notificacao;

public class NotificacaoDeserializer extends ObjectMapperDeserializer<Notificacao> {
    public NotificacaoDeserializer() {
        super(Notificacao.class);
    }
}