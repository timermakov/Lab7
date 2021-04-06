package Lab5.Exceptions;

/**
 * Возникает, если введённое значение пустое
 */
public class InvalidConstantException extends Exception{
    public InvalidConstantException() {
        System.out.println("Некорректный ввод уровня сложности");
    }

}
