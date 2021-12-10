package Resources;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArchivoSalas {
    File archivo;
    Scanner lector;

    public ArchivoSalas(File archivoSalas){
        this.archivo = archivoSalas;
        try {
            lector = new Scanner(archivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Se encarga de crear las salas, asignarles su nombre y descripción respectiva
     * y enlazar las salas con sus salidas
     * @return la sala inicial del juego
     */
    public Sala crearSalas(){
        String primeralinea = lector.nextLine();
        String[] datosPrimeraLinea = primeralinea.split(",");
        int nSalas = Integer.parseInt(datosPrimeraLinea[0]);
        
        Sala[] salas = new Sala[nSalas];
        String strSalaActual = datosPrimeraLinea[1];
        String nombreSala;
        String descripcionSala;
        String[] datos;

        for (int i = 0; i < nSalas && lector.hasNextLine(); i++) {
            datos = lector.nextLine().split(",");
            nombreSala = datos[0];
            descripcionSala = datos[1];
            salas[i] = new Sala(nombreSala, descripcionSala);
        }

        Sala norte, este, sur, oeste;
        for (int i = 0; i < nSalas && lector.hasNextLine(); i++) {
            datos = lector.nextLine().split(",");
            norte = Sala.buscarSala(salas, datos[0]);
            este = Sala.buscarSala(salas, datos[1]);
            sur = Sala.buscarSala(salas, datos[2]);
            oeste = Sala.buscarSala(salas, datos[3]);
            salas[i].setSalidas(norte, este, sur, oeste);
        }
        lector.close();
        return Sala.buscarSala(salas, strSalaActual);
    }
}