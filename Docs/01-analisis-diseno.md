# Documento de Análisis y Diseño - Sistema de Monitoreo

- **Estudiante A:** Leonardo Montellano González (Modelo de Tanque)
- **Estudiante B:** Aaron Emmanuel Trejo Mendoza (Modelo de Sensor)
- **Fecha de inicio:** [3/9/26]
# Descripción del problema 
Se pretende representar un sistema automatico de 
control y gestion de tanques de almacenamiento.

Será necesario manejar la información de sensores
para monitorear el nivel de los tanques de 
almacenamiento asi como su estado.

El programa permitirá controlar el estado de los 
tanques, es decir, permitirá activar su llenado, 
su vaciado o detener su operación.

Se debera tener en cuenta que el tanque no puede 
superar su capacidad maxima ni quedar 
completamente vacio ni con nivel negativo.

# Identificación de objetos
Se representarán por medio de objetos tanto los 
tanques como los sensores asociados a cada tanque:
### Tanque
Representa el objeto físico con almacenamiento, es 
necesario, ya que facilita la organización y acceso a
los datos de los objetos físicos, se encargara de
controlar las acciones del tanque asi como su estado
actual.
### Sensores
Representa sensores para medir el nivel de llenado 
del tanque, es necesario, ya que toda la lógica para
evitar problemas con el contenido del tanque se basa
en poder saber su nivel constantemente, se encarga
de transmitir el nivel de llenado de su respectivo
tanque asociado.

# Estado y comportamiento

| Objeto propuesto | Responsabilidad                                                                                       | Informacipón que debe conservar                                                   | Comportamientos que debe realizar                                                                                                          |
|------------------|-------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| Tanque           | Administrar el nivel del liquido, garantizar sus limites de uso seguros, controlar el flujo de estado | Capacidad Maxima<br/>Nivel actual<br/>Estado de operación<br/>Identificador unico | Incrementar el nivel de liquido<br/>Disminuir el nivel de liquido<br/>Cambiar el estado a uno de reposo<br/>Calcular porcentaje de llenado |
| sensor           | Monitorear la lectura del nivel de su respectivo tanque                                               | Identificador unico<br/>Tanque relacionado<br/>Ultima lectura                     | Mostrar y actualizar nivel del tanque<br/>Consultar valor de la ultima lectura                                                             |

# Relaciones entre objetos
## ¿Qué objetos colaboran entre sí?
Los objetos que colaboran entre ellos son el tanque y el sensor. 
## ¿Qué información necesita un objeto del otro?
El sensor de nivel requiere saber periodicamente el nivel del tanque asociado asi como su capacidad Maxima para verificar que una lectura sea válida dentro de los límites establecidos.
## ¿Por qué consideran necsaria esa erlacion?
La relacion es indispensable porque los sensores permiten mantener el líquido dentro de sus rangos permisibles sin interferir en las caracteristicas del tanque.
## ¿Qué responsabilidades no deberian duplicarse entre clases?
Controlar el volumen y límites fisicos del tanque.
Gestion del estado del proceso.


# Diseño de clases

| Clase         | Atributos propuestos                                           | Tipo de dato                                 | Métodos propuestos                                                                                                                                                                                                                                                                                                                               | Responsabilidad                                                                                                                                                                              |
|:--------------|:---------------------------------------------------------------|:---------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Tanque`      | `- id`<br>`- capacidadMaxima`<br>`- nivelActual`<br>`- estado` | `String`<br>`double`<br>`double`<br>`String` | `+ Tanque(id: String, capacidadMaxima: double)`<br>`+ getId(): String`<br>`+ getCapacidadMaxima(): double`<br>`+ getNivelActual(): double`<br>`+ getEstado(): String`<br>`+ llenar(cantidad: double): void`<br>`+ vaciar(cantidad: double): void`<br>`+ detener(): void`<br>`+ calcularPorcentaje(): double`<br>`+ obtenerInformacion(): String` | Administrar el almacenamiento de líquido, regular el volumen dentro de los límites físicos seguros [0, capacidadMaxima] y gestionar los estados de operación (DETENIDO, LLENANDO, VACIANDO). |
| `SensorNivel` | `- id`<br>`- tanqueAsociado`<br>`- ultimaLectura`              | `String`<br>`Tanque`<br>`double`             | `+ SensorNivel(id: String, tanqueAsociado: Tanque)`<br>`+ getId(): String`<br>`+ leerNivel(): double`<br>`+ getUltimaLectura(): double`<br>`+ esLecturaValida(): boolean`<br>`+ obtenerReporte(): String`                                                                                                                                        | Monitorear el nivel del tanque al que está acoplado, verificar la validez física de la medición y suministrar las lecturas de instrumentación al sistema.                                    |

---

# Diagrama UML inicial

```text
+-------------------------------------------------------------+
|                           Tanque                            |
+-------------------------------------------------------------+
| - id: String                                                |
| - capacidadMaxima: double                                   |
| - nivelActual: double                                       |
| - estado: String                                            |
+-------------------------------------------------------------+
| + Tanque(id: String, capacidadMaxima: double)               |
| + getId(): String                                           |
| + getCapacidadMaxima(): double                              |
| + getNivelActual(): double                                  |
| + getEstado(): String                                       |
| + llenar(cantidad: double): void                            |
| + vaciar(cantidad: double): void                            |
| + detener(): void                                           |
| + calcularPorcentaje(): double                              |
| + obtenerInformacion(): String                              |
+-------------------------------------------------------------+
                              ^
                              | 1 (monitorea)
                              |
