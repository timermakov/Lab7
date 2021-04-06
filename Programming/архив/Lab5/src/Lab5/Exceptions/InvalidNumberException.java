package Lab5.Exceptions;

/**
 * Возникает, если введённое значение пустое
 */
public class InvalidNumberException extends Exception{
    public InvalidNumberException() {
        System.out.println("Некорректный ввод числа");
    }

}
