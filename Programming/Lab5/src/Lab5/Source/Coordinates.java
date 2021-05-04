package Lab5.Source;

import Lab5.FileInteraction.CsvTools;
import Lab5.FileInteraction.Csv_Interchangeable;
import Lab5.FileInteraction.CsvTools;
import Lab5.FileInteraction.Csv_Interchangeable;

public class Coordinates implements Csv_Interchangeable {

    private Integer x; //Поле не может быть null
    private double y;

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

