package Resources;

import Exceptions.PuertaInexistenteException;

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
            imprimirSalida();
            return salaActual;
        }

        String direccion = comando.getSegundaPalabra();
        Sala siguienteSala = buscarSalida(salaActual, direccion);

        try{
            if(siguienteSala.isNull()){
                throw new PuertaInexistenteException("¡No existe esa puerta!");
            }
            else{
                salaActual = siguienteSala;        
                imprimirSalida();
            }
        }
        catch(PuertaInexistenteException e){
            System.out.println(e.getMessage());
        }
        
        return salaActual;
    }

    private Sala buscarSalida(Sala salaActual,String direccion){
        if(direccion.equals("norte")){
            return salaActual.getSalidaNorte();
        }
        if(direccion.equals("este")){
            return salaActual.getSalidaEste();
        }
        if(direccion.equals("sur")){
            return salaActual.getSalidaSur();
        }
        if(direccion.equals("oeste")){
            return salaActual.getSalidaOeste();
        }
        return new NullSala();
    }

    private void imprimirSalida(){
        System.out.println("Te encuentras " + salaActual.getDescripcion());
            System.out.print("Salidas: ");
            if(!salaActual.getSalidaNorte().isNull()) {
                System.out.print("norte ");
            }
            if(!salaActual.getSalidaEste().isNull()) {
                System.out.print("este ");
            }
            if(!salaActual.getSalidaSur().isNull()) {
                System.out.print("sur ");
            }
            if(!salaActual.getSalidaOeste().isNull()) {
                System.out.print("oeste ");
            }
            System.out.println();
    }    
}
