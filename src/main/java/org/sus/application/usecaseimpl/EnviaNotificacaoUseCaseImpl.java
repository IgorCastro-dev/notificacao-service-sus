package org.sus.application.usecaseimpl;

import org.sus.application.gateway.EnviaNotificacaoGateway;
import org.sus.domain.Notificacao.model.Notificacao;
import org.sus.usecase.EnviaNotificacaoUseCase;

import java.io.IOException;

public class EnviaNotificacaoUseCaseImpl implements EnviaNotificacaoUseCase {
    private EnviaNotificacaoGateway enviaNotificacaoGateway;

    public EnviaNotificacaoUseCaseImpl(EnviaNotificacaoGateway enviaNotificacaoGateway){
        this.enviaNotificacaoGateway = enviaNotificacaoGateway;
    }

    @Override
    public void execute(Notificacao notificacao) throws IOException {
        enviaNotificacaoGateway.execute(notificacao);
    }
}
