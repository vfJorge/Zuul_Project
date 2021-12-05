public class Juego {
    private Sala salaActual;

    public Juego(){
        crearSalas();
    }

    private void crearSalas(){
        ArchivoSalas archivoSalas = new ArchivoSalas("salas.txt");
        salaActual = archivoSalas.crearSalas();
    }

    public void jugar(){
        imprimirBienvenida();
    }

    private void imprimirBienvenida(){
        System.out.println("¡Bienvenido a Zuul!\nZuul es un nuevo juego increíblemente aburrido.\nEscribe 'ayuda' si necesitas ayuda.");
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
        System.out.println("Tus comandos son: \n go quit help");
    }
}