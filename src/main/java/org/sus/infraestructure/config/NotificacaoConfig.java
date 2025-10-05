package org.sus.infraestructure.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.sus.application.gateway.EnviaNotificacaoGateway;
import org.sus.application.usecaseimpl.EnviaNotificacaoUseCaseImpl;

@ApplicationScoped
public class NotificacaoConfig {

    @Produces
    @ApplicationScoped
    public EnviaNotificacaoUseCaseImpl enviaNotificacaoUseCase(EnviaNotificacaoGateway enviaNotificacaoGateway){
        return new EnviaNotificacaoUseCaseImpl(enviaNotificacaoGateway);
    }
}
