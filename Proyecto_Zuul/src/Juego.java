public class Juego {
    private Sala salaActual;

    public Juego(){
        crearSalas();
    }

    private void crearSalas(){
        ArchivoSalas archivoSalas = new ArchivoSalas("salas.txt");
        salaActual = archivoSalas.crearSalas();
    }
}
