package Lab5.FileInteraction;

import Lab5.Source.LabWork;
import java.io.*;
import java.util.LinkedList;

/**
 Класс отвечает за работу с файлом
 */
public class FileInteractor {

    private String path;
    private static FileInteractor instance = null;

    private FileInteractor(String path) throws IOException{
        this.path = path;
        File f = new File(path);
        if (!f.exists()){
            throw new IOException();
        }
    }

    /**
     * Инициализирует FileInteractor
     * @param path Путь с котором будет работать программа
     * @throws IOException Если путь не найден, бросает IOException
     */
    public static void init(String path) throws IOException{
        instance = new FileInteractor(path);
    }

    /**
     * Возвращает инициализированный FileInteractor
     * @return элемент класса FileInteractor
     */
    public static FileInteractor getInstance(){
        if (instance == null) throw new NullPointerException();
        return instance;
    }

    /**
     * Извлекает коллекцию элементов LabWork из файла
     * @return LinkedList из элементов LabWork
     * @throws IOException если во время чтения файла произошла ошибика
     */
    public LinkedList<LabWork> readData() throws IOException{
        if (new File(path).length() == 0) return new LinkedList<LabWork>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            LinkedList<LabWork> elementsList = new LinkedList<>();
            String line = reader.readLine();
            while(line!=null && line.length()!=0) {
                String[] data = CsvTools.getData(line);
                elementsList.add(ClassesCreator.createLabWork(data));
                line = reader.readLine();
            }
            reader.close();
            return elementsList;
        }
        catch(Exception e){
            System.out.println("Ошибка чтения файла, создана пустая коллекция");
            return new LinkedList<LabWork>();
        }
    }

    /**
     * Сохраняет коллекцию в файл
     * @param elements LinkedList из элементов LabWork
     * @throws IOException если во время записи данных произойдет ошибка
     */
    public void writeData(LinkedList<LabWork> elements) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        for (Object element: elements){
            writer.println(((Csv_Interchangeable)element).createCsv());
        }
        writer.close();
    }

}
