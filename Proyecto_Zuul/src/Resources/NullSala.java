package Resources;

public class NullSala extends Sala{
    public NullSala(){
        super("", "");
    }

    @Override
    public boolean isNull() {
        return true;
    }
}
