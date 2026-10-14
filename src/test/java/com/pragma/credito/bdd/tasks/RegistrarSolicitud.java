package com.pragma.credito.bdd.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.time.LocalDateTime;

public class RegistrarSolicitud implements Task {

    private final String nombreSolicitante;
    private final Double montoSolicitado;
    private final Integer puntajeRiesgo;
    private final Integer numeroIncumplimientos;
    private final Boolean tieneDeudasVencidas;

    public RegistrarSolicitud(String nombreSolicitante, Double montoSolicitado,
                               Integer puntajeRiesgo, Integer numeroIncumplimientos,
                               Boolean tieneDeudasVencidas) {
        this.nombreSolicitante = nombreSolicitante;
        this.montoSolicitado = montoSolicitado;
        this.puntajeRiesgo = puntajeRiesgo;
        this.numeroIncumplimientos = numeroIncumplimientos;
        this.tieneDeudasVencidas = tieneDeudasVencidas;
    }

    public static RegistrarSolicitud conDatos(String nombre, Double monto,
                                               Integer puntaje, Integer incumplimientos,
                                               Boolean deudasVencidas) {
        return new RegistrarSolicitud(nombre, monto, puntaje, incumplimientos, deudasVencidas);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Superficie de práctica: el estudiante implementa
        // Debe usar el ability InteractuarConSistema para realizar la acción
        // y llamar al servicio de registro de solicitudes
    }
}