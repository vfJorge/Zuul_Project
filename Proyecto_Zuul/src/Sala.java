public class Sala {
    public String descripcion;
    public Sala salidaNorte;
    public Sala salidaSur;
    public Sala salidaEste;
    public Sala salidaOeste;

    public Sala(String descripcion){
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

    public String getDescripcion(){
        return descripcion;
    }
}
