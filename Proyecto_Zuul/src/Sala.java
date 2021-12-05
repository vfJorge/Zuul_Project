public class Sala {
    public String nombre;
    public String descripcion;
    public Sala salidaNorte;
    public Sala salidaSur;
    public Sala salidaEste;
    public Sala salidaOeste;

    public Sala(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setSalidas(Sala norte, Sala este, Sala sur, Sala oeste){
        if(norte != null){
            salidaNorte = norte;
        }
        if(este != null){
            salidaEste = este;
        }
        if(sur != null){
            salidaSur = sur;
        }
        if(oeste != null){
            salidaOeste = oeste;
        }
    }

    public static Sala buscarSala(Sala[] salas, String strBuscar){
        for (Sala sala : salas) {
            if(strBuscar.equals(sala.getNombre())){
                return sala;
            }
        }
        return null;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
