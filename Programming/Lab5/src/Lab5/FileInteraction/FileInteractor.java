package Lab5.FileInteraction;

import Lab5.Source.Coordinates;
import Lab5.Source.Difficulty;
import Lab5.Source.LabWork;
import Lab5.Source.Person;

import java.io.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Locale;

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
            while((reader.readLine())!=null && line.length()!=0) {
                String[] data = CsvTools.getData(line);
                elementsList.add(ClassesCreator.createLabWork(reader));
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
     * @param elements LinkedList из жлементов LabWork
     * @throws IOException елси во время записи данных произойдет ошибка
     */
    public void writeData(LinkedList<LabWork> elements) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(path));
        for (Object element: elements){
            writer.write(((Csv_Interchangeable)element).createCsv());
        }
        writer.close();
    }
/*
    Work() throws IOException {
        labwork = new LinkedList<>();
        history = new LinkedList<>();
        dataName = "labdata.csv";
        base = new File(dataName);

        System.out.println("Здравствуйте!");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(dataName));
            String line;
            while ((line = reader.readLine()) != null) {
                int index = line.lastIndexOf(';');
                if (index == -1) {
                    System.err.println("Файл с данными пустой");
                } else {
                    data = line.split(";");

                    labwork.add(new LabWork(id, name, new Coordinates(x,y), creationDate, minimalPoint, personalQualitiesMinimum, difficulty, new Person(nameAuthor, birthday, height, nationality)));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        labwork.sort(new SortById());

        try {
            BufferedReader reader = new BufferedReader(new FileReader("history.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                int index = line.lastIndexOf(';');
                if (index == -1) {
                    System.err.println("Файл с историей пустой");
                } else {
                    historyData = line.split(";");
                    ZonedDateTime creationDate = ZonedDateTime.parse(historyData[0]);
                    String whatAct = historyData[1];

                    history.add(new History(creationDate, whatAct));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            takeComand();
        }

    }
*/

    /**
     *
     * @param myComand used to add it to history and save
     */

    /*
    public void addToHistory(String myComand){
        ZonedDateTime now = ZonedDateTime.now();
        if (history.size() >= 12) {
            history.removeLast();
        }
        history.addFirst(new History(now, myComand));

        try(PrintWriter pw = new PrintWriter("history.csv"))
        {
            for(History h : history){

                pw.println(h.getToWrite());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    */
}
