package Testing;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import Resources.ArchivoSalas;
import Resources.Comando;
import Resources.Juego;
import Resources.Sala;

public class Zuul_Testing {
    @TempDir Path tempDir;
    @BeforeEach public void crearArchivoSalas() {
        try {
            Path file = tempDir.resolve("salas.txt");
            FileWriter fw = new FileWriter(file.toFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("5,afuera\n");
            bw.write("afuera,afuera de la entrada principal de la universidad\n");
            bw.write("teatro,en un teatro de lectura\n");
            bw.write("taberna,en la taberna del campus\n");
            bw.write("laboratorio,en el laboratorio de computacion\n");
            bw.write("oficina,en la oficina de administracion\n");
            bw.write("null,teatro,laboratorio,taberna\n");
            bw.write("null,null,null,afuera\n");
            bw.write("null,afuera,null,null\n");
            bw.write("afuera,oficina,null,null\n");
            bw.write("null,null,null,laboratorio\n");
            bw.close();
            System.out.println("El archivo \"salas.txt\" se creo correctamente de manera temporal");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo");
            e.printStackTrace();
        }
    }

    @Test
    void testCrearSalas() {
        Path file = tempDir.resolve("salas.txt");
        ArchivoSalas archivoSalas = new ArchivoSalas(file.toFile());
        Sala salaInicio =  new Sala("afuera","afuera de la entrada principal de la universidad");

        assertEquals(salaInicio, archivoSalas.crearSalas());
    }

    @Test
    void testEntrarSala() {
        Path file = tempDir.resolve("salas.txt");
        Juego juego = new Juego();
        juego.crearSalas(file.toFile());
        Comando comando = new Comando("ir","ads");
        Sala salaInicio =  new Sala("afuera","afuera de la entrada principal de la universidad");
        Sala salaActual = juego.entrarSala(comando);

        assertEquals(salaInicio, salaActual);
        
    }

    
}
