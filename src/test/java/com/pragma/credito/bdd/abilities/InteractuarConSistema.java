package com.pragma.credito.bdd.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import com.pragma.credito.domain.SolicitudCredito;
import com.pragma.credito.infrastructure.SolicitudCreditoRepository;
import java.util.List;
import java.util.Optional;

public class InteractuarConSistema implements Ability {

    private final SolicitudCreditoRepository repositorio;

    public InteractuarConSistema(SolicitudCreditoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public static InteractuarConSistema conRepositorio(SolicitudCreditoRepository repositorio) {
        return new InteractuarConSistema(repositorio);
    }

    public static InteractuarConSistema como(Actor actor) {
        return actor.abilityTo(InteractuarConSistema.class);
    }

    public SolicitudCredito registrarSolicitud(SolicitudCredito solicitud) {
        return repositorio.guardar(solicitud);
    }

    public Optional<SolicitudCredito> buscarSolicitud(String nombreSolicitante, Double montoSolicitado) {
        return repositorio.buscarPorNombreYMonto(nombreSolicitante, montoSolicitado);
    }

    public List<SolicitudCredito> listarTodasLasSolicitudes() {
        return repositorio.listarTodas();
    }

    public Optional<SolicitudCredito> buscarPorId(String id) {
        return repositorio.buscarPorId(id);
    }

    public void limpiarDatos() {
        repositorio.eliminarTodas();
    }
}