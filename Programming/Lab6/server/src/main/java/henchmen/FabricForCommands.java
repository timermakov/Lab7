package henchmen;

import commands.*;

import java.util.LinkedList;
import java.util.List;

public class FabricForCommands {
    private LinkedList<Command> arrayList = new LinkedList<>();
    private LinkedList<String> noInputCommands = new LinkedList<>();
    private LinkedList<String> oneArgCommands = new LinkedList<>();
    private LinkedList<String> elementCommands = new LinkedList<>();
    private LinkedList<String> disciplineCommands = new LinkedList<>();

    public FabricForCommands() {
        addCommandsToList(arrayList);
        addCommandToTypedLists();
    }

    public LinkedList<Command> getAllCommandsLinkedList() {
        return arrayList;
    }

    private void addCommandsToList(List<Command> list) {
        /*list.add(new Help());
        list.add(new History());
        list.add(new Exit());
        list.add(new Show());
        list.add(new Info());
        list.add(new RemoveByKey());
        list.add(new Clear());
        list.add(new RemoveLower());
        list.add(new ExecuteScript());
        list.add(new AverageMinimalPoint());
        list.add(new PrintDescendingDifficulty());
        list.add(new RemoveAnyByDiscipline());
        list.add(new InsertKey());
        list.add(new Update());
        list.add(new Save());
        list.add(new Connect());
        list.add(new Login());
        list.add(new Register()); */
    }

    private void addCommandToTypedLists() {
        for (Command command: arrayList) {
            for (CommandType commandType: command.getCommandType()) {
                if (commandType == CommandType.NOINPUT) noInputCommands.add(command.getName());
                else if (commandType == CommandType.ONEARG) oneArgCommands.add(command.getName());
                else if (commandType == CommandType.DISCIPLINE) disciplineCommands.add(command.getName());
                else if (commandType == CommandType.ELEMENT) elementCommands.add(command.getName());
            }
        }
    }

    public LinkedList<String> getNoInputCommands() {
        return noInputCommands;
    }

    public LinkedList<String> getOneArgCommands() {
        return oneArgCommands;
    }

    public LinkedList<String> getElementCommands() {
        return elementCommands;
    }

    public LinkedList<String> getDisciplineCommands() {
        return disciplineCommands;
    }

    public boolean ifContainsInNoInputCommands(String command) {
        return noInputCommands.contains(command);
    }
    public boolean ifContainsInElementCommands(String command) {
        return elementCommands.contains(command);
    }
    public boolean ifContainsInDisciplineCommands(String command) {
        return disciplineCommands.contains(command);
    }
    public boolean ifContainsInOneArgCommands(String command) {
        return oneArgCommands.contains(command);
    }
}
