package exceptions;
// unchecked
public class NameLengthRuntimeException extends RuntimeException {

    String name;

    public NameLengthRuntimeException(){

    }

    public NameLengthRuntimeException(String msg, String name){
        super (msg);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
