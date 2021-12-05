import java.util.Scanner;

public class Analizador {
    private Scanner lector;

    public Analizador(){
        lector = new Scanner(System.in);
    }

    public Comando getComando(){
        String input;
        String palabra1 = null;
        String palabra2 = null;

        System.out.print("> ");

        input = lector.nextLine();

        String[] palabras = input.split(" ");
        if (palabras.length>=2) {
            palabra1 = palabras[0];
            palabra2 = palabras[1];
        }
        if (palabras.length==1) {
            palabra1 = palabras[0];
        }

        if (Comando.esComando(palabra1)) {
            return new Comando(palabra1, palabra2);
        }
        else{
            return new Comando(null, palabra2);
        }
    }
}