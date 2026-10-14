package com.pragma.credito.infrastructure;

import com.pragma.credito.domain.SolicitudCredito;
import java.util.List;
import java.util.Optional;

public interface SolicitudCreditoRepository {
    SolicitudCredito guardar(SolicitudCredito solicitud);
    Optional<SolicitudCredito> buscarPorNombreYMonto(String nombreSolicitante, Double montoSolicitado);
    List<SolicitudCredito> listarTodas();
    Optional<SolicitudCredito> buscarPorId(String id);
    void eliminarTodas();
}