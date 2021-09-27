package exceptions;

/**
 * Возникает, если число введено некорректно
 */
public class InvalidNumberException extends Exception{
    public InvalidNumberException() {
        System.out.println("Некорректный ввод числа");
    }

}
