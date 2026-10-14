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