import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArchivoSalas {
    File archivo;
    Scanner lector;
    
    public ArchivoSalas(String nombreArchivo){
        archivo = new File(nombreArchivo);
        try {
            lector = new Scanner(archivo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

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
        // imprimir salas con sus salidas
        /*for (Sala sala : salas) {
            System.out.println(sala.getNombre() + " " + sala.getSalidas());
        }*/
        return Sala.buscarSala(salas, strSalaActual);
        /*if(!validarSalas(salas)){
            System.out.println("LAS SALAS NO ESTAN BIEN CONECTADAS.");
        }*/
    }

    /*private boolean validarSalas(Sala[] salas){
        for (Sala sala : salas) {
            if((sala.getSalidaNorte() != null) 
            && !(sala.getSalidaNorte().getSalidaSur() != null) 
            && !(sala.getNombre().equals(sala.getSalidaNorte().getSalidaSur().getNombre()))){
                return false;
            }
        }
        return true;
    }*/
}
