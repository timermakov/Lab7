package exceptions;

/**
 * Возникает, если введённое число меньше или равно нулю
 */
public class NotPositiveNumberException extends Exception{
    public NotPositiveNumberException() {
        System.out.println("Значение поля должно быть больше 0");
    }

}
