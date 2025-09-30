package org.sus.usecase;

import org.sus.domain.Notificacao.model.Notificacao;

import java.io.IOException;

public interface EnviaNotificacaoUseCase {
    void execute(Notificacao notificacao) throws IOException;
}
