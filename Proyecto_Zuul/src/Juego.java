import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
            String[] datos = primeralinea.split(",");
            int nSalas = Integer.parseInt(datos[0]);
            
            Sala[] salas = new Sala[nSalas];
            String strSalaActual = datos[1];
            String nombreSala;
            String descripcionSala;

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
            for (int i = 0; i < salas.length; i++) {
                System.out.println(salas[i].toString());
            }
          } catch (FileNotFoundException e) {
            System.out.println("Ocurrió un error.");
            e.printStackTrace();
          }
    }
}
