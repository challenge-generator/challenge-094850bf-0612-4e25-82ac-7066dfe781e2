# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Implementación de prácticas TDD y BDD en un sistema de evaluación de crédito**.

| | |
|---|---|
| Tema | TDD y BDD en calidad de software |
| Nivel | senior-l2 |
| Chapter | Calidad de Software |
| Especialidad | Automatizador |
| Stack | Java / Serenity BDD con Cucumber y JUnit 5 |
| Patron arquitectonico | Patrón Screenplay para BDD + Capas estándar para TDD (servicio, dominio, repositorio) |
| Tiempo estimado | 10 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz con el runner y el plugin de reportes`
- `src/test/resources/features con los .feature en Gherkin`
- `src/test/java/.../runners con el runner`
- `src/test/java/.../pages o /tasks con Page Objects o Screenplay`
- `src/test/java/.../steps con los step definitions`
- `serenity.conf o config del entorno`

Trampas conocidas:

- Sin parent POM que gestione versiones, TODA dependencia lleva su `<version>` completa de tres segmentos.
- El groupId de Serenity es `net.serenity-bdd`, NO `org.serenity-bdd`. Con el groupId equivocado el artefacto no existe y el build muere resolviendo dependencias.
- Coordenadas exactas de lo mas usado: Selenium `org.seleniumhq.selenium:selenium-java`, Rest Assured `io.rest-assured:rest-assured`, Karate `com.intuit.karate:karate-junit5`, Cucumber `io.cucumber:cucumber-java`.
- JUnit 5 se declara con `junit-jupiter` (agregador) y necesita `maven-surefire-plugin` reciente para ejecutarse.
- Serenity y Cucumber tienen que ser de lineas compatibles entre si; mezclarlas rompe el runner.

Dependencias:

- org.junit.jupiter:junit-jupiter 5.9.3
- net.serenity-bdd:serenity-core 4.0.45
- net.serenity-bdd:serenity-cucumber 4.0.45
- io.cucumber:cucumber-java 7.14.0
- io.cucumber:cucumber-junit-platform-engine 7.14.0
- jakarta.validation:jakarta.validation-api 3.0.2
- org.apache.maven.plugins:maven-surefire-plugin 3.1.2
- net.serenity-bdd:serenity-maven-plugin 4.0.45

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn clean test-compile` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn clean test-compile` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Exploración del sistema existente**: Documento de exploración que detalla las funcionalidades actuales, limitaciones y restricciones operativas.
- **Fase 2 — Implementación de TDD**: Código implementado con pruebas unitarias utilizando TDD.
- **Fase 3 — Implementación de BDD**: Código implementado con escenarios de comportamiento utilizando BDD.
- **Fase 4 — Evaluación y mejora continua**: Informe de evaluación que detalla la calidad del código, áreas de mejora y acciones propuestas.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/test/java/com/pragma/credito/tdd/SolicitudCreditoServiceTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/resources/features/solicitud_credito.feature` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/credito/bdd/runners/RunCucumberTest.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/credito/bdd/steps/SolicitudCreditoSteps.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/credito/bdd/tasks/RegistrarSolicitud.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/credito/bdd/questions/VerificarSolicitud.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/resources/data/solicitudes_prueba.json` — El topic pide TDD/pruebas: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/credito/bdd/abilities/InteractuarConSistema.java` — El topic pide TDD/pruebas: este archivo es el ejercicio.

## Lo que falta y tenes que completar

### 1. Referencias colgando (2)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/test/java/com/pragma/credito/tdd/SolicitudCreditoServiceTest.java` — `SolicitudCreditoService.listarSolicitudes`
      Se invoca `listarSolicitudes` sobre `SolicitudCreditoService`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/test/java/com/pragma/credito/tdd/SolicitudCreditoServiceTest.java` — `SolicitudCredito.size`
      Se invoca `size` sobre `SolicitudCredito`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Presentes (14)

- `pom.xml`
- `src/main/java/com/pragma/credito/domain/SolicitudCredito.java`
- `src/main/java/com/pragma/credito/domain/HistorialCrediticio.java`
- `src/main/java/com/pragma/credito/infrastructure/SolicitudCreditoRepository.java`
- `src/main/java/com/pragma/credito/application/SolicitudCreditoService.java`
- `src/test/java/com/pragma/credito/tdd/SolicitudCreditoServiceTest.java`
- `src/test/resources/features/solicitud_credito.feature`
- `src/test/java/com/pragma/credito/bdd/runners/RunCucumberTest.java`
- `src/test/java/com/pragma/credito/bdd/steps/SolicitudCreditoSteps.java`
- `src/test/java/com/pragma/credito/bdd/tasks/RegistrarSolicitud.java`
- `src/test/java/com/pragma/credito/bdd/questions/VerificarSolicitud.java`
- `src/test/resources/data/solicitudes_prueba.json`
- `src/test/java/com/pragma/credito/bdd/abilities/InteractuarConSistema.java`
- `serenity.conf`

### Capas del patron declarado

Cada una tiene que existir como directorio real con al menos un archivo. Codigo plano en la raiz no satisface el patron.

- `src/main/java/com/pragma/credito`
- `src/main/java/com/pragma/credito/domain`
- `src/main/java/com/pragma/credito/infrastructure`
- `src/main/java/com/pragma/credito/application`
- `src/test/java/com/pragma/credito/bdd`
- `src/test/java/com/pragma/credito/tdd`
- `src/test/resources/features`
- `src/test/resources/data`

## Verificacion

```bash
mvn clean test-compile
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **Patrón Screenplay para BDD + Capas estándar para TDD (servicio, dominio, repositorio)**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Calidad de Software, Especialidad Automatizador, Seniority Senior
- Brecha que el reto ataca: Demuestra su compromiso con la práctica de marcos como TDD y BDD, lo cual además de fortalecer su liderazgo, se traduce en la excelencia en calidad del producto, eficiencia del desarrollo y satisfacción del cliente, siendo clave para el éxito general del equipo y del proyecto
- Mision: Candidato con experiencia en calidad de software y automatización

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
