package source;

import fileinteraction.CsvTools;
import fileinteraction.Csv_Interchangeable;

/**
 * Координаты (x, y)
 */

public class Coordinates implements Csv_Interchangeable {

    private Integer x; //Поле не может быть null
    private double y;

    /**
     * Конструктор объекта координат
     * @param x Координата x
     * @param y Координата y
     */
    public Coordinates(Integer x, double y){
        if (x == null) throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
    }

    //getters
    public Integer getX(){
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Координаты: (%d; %f)", x, y);
    }


    @Override
    public String createCsv() {
        return CsvTools.createCsvLine(String.valueOf(x), String.valueOf(y));
    }
}

