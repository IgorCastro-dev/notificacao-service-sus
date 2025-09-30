package org.sus.application.gateway;

import org.sus.domain.Notificacao.model.Notificacao;

import java.io.IOException;

public interface EnviaNotificacaoGateway {
    void execute(Notificacao notificacao) throws IOException;
}
