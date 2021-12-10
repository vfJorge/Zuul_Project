package Resources;

public class Movilidad {

    Sala salaActual;
    public Movilidad(Sala salaActual) {
        this.salaActual = salaActual;
    }

    /**
     * Se encarga de redirigir al jugador a la sala dependiendo de la salida
     * que elija 
     * @param comando a ejecutar
     * @return sala en la que se encuentra despues de ejecutar el comando
     */
    public Sala entrarSala(Comando comando){
        if(!comando.contieneSegundaPalabra()){
            System.out.println("¿Ir a donde?");
            return salaActual;
        }

        String direccion = comando.getSegundaPalabra();
        Sala siguienteSala = buscarSalida(salaActual, direccion);

        if(siguienteSala.isNull()){
            System.out.println("¡No existe esa puerta!");
            return salaActual;
        }
        else{
            salaActual = siguienteSala;        
            imprimirSalida();
            return salaActual;
        }
    }

    private Sala buscarSalida(Sala salaActual,String direccion){
        if(direccion.equals("norte")){
            return salaActual.salidaNorte;
        }
        if(direccion.equals("este")){
            return salaActual.salidaEste;
        }
        if(direccion.equals("sur")){
            return salaActual.salidaSur;
        }
        if(direccion.equals("oeste")){
            return salaActual.salidaOeste;
        }
        return new NullSala();
    }

    private void imprimirSalida(){
        System.out.println("Te encuentras " + salaActual.getDescripcion());
            System.out.print("Salidas: ");
            if(!salaActual.salidaNorte.isNull()) {
                System.out.print("norte ");
            }
            if(!salaActual.salidaEste.isNull()) {
                System.out.print("este ");
            }
            if(!salaActual.salidaSur.isNull()) {
                System.out.print("sur ");
            }
            if(!salaActual.salidaOeste.isNull()) {
                System.out.print("oeste ");
            }
            System.out.println();
    }    
}
