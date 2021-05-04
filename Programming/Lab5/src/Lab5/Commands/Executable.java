package Lab5.Commands;

import Lab5.Exceptions.ValueIsEmptyException;
import Lab5.Source.LabWork;

import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 * Интерфейс для реализации команд
 */
public interface Executable {

    /**
     * Сравнивет название команды, поданное на вход с названием этой команды
     * @param name String-название команды, которую требуется выполнить
     * @return true, если это та команда, else, если нет
     */
    boolean isDesired(String name);

    /**
     * Выполняет команду
     * @param list LinkedList из элементов LabWork, с которой мы сейчас работаем
     * @param arg Аргумент, полученный из командной строки
     * @return true или false в зависимости от того, выполнена ли команда праильно
     */
    boolean execute(LinkedList<LabWork> list, String arg);


}

/*help : вывести справку по доступным командам
info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
add {element} : добавить новый элемент в коллекцию
update id {element} : обновить значение элемента коллекции, id которого равен заданному
remove_by_id id : удалить элемент из коллекции по его id
clear : очистить коллекцию
save : сохранить коллекцию в файл
execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
exit : завершить программу (без сохранения в файл)
remove_first : удалить первый элемент из коллекции
remove_head : вывести первый элемент коллекции и удалить его
add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки
filter_greater_than_average_point averagePoint : вывести элементы, значение поля averagePoint которых больше заданного
print_ascending : вывести элементы коллекции в порядке возрастания*/
