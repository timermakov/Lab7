package Lab5.Source;

import Lab5.FileInteraction.CsvTools;
import Lab5.FileInteraction.CsvTools;
import Lab5.FileInteraction.Csv_Interchangeable;

import java.time.ZonedDateTime;

public class Person implements Csv_Interchangeable {

    String name; //Поле не может быть null, Строка не может быть пустой
    java.time.ZonedDateTime birthday; //Поле не может быть null
    float height; //Значение поля должно быть больше 0
    double weight; //Значение поля должно быть больше 0
    String passportID; //Поле не может быть null

    public Person(String name, java.time.ZonedDateTime birthday, float height, double weight, String passportID){
        if (name == null || name.equals("") || birthday == null || height <= 0 || weight <= 0 || passportID == null)
            throw new IllegalArgumentException();
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.passportID = passportID;
    }

    //getters
    public String getName() {
        return name;
    }

    public ZonedDateTime getBirthday() {
        return birthday;
    }

    public float getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getPassportID() {
        return passportID;
    }

    @Override
    public String toString() {
        return String.format("Человек: Имя: %s, Дата рождения: %tF, Рост: %f, Вес: %f, Номер паспорта: %s", name, birthday, height, weight, passportID);

        // Common date formats:
        // %tD  'D'  Date formatted as "%tm/%td/%ty".
        // %tF  'F'  ISO 8601 complete date formatted as "%tY-%tm-%td".
        // %tc  'c'  Date and time formatted as "%ta %tb %td %tT %tZ %tY", e.g. "Sun Jul 20 16:17:00 EDT 1969".
    }

    @Override
    public String createCsv() {
        return "";
    }
}
