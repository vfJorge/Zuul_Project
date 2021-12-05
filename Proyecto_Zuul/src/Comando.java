public class Comando {
    private String palabraComando;
    private String segundaPalabra;

    private static final String[] comandosValidos = {
        "ir", "abandonar", "ayuda"
    };

    public Comando(String primeraPalabra, String segundaPalabra){
        palabraComando = primeraPalabra;
        this.segundaPalabra = segundaPalabra;
    }

    public String getPalabraComando(){
        return palabraComando;
    }

    public String getSegundaPalabra(){
        return segundaPalabra;
    }

    public boolean esDesconocido(){
        return (palabraComando == null);
    }

    public boolean contieneSegundaPalabra(){
        return (segundaPalabra != null);
    }

    public static boolean esComando(String palabra){
        for (int i = 0; i < comandosValidos.length; i++) {
            if (comandosValidos[i].equals(palabra)) {
                return true;
            }
        }
        return false;
    }
}
