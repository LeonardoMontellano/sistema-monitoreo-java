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
Se representaran por medio de objetos tanto los 
tanques como los sensores asociados a cada tanque:
### Tanque
Representa el objeto fisico con almacenamiento, es 
necesario ya que facilita la organizacion y acceso a
los datos de los objetos fisicos, se encargara de
controlar las acciones del tanque asi como su estado
actual.
### Sensores
Representa sensores para medir el nivel de llenado 
del tanque, es necesario ya que toda la logica para
evitar problemas con el contenido del tanque se basa
en poder saber su nivel constantemente, se encarga
de transmitir el nivel de llenado de su respectivo
tanque asociado.