# TpThreads
Trabajo practico N2 - Threads (Hangman)

# Diferencia entre Thread y Runnable

Ambas maneras al final hacen lo mismo, correr una porción de codigo concurrentemente en el procesador.
Una gran diferencia es que Thread es una clase por lo tanto quien la utilice debe extender de ella, por lo tanto, esa clase se queda sin poder extender de otra ya que en java no existe herencia multiple, en cambio Runnable es una interface, por lo tanto si una clase tiene herencia y debe usar hilos, se verá obligada a implementar Runnable.

#Ciclo de vida de un Thread:

1.New: El thread ha sido creado pero no inicializado, es decir, no se ha ejecutado todavía el método start().

2.Runnable: El thread puede estar ejecutándose, siempre y cuando se le haya asignado un determinado tiempo de CPU. En la práctica puede no estar siendo ejecutado en un instante determinado en beneficio de otro thread.

3.Not Runnable: El thread podría estar ejecutándose, pero hay alguna actividad interna suya que lo impide, como por ejemplo una espera producida por una operación de escritura o lectura de datos por teclado (E/S). Si un thread está en este estado, no se le asigna tiempo de CPU.

4.Muerto (Dead): La forma habitual de que un thread muera es finalizando el método run(). También puede llamarse al método stop() de la clase Thread, aunque dicho método es considerado “peligroso” y no se debe utilizar.

# Metodos de Thread:

Start(): Este método indica al intérprete de Java que cree un contexto del hilo del sistema y comience a ejecutarlo. A continuación, el método run() de este hilo será invocado en el nuevo contexto del hilo. 

Sleep(): El método sleep() provoca que el intérprete ponga al hilo en curso a dormir durante el número de milisegundos que se indiquen en el parámetro de invocación. Una vez transcurridos esos milisegundos, dicho hilo volverá a estar disponible para su ejecución.

Yield(): Este método hace que el intérprete cambie de contexto entre el hilo actual y el siguiente hilo ejecutable disponible. Es una manera de asegurar que los hilos de menor prioridad no sufran inanición.

Join(): Este método une a un hilo con el que lo está llamando, es decir, el hilo que invoca al metodo va a esperar que el hilo al cual le hacemos join termine su metodo run, para seguir adelante.
