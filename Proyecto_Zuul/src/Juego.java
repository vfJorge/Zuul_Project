import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.crypto.AEADBadTagException;

public class Juego {
    private Sala salaActual;

    public Juego(){
        crearSalas();
    }

    private void crearSalas(){
        try {
            File archivo = new File("salas.txt");
            Scanner lector = new Scanner(archivo);
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
            salaActual = Sala.buscarSala(salas, strSalaActual);
            lector.close();
            /*if(!validarSalas(salas)){
                System.out.println("LAS SALAS NO ESTAN BIEN CONECTADAS.");
            }*/
            for (int i = 0; i < salas.length; i++) {
                System.out.println(salas[i].getNombre() + " " + salas[i].getSalidas());
            }
          } catch (FileNotFoundException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
          }
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