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
        return abandonarJuego;
    }
}