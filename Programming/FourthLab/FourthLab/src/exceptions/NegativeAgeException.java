package exceptions;
// checked
public class NegativeAgeException extends Exception {

    int age;

    public NegativeAgeException(){

    }

    public NegativeAgeException(String msg, int age){
        super(msg);
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
