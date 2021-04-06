package Lab5.Exceptions;

/**
 * Возникает, если введённое значение пустое
 */
public class ValueIsEmptyException extends Exception {
    public ValueIsEmptyException() {
        System.out.println("Поле не может быть null");
    }

}
