# Inception

Inception es una plataforma para crear y reproducir cuentos apoyados por estímulos multisensoriales.

## Estructura

* Inception: Es el núcleo de la aplicación. Se encarga de integrar los demás módulos y arrancar la aplicación.
* Concurrency: Se encarga de manipular los hilos de ejecución (Threads) y provee una API para ejecutar tareas en secuencia (batch) y en paralelo.
* Model: Contiene los elementos básicos de la aplicación.
* View: Se encarga de cargar las vistas.
* Controller: Se encarga de controlar las vistas.
* PluginManagement: Se encarga del registro de plugins.