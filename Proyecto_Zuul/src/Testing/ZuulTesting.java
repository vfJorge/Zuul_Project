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
import Resources.Movilidad;
import Resources.NullSala;
import Resources.Sala;

public class ZuulTesting {
    //Crea carpeta temporal
    @TempDir Path tempDir;
    //Precondicion para ambos test
    //Crea un archivo temporal dentro de la carpeta temporal con el contenido de "salas.txt"
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
        Sala salaEste =  new Sala("teatro","en un teatro de lectura");
        Sala salaSur =  new Sala("laboratorio","en el laboratorio de computacion");
        Sala salaOeste =  new Sala("taberna","en la taberna del campus");

        Sala salaActual = archivoSalas.crearSalas();

        assertEquals(salaInicio, salaActual);
        assertEquals(new NullSala(), salaActual.salidaNorte);
        assertEquals(salaEste, salaActual.salidaEste);
        assertEquals(salaSur, salaActual.salidaSur);
        assertEquals(salaOeste, salaActual.salidaOeste);

    }

    @Test
    void testEntrarSala() {
        Path file = tempDir.resolve("salas.txt");
        ArchivoSalas archivoSalas = new ArchivoSalas(file.toFile());
        Movilidad movilidad = new Movilidad(archivoSalas.crearSalas());

        Comando comandoInvalido = new Comando("ir","norte");
        Comando comandoValido = new Comando("ir","este");
        
        Sala salaInicio =  new Sala("afuera","afuera de la entrada principal de la universidad");
        Sala salaEste =  new Sala("teatro","en un teatro de lectura");

        //Falla cuando el comando es correcto
        assertEquals(salaInicio, movilidad.entrarSala(comandoInvalido));
        //Falla cuando el comando es invalido
        assertEquals(salaEste, movilidad.entrarSala(comandoValido));
        
    }

    
}
