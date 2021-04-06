package Lab5.Exceptions;

/**
 * Возникает, если введённое значение пустое
 */
public class NotPositiveNumberException extends Exception{
    public NotPositiveNumberException() {
        System.out.println("Значение поля должно быть больше 0");
    }

}
