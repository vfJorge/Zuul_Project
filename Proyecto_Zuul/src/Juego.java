public class Juego {
    private Analizador analizador;
    private Sala salaActual;

    public Juego(){
        crearSalas();
        analizador = new Analizador();
    }

    private void crearSalas(){
        ArchivoSalas archivoSalas = new ArchivoSalas("salas.txt");
        salaActual = archivoSalas.crearSalas();
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
        
        if(salaActual.salidaNorte != null){
            System.out.println("norte ");
        }
        if(salaActual.salidaEste != null) {
            System.out.print("este ");
        }
        if(salaActual.salidaSur != null) {
            System.out.print("sur ");
        }
        if(salaActual.salidaOeste != null) {
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

        if(comando.esDesconocido()){
            System.out.println("No entiendo a lo que te refieres...");
            return false;
        }

        String palabraComando = comando.getPalabraComando();
        if(palabraComando.equals("ayuda")){
            imprimirAyuda();
        }
        else if(palabraComando.equals("ir")){
            entrarSala(comando);
        }
        else if(palabraComando.equals("abandonar")){
            abandonarJuego = abandonar(comando);
        }
        return abandonarJuego;
    }

    /**
     * Se encarga de redirigir al jugador a la sala dependiendo de la salida
     * que elija 
     * @param comando a ejecutar
     */
    private void entrarSala(Comando comando){
        if(!comando.contieneSegundaPalabra()){
            System.out.println("¿Ir a donde?");
            return;
        }

        String direccion = comando.getSegundaPalabra();

        Sala siguienteSala = null;
        if(direccion.equals("norte")){
            siguienteSala = salaActual.salidaNorte;
        }
        if(direccion.equals("este")){
            siguienteSala = salaActual.salidaEste;
        }
        if(direccion.equals("sur")){
            siguienteSala = salaActual.salidaSur;
        }
        if(direccion.equals("oeste")){
            siguienteSala = salaActual.salidaOeste;
        }

        if(siguienteSala == null){
            System.out.println("¡No existe esa puerta!");
        }
        else{
            salaActual = siguienteSala;
            System.out.println("Te encuentras " + salaActual.getDescripcion());
            System.out.print("Salidas: ");
            if(salaActual.salidaNorte != null) {
                System.out.print("norte ");
            }
            if(salaActual.salidaEste != null) {
                System.out.print("este ");
            }
            if(salaActual.salidaSur != null) {
                System.out.print("sur ");
            }
            if(salaActual.salidaOeste != null) {
                System.out.print("oeste ");
            }
            System.out.println();
        }
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