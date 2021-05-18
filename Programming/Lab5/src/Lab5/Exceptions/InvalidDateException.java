package Lab5.Exceptions;

/**
 * Возникает, если некорректно введена дата
 */
public class InvalidDateException extends Exception{
    public InvalidDateException() {
        System.out.println("Некорректный ввод даты. Введите в формате YYYY-MM-DD");
    }

}
