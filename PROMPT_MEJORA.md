# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener un ZIP con el proyecto completo y arrancable.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/java/com/pragma/credito/tdd/SolicitudCreditoServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/resources/features/solicitud_credito.feature` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/pragma/credito/bdd/runners/RunCucumberTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/pragma/credito/bdd/steps/SolicitudCreditoSteps.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/pragma/credito/bdd/tasks/RegistrarSolicitud.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/pragma/credito/bdd/questions/VerificarSolicitud.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/resources/data/solicitudes_prueba.json` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- `src/test/java/com/pragma/credito/bdd/abilities/InteractuarConSistema.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/test/java/com/pragma/credito/tdd/SolicitudCreditoServiceTest.java` — `SolicitudCreditoService.listarSolicitudes`: Se invoca `listarSolicitudes` sobre `SolicitudCreditoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/credito/tdd/SolicitudCreditoServiceTest.java` — `SolicitudCredito.size`: Se invoca `size` sobre `SolicitudCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean test-compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Calidad de Software, Especialidad Automatizador, Seniority Senior

### Brecha de conocimiento
Demuestra su compromiso con la práctica de marcos como TDD y BDD, lo cual además de fortalecer su liderazgo, se traduce en la excelencia en calidad del producto, eficiencia del desarrollo y satisfacción del cliente, siendo clave para el éxito general del equipo y del proyecto

### Misión / candidato
Candidato con experiencia en calidad de software y automatización

