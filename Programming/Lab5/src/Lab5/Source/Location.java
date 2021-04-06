package Lab5.Source;

import Lab5.FileInteraction.CsvTools;
import Lab5.FileInteraction.CsvTools;
import Lab5.FileInteraction.Csv_Interchangeable;

public class Location implements Csv_Interchangeable {
    private Float x; //Поле не может быть null
    private int y;
    private Long z; //Поле не может быть null

    public Location(Float x, int y, Long z){
        if (x == null || z == null) throw new IllegalArgumentException();
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //getters
    public Float getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Long getZ() {
        return z;
    }

    @Override
    public String toString() {
        return String.format("Местонахождение: (%.1f; %d; %d)", x, y, z);
    }

    @Override
    public String createCsv() {
        return CsvTools.createCsvLine(x.toString(), String.valueOf(y), z.toString());
    }
}
