package exceptions;
// unchecked
public class NegativeAgeRuntimeException extends RuntimeException {

    int age;

    public NegativeAgeRuntimeException(){

    }

    public NegativeAgeRuntimeException(String msg, int age){
        super(msg);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
