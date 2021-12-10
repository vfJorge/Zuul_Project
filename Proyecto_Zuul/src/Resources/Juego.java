package Resources;
import java.io.File;

import Exceptions.ComandoDesconocidoException;

public class Juego {
    private Analizador analizador;
    private Sala salaActual;
    private Movilidad movilidad;

    public Juego(){
        analizador = new Analizador();
    }

    public void crearSalas(File fileSalas){
        ArchivoSalas archivoSalas = new ArchivoSalas(fileSalas);
        salaActual = archivoSalas.crearSalas();
        movilidad = new Movilidad(salaActual);
    }

    /**
     * Inicia la secuencia del juego Zuul
     */
    public void jugar(){
        imprimirBienvenida();
        boolean terminado = false;
        while(!terminado){
            Comando comando = analizador.getComando();
            terminado = procesarComando(comando);
        }
        System.out.println("¡Gracias por jugar! Adios.");
    }

    private void imprimirBienvenida(){
        System.out.println("-----------------------------------------------------");
        System.out.println("¡Bienvenido a Zuul!\nZuul es un nuevo juego increíblemente aburrido.\nEscribe 'ayuda' si necesitas ayuda.");
        System.out.println("-----------------------------------------------------");
        System.out.println("Te encuentras " + salaActual.getDescripcion());
        System.out.println("Salidas: "); 
        
        if(!salaActual.salidaNorte.isNull()){
            System.out.println("norte ");
        }
        if(!salaActual.salidaEste.isNull()) {
            System.out.print("este ");
        }
        if(!salaActual.salidaSur.isNull()) {
            System.out.print("sur ");
        }
        if(!salaActual.salidaOeste.isNull()) {
            System.out.print("oeste ");
        }
        System.out.println();
    }

    private void imprimirAyuda(){
        System.out.println("Te encuentras perdido y solo. Exploras alrededor de la universidad.");
        System.out.println("Tus comandos son: \n ir abandonar ayuda");
    }

    /**
     * Se encarga de procesar el comando introducido y ejecutar la acción correspondiente 
     * al comando
     * @param comando a ejecutar
     * @return true si desea abandonar el juego, false si sigue jugando.
     */
    private boolean procesarComando(Comando comando){
        boolean abandonarJuego = false;

        try{
            if(comando.esDesconocido()){
                throw new ComandoDesconocidoException("No entiendo a lo que te refieres...");
            }
        }
        catch(ComandoDesconocidoException e){
            System.out.println(e.getMessage());
            return false;
        }

        String palabraComando = comando.getPalabraComando();
        if(palabraComando.equals("ayuda")){
            imprimirAyuda();
        }
        else if(palabraComando.equals("ir")){
            salaActual = entrarSala(comando);
        }
        else if(palabraComando.equals("abandonar")){
            abandonarJuego = abandonar(comando);
        }
        return abandonarJuego;
    }

    public Sala entrarSala(Comando comando) {
        return movilidad.entrarSala(comando);
    }

    /**
     * 
     * @param comando a ejecutar
     * @return true para terminar la ejecución del programa, false
     * para continuar con la ejecución del programa.
     */
    private boolean abandonar(Comando comando){
        if(comando.contieneSegundaPalabra()){
            System.out.println("¿Abandonar que?");
            return false;
        }
        else{
            return true;
        }
    }
}