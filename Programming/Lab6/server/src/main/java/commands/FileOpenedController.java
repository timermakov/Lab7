package commands;

import java.io.File;

/**
 * Класс отвечает за правильную работу с открытыми командой execute_script файлами
 */
public class FileOpenedController {
    private static String[] openedFiles = new String[10000];

    /**
     * Добавляет название файла в список открытых
     * @param name название файла
     */
    public static void addToOpened(String name){
        for(int i = 0; i<openedFiles.length; i++)
            if(openedFiles[i] == null){
                openedFiles[i] = new File(name).getAbsolutePath();
                break;
            }
    }

    /**
     * Убирает файл из открытых
     * @param name название файла
     */
    public static void removeFromOpened(String name){

        for (int i = 0; i<openedFiles.length; i++)
            if(new File(name).getAbsolutePath().equals(openedFiles[i])){
                openedFiles[i] = null;
                break;
            }

    }

    /**
     * Проверяет, может ли execute_script открыть файл
     * @param name название файла
     * @return true/false в зависимости от того, может ли execute_script открыть файл
     */
    public static boolean canOpen(String name){
        boolean result = true;
        for (String openedFile : openedFiles) if (new File(name).getAbsolutePath().equals(openedFile)) result = false;

        return result;
    }
}
