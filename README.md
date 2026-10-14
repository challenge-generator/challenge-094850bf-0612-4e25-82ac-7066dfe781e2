# Implementación de prácticas TDD y BDD en un sistema de evaluación de crédito

En el dominio de la evaluación de crédito, el sistema debe registrar solicitudes de crédito con nombre del solicitante, monto solicitado, historial crediticio y puntaje de riesgo. El sistema debe prohibir solicitudes duplicadas y con montos negativos. El objetivo es implementar estas prácticas en un sistema existente para mejorar la calidad del software y la eficiencia del desarrollo.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | TDD y BDD en calidad de software |
| **Nivel** | senior-l2 |
| **Tipo** | mixed |
| **Tiempo estimado** | 10 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y generará un ZIP listo para usar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y generará un archivo ZIP descargable. Descárgalo y extráelo en la carpeta donde quieras trabajar.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no genera el ZIP automáticamente al terminar el análisis, escríbele: "genera el ZIP ahora".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Exploración del sistema existente

**Objetivo:** Comprender las funcionalidades actuales del sistema y sus limitaciones.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Identificar las funcionalidades actuales del sistema de evaluación de crédito.
- Enumerar las limitaciones y áreas de mejora.
- Determinar las restricciones operativas, como el volumen de solicitudes y los tiempos de respuesta.

**Entregable:** Documento de exploración que detalla las funcionalidades actuales, limitaciones y restricciones operativas.

<details>
<summary>Pistas de conocimiento</summary>

- Considerar el impacto de las restricciones en la calidad del software.
- Evaluar cómo las prácticas TDD y BDD pueden abordar las limitaciones identificadas.

</details>

### Fase 2: Implementación de TDD

**Objetivo:** Aplicar TDD para mejorar la calidad del software.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Escribir pruebas unitarias antes de implementar la funcionalidad.
- Implementar la funcionalidad para pasar las pruebas.
- Refactorizar el código para mejorar su calidad.

**Entregable:** Código implementado con pruebas unitarias utilizando TDD.

<details>
<summary>Pistas de conocimiento</summary>

- Seguir el ciclo rojo-verde-refactor de TDD.
- Identificar los casos de prueba más relevantes para la funcionalidad.

</details>

### Fase 3: Implementación de BDD

**Objetivo:** Aplicar BDD para mejorar la comunicación y la calidad del software.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Escribir escenarios de comportamiento en lenguaje del negocio.
- Implementar la funcionalidad para pasar los escenarios de comportamiento.
- Validar que los escenarios de comportamiento se cumplan en el código implementado.

**Entregable:** Código implementado con escenarios de comportamiento utilizando BDD.

<details>
<summary>Pistas de conocimiento</summary>

- Utilizar un lenguaje de especificación como Gherkin para escribir los escenarios.
- Involucrar a los stakeholders en la revisión de los escenarios de comportamiento.

</details>

### Fase 4: Evaluación y mejora continua

**Objetivo:** Evaluar la implementación de TDD y BDD y proponer mejoras.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Evaluar la calidad del código implementado utilizando métricas de calidad.
- Identificar áreas de mejora en la implementación de TDD y BDD.
- Proponer acciones para mejorar la calidad del software y la eficiencia del desarrollo.

**Entregable:** Informe de evaluación que detalla la calidad del código, áreas de mejora y acciones propuestas.

<details>
<summary>Pistas de conocimiento</summary>

- Utilizar herramientas de análisis de código para evaluar la calidad.
- Considerar la retroalimentación de los stakeholders en la evaluación.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué es Test Driven Development (TDD) y cómo se aplica en un proyecto de software?
- **paraQueSirve**: ¿Para qué sirve Behavior Driven Development (BDD) y cómo mejora la comunicación en un proyecto?
- **comoSeUsa**: ¿Cómo se utilizan las prácticas TDD y BDD para mejorar la calidad del software?
- **erroresComunes**: ¿Cuáles son los errores comunes al implementar TDD y BDD y cómo se pueden evitar?
- **queDecisionesImplica**: ¿Qué decisiones implica la implementación de TDD y BDD en un proyecto y cómo afectan al equipo y al producto?

## Criterios de Evaluacion

- Implementación correcta de TDD en el sistema de evaluación de crédito.
- Implementación correcta de BDD en el sistema de evaluación de crédito.
- Evaluación y propuesta de mejoras en la implementación de TDD y BDD.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT). Devuelve un ZIP con el proyecto. Sirve si no tenes un agente en el IDE.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean test-compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