+-------------------------------------------------------------+
|                         SensorNivel                         |
+-------------------------------------------------------------+
| - id: String                                                |
| - tanqueAsociado: Tanque                                    |
| - ultimaLectura: double                                     |
+-------------------------------------------------------------+
| + SensorNivel(id: String, tanqueAsociado: Tanque)           |
| + getId(): String                                           |
| + leerNivel(): double                                       |
| + getUltimaLectura(): double                                |
| + esLecturaValida(): boolean                                |
| + obtenerReporte(): String                                  |
+-------------------------------------------------------------+
```

# Justificación del diseño

### 1. ¿Por qué propusieron esas clases?
Se dividió el sistema en `Tanque` y `SensorNivel` para reflejar con precisión una instalación industrial real. El tanque actúa como el contenedor físico que almacena líquido, mientras que el sensor representa el instrumento de medición acoplado a él. Separar ambas entidades evita concentrar responsabilidades incompatibles dentro de una sola clase.

### 2. ¿Cuál es la responsabilidad principal de cada clase?
* **`Tanque`:** Gestionar el almacenamiento físico de líquido, aplicar las restricciones de volumen ($0 \le \text{nivelActual} \le \text{capacidadMaxima}$) y controlar los cambios de estado del proceso (`DETENIDO`, `LLENANDO`, `VACIANDO`).
* **`SensorNivel`:** Realizar lecturas periódicas del nivel sobre el tanque al que está acoplado, verificar si la medición se encuentra dentro de los parámetros válidos de operación y emitir reportes de monitoreo.

### 3. ¿Por qué determinados atributos fueron definidos como privados?
Para proteger la integridad del sistema mediante encapsulación. Si atributos como `nivelActual` o `capacidadMaxima` fuesen públicos, cualquier método externo podría alterar directamente los valores numéricos sin validar desbordamientos, lecturas negativas o inconsistencias en los estados del proceso.

### 4. ¿Qué información decidieron proporcionar mediante los constructores?
* **`Tanque(String id, double capacidadMaxima)`:** Exige los parámetros indispensables para dar de alta un contenedor en el sistema. Los atributos `nivelActual` (iniciado en `0.0`) y `estado` (iniciado en `"DETENIDO"`) se asignan por defecto para arrancar siempre en una condición física segura.
* **`SensorNivel(String id, Tanque tanqueAsociado)`:** Obliga a vincular el sensor a un objeto `Tanque` real desde su instanciación, garantizando que el instrumento cuente con un origen de datos válido y evitando sensores huérfanos.

### 5. ¿Qué objetos se relacionan entre sí y por qué?
Se determinó una relación de **asociación unidireccional** de `SensorNivel` hacia `Tanque`. El sensor requiere interactuar con el tanque para consultar variables mediante métodos como `getNivelActual()`, pero él `Tanque` no necesita conocer la existencia ni la cantidad de sensores conectados para operar.

### 6. ¿Qué decisiones tomaron para evitar duplicar responsabilidades?
El sensor no almacena una copia local del volumen ni altera el llenado o vaciado del tanque. Toda lógica de control volumétrico recae exclusivamente en `Tanque`. El sensor actúa como un observador pasivo que únicamente toma lecturas y las reporta.

### 7. ¿Qué parte del diseño fue discutida entre ambos integrantes y qué decisión tomaron?
Se debatió si el método de lectura debía recibir la referencia del tanque como argumento cada vez (`leerNivel(Tanque t)`) o mantenerla como atributo persistente (`tanqueAsociado`). Se acordó definir `tanqueAsociado` como atributo dentro del constructor para modelar adecuadamente un entorno de automatización industrial, donde la instrumentación queda físicamente montada y cableada a un tanque en particular.
