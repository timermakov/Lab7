package Lab5.Exceptions;

/**
 * Возникает, если некорректно введён уровень сложности
 */
public class InvalidConstantException extends Exception{
    public InvalidConstantException() {
        System.out.println("Некорректный ввод уровня сложности");
    }

}
