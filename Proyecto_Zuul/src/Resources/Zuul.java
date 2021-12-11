package Resources;

import java.io.File;

public class Zuul {
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.crearSalas(new File("salas.txt"));
        juego.jugar();
    }
}