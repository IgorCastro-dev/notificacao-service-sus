package org.sus.infraestructure.configuration.desserializador;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;
import org.sus.domain.Notificacao.model.Notificacao;

public class NotificacaoDeserializer extends JsonbDeserializer<Notificacao> {
    public NotificacaoDeserializer() {
        super(Notificacao.class);
    }
}