### Reto
- Tema: TDD y BDD en calidad de software
- Seniority: senior-l2
- Tipo: mixed
- Título: Implementación de prácticas TDD y BDD en un sistema de evaluación de crédito
- Tiempo estimado: 10 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Exploración del sistema existente — objetivo: Comprender las funcionalidades actuales del sistema y sus limitaciones. — entregable (NO resolver): Documento de exploración que detalla las funcionalidades actuales, limitaciones y restricciones operativas.
- Fase 2: Implementación de TDD — objetivo: Aplicar TDD para mejorar la calidad del software. — entregable (NO resolver): Código implementado con pruebas unitarias utilizando TDD.
- Fase 3: Implementación de BDD — objetivo: Aplicar BDD para mejorar la comunicación y la calidad del software. — entregable (NO resolver): Código implementado con escenarios de comportamiento utilizando BDD.
- Fase 4: Evaluación y mejora continua — objetivo: Evaluar la implementación de TDD y BDD y proponer mejoras. — entregable (NO resolver): Informe de evaluación que detalla la calidad del código, áreas de mejora y acciones propuestas.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (ZIP).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Exportación en ZIP
Empaqueta todos los archivos en un único archivo ZIP descargable respetando exactamente
la estructura de rutas indicada por los marcadores.
El ZIP debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: El ZIP debe estar listo para descargar al finalizar. No preguntes si el usuario
quiere generarlo. Simplemente genera el archivo y proporciona el enlace de descarga; No debes desplegar en el chat el resumen de lo que arreglaste al Zip, solo entregalo.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del enlace de descarga del ZIP
No preguntes si el usuario quiere el ZIP: simplemente generalo siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.pragma</groupId>
    <artifactId>credito</artifactId>
    <version>1.0.0</version>
    <packaging>jar</packaging>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <serenity.version>4.0.45</serenity.version>
        <cucumber.version>7.14.0</cucumber.version>
        <junit.version>5.9.3</junit.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
            <version>5.14.2</version>
        </dependency>

        <!-- Compile -->
        <dependency>
            <groupId>jakarta.validation</groupId>
            <artifactId>jakarta.validation-api</artifactId>
            <version>3.0.2</version>
        </dependency>

        <!-- Test -->
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>${junit.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
            <version>${serenity.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
            <version>${serenity.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit-platform-engine</artifactId>
            <version>${cucumber.version}</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.1.2</version>
                <configuration>
                    <includes>
                        <include>**/*Test.java</include>
                        <include>**/RunCucumberTest.java</include>
                    </includes>
                </configuration>
            </plugin>
            <plugin>
                <groupId>net.serenity-bdd.maven.plugins</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.version}</version>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/credito/domain/SolicitudCredito.java ===
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

// === ARCHIVO: src/main/java/com/pragma/credito/domain/HistorialCrediticio.java ===
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

// === ARCHIVO: src/main/java/com/pragma/credito/infrastructure/SolicitudCreditoRepository.java ===
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

// === ARCHIVO: src/main/java/com/pragma/credito/application/SolicitudCreditoService.java ===
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

// === ARCHIVO: src/test/java/com/pragma/credito/tdd/SolicitudCreditoServiceTest.java ===
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

// === ARCHIVO: src/test/resources/features/solicitud_credito.feature ===
Feature: Registro de Solicitudes de Crédito

  Background:
    Given que el sistema de evaluación de crédito está operativo
    And el repositorio de solicitudes está disponible

  Scenario: Registro exitoso de solicitud de crédito con datos válidos
    Given una solicitud de crédito con nombre "Juan Pérez", monto 50000.0
    And puntaje de riesgo 750, sin incumplimientos, sin deudas vencidas
    When el usuario registra la solicitud en el sistema
    Then el sistema acepta la solicitud
    And confirma el registro con estado "PENDIENTE"

  Scenario: Rechazo de solicitud duplicada
    Given una solicitud existente con nombre "Ana García", monto 30000.0
    When el usuario intenta registrar otra solicitud con los mismos datos
    Then el sistema rechaza la solicitud
    And muestra mensaje de error "Solicitud duplicada"

  Scenario: Rechazo de solicitud con monto negativo
    Given una solicitud con nombre "Carlos López", monto -10000.0
    And puntaje de riesgo 700, un incumplimiento, sin deudas vencidas
    When el usuario intenta registrar la solicitud
    Then el sistema rechaza la solicitud
    And muestra mensaje de error "Monto no válido"

  Scenario: Aprobación automática por buen historial crediticio
    Given una solicitud con nombre "María Rodríguez", monto 100000.0
    And puntaje de riesgo 800, sin incumplimientos, sin deudas vencidas
    When el sistema evalúa el historial crediticio
    Then aprueba automáticamente la solicitud
    And establece el estado como "APROBADA"

  Scenario: Rechazo automático por riesgo alto
    Given una solicitud con nombre "Pedro Sánchez", monto 50000.0
    And puntaje de riesgo 500, tres incumplimientos, con deudas vencidas
    When el sistema evalúa el historial crediticio
    Then rechaza automáticamente la solicitud
    And establece el estado como "RECHAZADA"

  Scenario: Consulta de todas las solicitudes registradas
    Given que existen múltiples solicitudes registradas en el sistema
    When el usuario solicita listar todas las solicitudes
    Then el sistema retorna la lista completa de solicitudes
    And cada solicitud incluye nombre, monto y estado

  Scenario: Búsqueda de solicitud por identificador
    Given una solicitud registrada con ID existente
    When el usuario busca la solicitud por su identificador
    Then el sistema retorna los datos completos de la solicitud
    And el usuario puede ver el historial crediticio asociado

// === ARCHIVO: src/test/java/com/pragma/credito/bdd/runners/RunCucumberTest.java ===
package com.pragma.credito.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {
        "com.pragma.credito.bdd.steps",
        "com.pragma.credito.bdd.tasks",
        "com.pragma.credito.bdd.questions",
        "com.pragma.credito.bdd.abilities"
    },
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json",
        "junit:target/cucumber-reports/cucumber.xml"
    },
    monochrome = false,
    tags = "@smoke or @regression",
    dryRun = false
)
public class RunCucumberTest {
}

// === ARCHIVO: src/test/java/com/pragma/credito/bdd/steps/SolicitudCreditoSteps.java ===
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

// === ARCHIVO: src/test/java/com/pragma/credito/bdd/tasks/RegistrarSolicitud.java ===
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

// === ARCHIVO: src/test/java/com/pragma/credito/bdd/questions/VerificarSolicitud.java ===
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

