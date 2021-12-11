package Resources;
public class Sala {
    public String nombre;
    public String descripcion;
    private Sala salidaNorte;
    private Sala salidaSur;
    private Sala salidaEste;
    private Sala salidaOeste;

    public Sala(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * 
     * @param norte
     * @param este
     * @param sur
     * @param oeste
     */
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

    /**
     * 
     * @param salas arreglo de salas
     * @param strBuscar nombre de sala a buscar
     * @return la <b>sala</b> encontrada, de otra forma null
     */
    public static Sala buscarSala(Sala[] salas, String strBuscar){
        for (Sala sala : salas) {
            if(strBuscar.equals(sala.getNombre())){
                return sala;
            }
        }
        return new NullSala();
    }

    public String getDescripcion(){
        return descripcion;
    }

    public String getNombre(){
        return nombre;
    }

    public Sala getSalidaNorte() {
        return salidaNorte;
    }

    public Sala getSalidaSur() {
        return salidaSur;
    }

    public Sala getSalidaEste() {
        return salidaEste;
    }

    public Sala getSalidaOeste() {
        return salidaOeste;
    }

    public  boolean isNull(){
        return false;
    }
    //Refactoring reference to value
    //Se hizo para poder comparar objetos de tipo sala en las pruebas unitarias
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sala other = (Sala) obj;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        return true;
    }
    
}