package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.LinkedList;

/**
 * Класс с методом, выводящим список команд
 */
public class Help implements Executable{

    @Override
    public boolean isDesired(String name) {
        return "HELP".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {
        System.out.println("\nСписок команд представлен ниже\n" +
                "help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                "history : вывести последние 5 команд (без их аргументов)\n" +
                "remove_any_by_chapter chapter : удалить из коллекции один элемент, значение поля chapter которого эквивалентно заданному\n" +
                "group_counting_by_heart_count : сгруппировать элементы коллекции по значению поля heartCount, вывести количество элементов в каждой группе\n" +
                "print_descending : вывести элементы коллекции в порядке убывания");
        return true;
    }
}
