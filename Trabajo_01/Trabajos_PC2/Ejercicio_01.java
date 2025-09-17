/*tablas hash
  Las tablas hash son estructuras de datos que permiten almacenar y recuperar información de manera eficiente.
  Utilizan una función hash para calcular un índice en una tabla, donde se almacena el valor asociado a una clave.
  Esto permite un acceso rápido a los datos, ya que la búsqueda se realiza en tiempo constante en promedio.
  Sin embargo, el rendimiento puede verse afectado por colisiones, que ocurren cuando dos claves diferentes generan el mismo índice.
  Para manejar colisiones, se pueden utilizar técnicas como la encadenamiento o la direccionamiento abierto.
*/
/* Ejemplos de funciones hash comunes son:
  - Función hash de división: calcula el índice como el resto de la división de la clave por el tamaño de la tabla.
  - Función hash multiplicativa: utiliza una constante fraccional para multiplicar la clave y luego extrae la parte fraccional para determinar el índice.
  - Función hash universal: selecciona una función hash al azar de una familia de funciones para minimizar las colisiones.
*/