package com.pragma.credito.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.Objects;

public class SolicitudCredito {
    @NotBlank(message = "El nombre del solicitante es obligatorio")
    private String nombreSolicitante;

    @NotNull(message = "El monto solicitado es obligatorio")
    @Positive(message = "El monto solicitado debe ser positivo")
    private Double montoSolicitado;

    @NotNull(message = "El historial crediticio es obligatorio")
    private HistorialCrediticio historialCrediticio;

    private LocalDateTime fechaSolicitud;
    private String estado;

    public SolicitudCredito(String nombreSolicitante, Double montoSolicitado, HistorialCrediticio historialCrediticio) {
        this.nombreSolicitante = Objects.requireNonNull(nombreSolicitante, "El nombre del solicitante no puede ser nulo");
        this.montoSolicitado = Objects.requireNonNull(montoSolicitado, "El monto solicitado no puede ser nulo");
        if (montoSolicitado <= 0) {
            throw new IllegalArgumentException("El monto solicitado debe ser positivo");
        }
        this.historialCrediticio = Objects.requireNonNull(historialCrediticio, "El historial crediticio no puede ser nulo");
        this.fechaSolicitud = LocalDateTime.now();
        this.estado = "PENDIENTE";
    }

    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public Double getMontoSolicitado() {
        return montoSolicitado;
    }

    public HistorialCrediticio getHistorialCrediticio() {
        return historialCrediticio;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void aprobar() {
        if (!"PENDIENTE".equals(this.estado)) {
            throw new IllegalStateException("Solo las solicitudes pendientes pueden ser aprobadas");
        }
        this.estado = "APROBADA";
    }

    public void rechazar() {
        if (!"PENDIENTE".equals(this.estado)) {
            throw new IllegalStateException("Solo las solicitudes pendientes pueden ser rechazadas");
        }
        this.estado = "RECHAZADA";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolicitudCredito that = (SolicitudCredito) o;
        return nombreSolicitante.equals(that.nombreSolicitante) &&
               montoSolicitado.equals(that.montoSolicitado) &&
               historialCrediticio.equals(that.historialCrediticio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreSolicitante, montoSolicitado, historialCrediticio);
    }
}