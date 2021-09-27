package logic;

import commands.CommandKeeper;
//import commands.noinput.Save;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import commands.Command;
import henchmen.CommandHistory;
import henchmen.FabricForCommands;
import source.LabWork;


import java.util.*;

public class CMDManager {
    private static CMDManager cmdManager;
    private CommandHistory commandHistory = new CommandHistory();
    private static final Logger logger
            = LoggerFactory.getLogger(CMDManager.class);
    private final LinkedList<Command> commands = new LinkedList<>();
    private Editor editor;
    public CMDManager() {
        //FabricForCommands fabricForCommands = new FabricForCommands();
        //commands.addAll(fabricForCommands.getAllCommandsLinkedList());
        CommandKeeper commandKeeper = new CommandKeeper();
        //commands.addAll((Collection<? extends Command>) commandKeeper.getAllCommandsLinkedList());
        //editor = new Editor("collection.json");
        cmdManager = this;
    }
    public CMDManager(String path) {
        this();
        editor = new Editor(path);
        cmdManager = this;
    }
    private String getHistory(int number) {
        return commandHistory.getPureHistory(number);
    }
    public OutputData execute(Editor editor, String justCommand, InputData inputData) {
        return getOutputData(justCommand, inputData, editor);
    }
    public OutputData execute(String justCommand, InputData inputData) {
        return getOutputData(justCommand, inputData, editor);
    }
    public OutputData execute(InputData inputData) {
        return getOutputData(inputData.getCommandName(), inputData, editor);
    }

    private OutputData getOutputData(String justCommand, InputData inputData, Editor editor) {
        System.out.println(justCommand);
        Command command = getCommandByString(justCommand);
        if (inputData.getCommandArg() != null)
            commandHistory.add(justCommand + " " + inputData.getCommandArg());
        else commandHistory.add(justCommand);
        logger.warn(String.format("Executing command: %s with InputData: %s", justCommand, inputData));
        if (justCommand.equals("history")) {
            logger.warn("Recognized history.");
            return new OutputData("Success", getHistory(7));
        }
        OutputData result;
        try {
            result = command.exec(editor, inputData);
            logger.warn("Executed command.");
        } catch (NullPointerException e) {
            logger.error("Command was not found.");
            result = new OutputData("Error", "Command was not found. Try again.");
        }
        return result;
    }

    private Command getCommandByString(String command) {
        for (Command command1: commands) {
            if (command1.getName().equals(command)) {
                return command1;
            }
        }
        return null;
    }

    public static CMDManager getInstance() {
        return cmdManager;
    }

    public Editor getCollection() {
        return editor;
    }
/*
    public OutputData save() {
        //return new commands.Save().execute(labWork, new InputData());
    }*/
}
