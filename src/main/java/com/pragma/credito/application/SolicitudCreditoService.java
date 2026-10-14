package com.pragma.credito.application;

import com.pragma.credito.domain.HistorialCrediticio;
import com.pragma.credito.domain.SolicitudCredito;
import com.pragma.credito.infrastructure.SolicitudCreditoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class SolicitudCreditoService {
    
    private final SolicitudCreditoRepository solicitudCreditoRepository;
    
    public SolicitudCreditoService(SolicitudCreditoRepository solicitudCreditoRepository) {
        this.solicitudCreditoRepository = solicitudCreditoRepository;
    }
    
    public SolicitudCredito registrarSolicitud(String nombreSolicitante, Double montoSolicitado, 
            Integer puntajeRiesgo, Integer numeroIncumplimientos, Boolean tieneDeudasVencidas) {
        validarMontoPositivo(montoSolicitado);
        validarNombreNoVacio(nombreSolicitante);
        
        HistorialCrediticio historial = new HistorialCrediticio(
            puntajeRiesgo != null ? puntajeRiesgo : 0,
            numeroIncumplimientos != null ? numeroIncumplimientos : 0,
            tieneDeudasVencidas != null ? tieneDeudasVencidas : false
        );
        
        SolicitudCredito solicitud = new SolicitudCredito(
            nombreSolicitante,
            montoSolicitado,
            historial
        );
        
        verificarDuplicado(solicitud);
        
        SolicitudCredito solicitudGuardada = solicitudCreditoRepository.guardar(solicitud);
        return solicitudGuardada;
    }
    
    private void validarMontoPositivo(Double monto) {
        if (monto == null) {
            throw new IllegalArgumentException("El monto solicitado no puede ser nulo");
        }
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto solicitado debe ser positivo");
        }
    }
    
    private void validarNombreNoVacio(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del solicitante no puede estar vacío");
        }
    }
    
    private void verificarDuplicado(SolicitudCredito solicitud) {
        Optional<SolicitudCredito> existente = solicitudCreditoRepository
            .buscarPorNombreYMonto(solicitud.getNombreSolicitante(), solicitud.getMontoSolicitado());
        
        if (existente.isPresent()) {
            throw new IllegalStateException("Ya existe una solicitud de crédito para el solicitante "
                + solicitud.getNombreSolicitante() + " con el monto especificado");
        }
    }
    
    public List<SolicitudCredito> listarTodasLasSolicitudes() {
        return solicitudCreditoRepository.listarTodas();
    }
    
    public Optional<SolicitudCredito> buscarSolicitudPorId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID de la solicitud no puede estar vacío");
        }
        return solicitudCreditoRepository.buscarPorId(id);
    }
    
    public void aprobarSolicitud(String id) {
        Optional<SolicitudCredito> solicitudOpt = buscarSolicitudPorId(id);
        if (solicitudOpt.isEmpty()) {
            throw new IllegalArgumentException("No se encontró la solicitud con ID: " + id);
        }
        SolicitudCredito solicitud = solicitudOpt.get();
        solicitud.aprobar();
        solicitudCreditoRepository.guardar(solicitud);
    }
    
    public void rechazarSolicitud(String id) {
        Optional<SolicitudCredito> solicitudOpt = buscarSolicitudPorId(id);
        if (solicitudOpt.isEmpty()) {
            throw new IllegalArgumentException("No se encontró la solicitud con ID: " + id);
        }
        SolicitudCredito solicitud = solicitudOpt.get();
        solicitud.rechazar();
        solicitudCreditoRepository.guardar(solicitud);
    }
    
    public boolean evaluarRiesgo(SolicitudCredito solicitud) {
        if (solicitud == null || solicitud.getHistorialCrediticio() == null) {
            return false;
        }
        String evaluacion = solicitud.getHistorialCrediticio().evaluarRiesgo();
        return "BAJO".equals(evaluacion) || "MEDIO".equals(evaluacion);
    }
    
    public void limpiarSolicitudes() {
        solicitudCreditoRepository.eliminarTodas();
    }
}