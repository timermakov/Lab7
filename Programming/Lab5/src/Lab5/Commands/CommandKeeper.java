package Lab5.Commands;

import Lab5.Source.LabWork;

import java.util.LinkedList;

/**
 * Класс, через который происходит работа с командами
 */
public class CommandKeeper {
    private static LinkedList<Executable> commandList = new LinkedList<>();
    private static LinkedList<Executable> standardCommands = new LinkedList<>();
    private static LinkedList<Executable> scriptCommands = new LinkedList<>();


    static {
        standardCommands.add(new Show());
        standardCommands.add(new AddElement());
        standardCommands.add(new ExecuteScript());
        standardCommands.add(new AddIfMin());
        standardCommands.add(new Clear());
        standardCommands.add(new Exit());
        standardCommands.add(new FilterGreaterThanAveragePoint());
        standardCommands.add(new Help());
        standardCommands.add(new Info());
        standardCommands.add(new PrintAscending());
        standardCommands.add(new RemoveById());
        standardCommands.add(new Save());
        standardCommands.add(new Update());
        standardCommands.add(new RemoveFirst());
        standardCommands.add(new RemoveHead());
        standardCommands.add(new FilterStartsWithName());

        scriptCommands.add(new Show());
        scriptCommands.add(new AddElementFromScript());
        scriptCommands.add(new ExecuteScript());
        scriptCommands.add(new AddIfMinFromScript());
        scriptCommands.add(new Clear());
        scriptCommands.add(new Exit());
        scriptCommands.add(new FilterGreaterThanAveragePoint());
        scriptCommands.add(new Help());
        scriptCommands.add(new Info());
        scriptCommands.add(new PrintAscending());
        scriptCommands.add(new RemoveById());
        scriptCommands.add(new Save());
        scriptCommands.add(new UpdateFromScript());
        scriptCommands.add(new RemoveFirst());
        scriptCommands.add(new RemoveHead());
        scriptCommands.add(new FilterStartsWithName());
    }



    /**
     * Выполняет команду
     * @param commandName String-название команды
     * @param list LinkedList элементов LabWork, с которым мы работаем
     * @param arg Аргумент, полученный из командной строки
     * @return true или false в зависимости от того, выполнена ли команда правильно
     */
    public static boolean execute(String commandName, LinkedList<LabWork> list, String arg, String mode){

        if (mode.toUpperCase().equals("SCRIPT")) commandList = scriptCommands;
        else commandList = standardCommands;

        for(Executable command : commandList){
            if (command.isDesired(commandName)){
                try {
                    if (command.execute(list, arg)) {
                        System.out.println("Команда " + commandName + " выполнена \n");
                        return true;
                    } else {
                        System.out.println("Команда " + commandName + " не исполнена \n");
                        return false;
                    }
                }
                catch (Exception e){
                    System.out.println("Ошибка в выполнении программы \n");
                    return false;
                }
            }
        }
        System.out.println("Команда не найдена \n");
        return false;
    }

    public static boolean isCommandAvailable(String name){
        for (Executable command : commandList)
            if (command.isDesired(name)) return true;
        return false;
    }



}
