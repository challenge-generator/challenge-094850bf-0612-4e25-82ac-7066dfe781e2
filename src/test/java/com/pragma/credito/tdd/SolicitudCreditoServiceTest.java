package com.pragma.credito.tdd;

import com.pragma.credito.application.SolicitudCreditoService;
import com.pragma.credito.domain.HistorialCrediticio;
import com.pragma.credito.domain.SolicitudCredito;
import com.pragma.credito.infrastructure.SolicitudCreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SolicitudCreditoServiceTest {

    @Mock
    private SolicitudCreditoRepository solicitudRepository;

    private SolicitudCreditoService solicitudService;

    @BeforeEach
    void setUp() {
        solicitudService = new SolicitudCreditoService(solicitudRepository);
    }

    @Test
    void deberíaRegistrarSolicitudVálida() {
        // Given: existe una solicitud válida con datos completos
        HistorialCrediticio historial = new HistorialCrediticio(750, 0, false);
        SolicitudCredito solicitud = new SolicitudCredito("Juan Pérez", 50000.0, historial);
        
        when(solicitudRepository.buscarPorNombreYMonto("Juan Pérez", 50000.0))
            .thenReturn(Optional.empty());
        when(solicitudRepository.guardar(any(SolicitudCredito.class)))
            .thenReturn(solicitud);

        // When: se intenta registrar la solicitud
        SolicitudCredito resultado = solicitudService.registrarSolicitud(solicitud);

        // Then: la solicitud se registra correctamente
        assertNotNull(resultado);
        verify(solicitudRepository, times(1)).guardar(solicitud);
    }

    @Test
    void deberíaRechazarSolicitudDuplicada() {
        // Given: ya existe una solicitud con el mismo nombre y monto
        HistorialCrediticio historial = new HistorialCrediticio(750, 0, false);
        SolicitudCredito solicitudExistente = new SolicitudCredito("Ana García", 30000.0, historial);
        
        when(solicitudRepository.buscarPorNombreYMonto("Ana García", 30000.0))
            .thenReturn(Optional.of(solicitudExistente));

        // When: se intenta registrar una solicitud duplicada
        // Then: se lanza una excepción indicando duplicado
        assertThrows(IllegalArgumentException.class, () -> {
            solicitudService.registrarSolicitud(solicitudExistente);
        });
    }

    @Test
    void deberíaRechazarMontoNegativo() {
        // Given: existe una solicitud con monto negativo
        HistorialCrediticio historial = new HistorialCrediticio(700, 1, false);
        SolicitudCredito solicitud = new SolicitudCredito("Carlos López", -10000.0, historial);

        // When: se intenta registrar la solicitud
        // Then: se lanza una excepción por monto inválido
        assertThrows(IllegalArgumentException.class, () -> {
            solicitudService.registrarSolicitud(solicitud);
        });
    }

    @Test
    void deberíaAprobarSolicitudConBuenHistorial() {
        // Given: solicitud con puntaje de riesgo alto (>= 700)
        HistorialCrediticio historial = new HistorialCrediticio(800, 0, false);
        SolicitudCredito solicitud = new SolicitudCredito("María Rodríguez", 100000.0, historial);
        
        when(solicitudRepository.buscarPorNombreYMonto("María Rodríguez", 100000.0))
            .thenReturn(Optional.empty());
        when(solicitudRepository.guardar(any(SolicitudCredito.class)))
            .thenReturn(solicitud);

        // When: se evalúa la solicitud
        SolicitudCredito resultado = solicitudService.registrarSolicitud(solicitud);
        resultado.aprobar();

        // Then: la solicitud es aprobada
        assertEquals("APROBADA", resultado.getEstado());
    }

    @Test
    void deberíaRechazarSolicitudConRiesgoAlto() {
        // Given: solicitud con puntaje de riesgo bajo (< 600)
        HistorialCrediticio historial = new HistorialCrediticio(500, 3, true);
        SolicitudCredito solicitud = new SolicitudCredito("Pedro Sánchez", 50000.0, historial);
        
        when(solicitudRepository.buscarPorNombreYMonto("Pedro Sánchez", 50000.0))
            .thenReturn(Optional.empty());
        when(solicitudRepository.guardar(any(SolicitudCredito.class)))
            .thenReturn(solicitud);

        // When: se evalúa la solicitud
        SolicitudCredito resultado = solicitudService.registrarSolicitud(solicitud);
        resultado.rechazar();

        // Then: la solicitud es rechazada
        assertEquals("RECHAZADA", resultado.getEstado());
    }

    @Test
    void deberíaListarTodasLasSolicitudes() {
        // Given: existen solicitudes registradas
        HistorialCrediticio historial1 = new HistorialCrediticio(750, 0, false);
        HistorialCrediticio historial2 = new HistorialCrediticio(650, 1, false);
        
        SolicitudCredito sol1 = new SolicitudCredito("Laura Díaz", 25000.0, historial1);
        SolicitudCredito sol2 = new SolicitudCredito("Miguel Torres", 75000.0, historial2);
        
        List<SolicitudCredito> solicitudes = new ArrayList<>();
        solicitudes.add(sol1);
        solicitudes.add(sol2);
        
        when(solicitudRepository.listarTodas()).thenReturn(solicitudes);

        // When: se listan todas las solicitudes
        List<SolicitudCredito> resultado = solicitudService.listarSolicitudes();

        // Then: se retornan todas las solicitudes
        assertEquals(2, resultado.size());
        verify(solicitudRepository, times(1)).listarTodas();
    }
}