// === ARCHIVO: src/test/resources/data/solicitudes_prueba.json ===
[
  {
    "nombreSolicitante": "Juan Pérez",
    "montoSolicitado": 5000.00,
    "puntajeRiesgo": 750,
    "numeroIncumplimientos": 0,
    "tieneDeudasVencidas": false,
    "descripcion": "Solicitud válida con excelente historial crediticio"
  },
  {
    "nombreSolicitante": "María García",
    "montoSolicitado": 15000.00,
    "puntajeRiesgo": 680,
    "numeroIncumplimientos": 1,
    "tieneDeudasVencidas": false,
    "descripcion": "Solicitud válida con riesgo moderado"
  },
  {
    "nombreSolicitante": "Carlos López",
    "montoSolicitado": -1000.00,
    "puntajeRiesgo": 800,
    "numeroIncumplimientos": 0,
    "tieneDeudasVencidas": false,
    "descripcion": "Solicitud inválida por monto negativo"
  },
  {
    "nombreSolicitante": "Ana Martínez",
    "montoSolicitado": 25000.00,
    "puntajeRiesgo": 450,
    "numeroIncumplimientos": 5,
    "tieneDeudasVencidas": true,
    "descripcion": "Solicitud inválida por mal historial crediticio"
  },
  {
    "nombreSolicitante": "Pedro Sánchez",
    "montoSolicitado": 0.00,
    "puntajeRiesgo": 700,
    "numeroIncumplimientos": 0,
    "tieneDeudasVencidas": false,
    "descripcion": "Solicitud inválida por monto cero"
  },
  {
    "nombreSolicitante": "Laura Rodríguez",
    "montoSolicitado": 8000.00,
    "puntajeRiesgo": 600,
    "numeroIncumplimientos": 2,
    "tieneDeudasVencidas": false,
    "descripcion": "Solicitud válida con algunos incumplimientos menores"
  },
  {
    "nombreSolicitante": "Juan Pérez",
    "montoSolicitado": 5000.00,
    "puntajeRiesgo": 750,
    "numeroIncumplimientos": 0,
    "tieneDeudasVencidas": false,
    "descripcion": "Duplicado de primera solicitud - debe ser rechazado"
  },
  {
    "nombreSolicitante": "Roberto Díaz",
    "montoSolicitado": 35000.00,
    "puntajeRiesgo": 550,
    "numeroIncumplimientos": 3,
    "tieneDeudasVencidas": true,
    "descripcion": "Solicitud con alto riesgo y deudas vencidas"
  }
]

// === ARCHIVO: src/test/java/com/pragma/credito/bdd/abilities/InteractuarConSistema.java ===
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

// === ARCHIVO: serenity.conf ===
serenity {
  project.name = "Sistema de Evaluación de Crédito - Pruebas BDD"
  test.skip = false
  dry.run = false
  restapi {
    baseurl = "http://localhost:8080"
    console.enabled = true
    output.json = true
    output.xml = true
  }
  requirements {
    types = Story,Feature,Requirement
    depth = 1
    children = 2
  }
  story {
    title.prefix = ""
  }
  test {
    timeout = 120
    threaded = false
  }
  logging {
    level = INFO
    threshold = WARN
  }
  sauce {
    implicit.wait = 3000
    wait.for.timeout = 10000
  }
  browser {
    proxy {
      http = ""
      https = ""
      bypass = []
      driver = null
    }
    maximize.window = true
    accept.insecure.certs = true
  }
  webdriver {
    driver = chrome
    timeouts {
      implicit = 10000
      script = 30000
      page.load = 60000
    }
    chrome {
      switches = "--start-maximized,--no-sandbox,--disable-dev-shm-usage,--disable-gpu"
      prefs {
        profile.default_content_settings.popups = 0
        download.prompt_for_download = false
        download.default_directory = "target/downloads"
      }
    }
    firefox {
      switches = ""
      profile = null
    }
    edge {
      switches = ""
    }
  }
  cucumber {
    output.formats = ["json", "html"]
    snippets = CAMELCASE
    tags = "@wip or @smoke"
    features = "src/test/resources/features"
    glue = ["com.pragma.credito.bdd.steps"]
  }
}

webdriver {
  driver = chrome
  wait.for.timeout = 15000
  implicitly.wait = 10000
}

chrome.switches="--start-maximized,--no-sandbox,--disable-dev-shm-usage,--disable-gpu,--disable-extensions"
chrome.preferences="profile.default_content_settings.popups=0"

junit {
  step.delay = 0
  reports = "target/site/serenity"
}

api {
  baseurl = "http://localhost:8080"
  timeout = 30000
  retry.enabled = true
  retry.attempts = 3
  retry.delay = 1000
}
```
