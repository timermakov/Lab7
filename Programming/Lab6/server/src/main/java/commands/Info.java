package commands;

import source.LabWork;

import java.util.LinkedList;

/**
 * Класс с методом, выводящем информацию о коллекции
 */
public class Info implements Executable {

    @Override
    public boolean isDesired(String name) {
        return "INFO".equals(name.toUpperCase());
    }

    @Override
    public boolean execute(LinkedList<LabWork> list, String arg) {
        if(list == null || list.size()==0){
            System.out.println("Пустая коллекция");
            return true;
        }
        java.time.ZonedDateTime minDate = list.get(0).getCreationDate();
        for(LabWork labWork : list)
            if (labWork.getCreationDate().compareTo(minDate)<0) minDate = labWork.getCreationDate();

        System.out.println("Коллекция из элементов LabWork\nСоздана " + minDate +"\nРазмер: " +list.size()+ " элемент(а/ов)");
        return true;
    }
}
