package com.pragma.credito.bdd.steps;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.time.LocalDateTime;

public class SolicitudCreditoSteps {

    @Dado("que el usuario quiere registrar una solicitud de crédito")
    public void queElUsuarioQuiereRegistrarUnaSolicitudDeCredito() {
        // Superficie de práctica: el estudiante implementa
    }

    @Cuando("el usuario registra la solicitud con nombre {string}, monto {double}, puntaje de riesgo {int}, numero de incumplimientos {int} y deudas vencidas {string}")
    public void elUsuarioRegistraLaSolicitud(String nombre, Double monto, Integer puntajeRiesgo, Integer numeroIncumplimientos, Boolean tieneDeudasVencidas) {
        // Superficie de práctica: el estudiante implementa
    }

    @Entonces("el sistema debe mostrar un mensaje de error por monto negativo")
    public void elSistemaDebeMostrarUnMensajeDeErrorPorMontoNegativo() {
        // Superficie de práctica: el estudiante implementa
    }

    @Entonces("el sistema debe mostrar un mensaje de error por solicitud duplicada")
    public void elSistemaDebeMostrarUnMensajeDeErrorPorSolicitudDuplicada() {
        // Superficie de práctica: el estudiante implementa
    }

    @Entonces("la solicitud debe ser aprobada")
    public void laSolicitudDebeSerAprobada() {
        // Superficie de práctica: el estudiante implementa
    }

    @Entonces("la solicitud debe ser rechazada")
    public void laSolicitudDebeSerRechazada() {
        // Superficie de práctica: el estudiante implementa
    }

    @Entonces("el estado de la solicitud debe ser {string}")
    public void elEstadoDeLaSolicitudDebeSer(String estadoEsperado) {
        // Superficie de práctica: el estudiante implementa
    }
}