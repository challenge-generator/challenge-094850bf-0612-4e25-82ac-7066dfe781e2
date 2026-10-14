package com.pragma.credito.bdd.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Optional;

public class VerificarSolicitud implements Question<String> {

    private final String nombreSolicitante;
    private final Double montoSolicitado;

    public VerificarSolicitud(String nombreSolicitante, Double montoSolicitado) {
        this.nombreSolicitante = nombreSolicitante;
        this.montoSolicitado = montoSolicitado;
    }

    public static VerificarSolicitud elEstadoDe(String nombre, Double monto) {
        return new VerificarSolicitud(nombre, monto);
    }

    @Override
    public String answeredBy(Actor actor) {
        // Superficie de práctica: el estudiante implementa
        // Debe consultar el repositorio y retornar el estado de la solicitud
        // Opcional: puede retornar un mensaje de error si no existe
        return null;
    }

    public static Question<Boolean> queExista(String nombre, Double monto) {
        return new Question<Boolean>() {
            @Override
            public Boolean answeredBy(Actor actor) {
                // Superficie de práctica: el estudiante implementa
                return false;
            }
        };
    }
}