package com.pragma.credito.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

public class HistorialCrediticio {
    @NotNull(message = "El puntaje de riesgo es obligatorio")
    @Min(value = 300, message = "El puntaje de riesgo mínimo es 300")
    @Max(value = 850, message = "El puntaje de riesgo máximo es 850")
    private Integer puntajeRiesgo;

    private Integer numeroIncumplimientos;
    private Boolean tieneDeudasVencidas;

    public HistorialCrediticio(Integer puntajeRiesgo, Integer numeroIncumplimientos, Boolean tieneDeudasVencidas) {
        this.puntajeRiesgo = Objects.requireNonNull(puntajeRiesgo, "El puntaje de riesgo no puede ser nulo");
        if (puntajeRiesgo < 300 || puntajeRiesgo > 850) {
            throw new IllegalArgumentException("El puntaje de riesgo debe estar entre 300 y 850");
        }
        this.numeroIncumplimientos = numeroIncumplimientos != null ? numeroIncumplimientos : 0;
        this.tieneDeudasVencidas = tieneDeudasVencidas != null ? tieneDeudasVencidas : false;
    }

    public Integer getPuntajeRiesgo() {
        return puntajeRiesgo;
    }

    public Integer getNumeroIncumplimientos() {
        return numeroIncumplimientos;
    }

    public Boolean getTieneDeudasVencidas() {
        return tieneDeudasVencidas;
    }

    public String evaluarRiesgo() {
        if (puntajeRiesgo >= 700) {
            return "BAJO";
        } else if (puntajeRiesgo >= 500) {
            return "MEDIO";
        } else {
            return "ALTO";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistorialCrediticio that = (HistorialCrediticio) o;
        return puntajeRiesgo.equals(that.puntajeRiesgo) &&
               Objects.equals(numeroIncumplimientos, that.numeroIncumplimientos) &&
               Objects.equals(tieneDeudasVencidas, that.tieneDeudasVencidas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(puntajeRiesgo, numeroIncumplimientos, tieneDeudasVencidas);
    }
}