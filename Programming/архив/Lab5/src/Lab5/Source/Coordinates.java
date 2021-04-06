package Lab5.Source;

import Lab5.FileInteraction.XmlTools;
import Lab5.FileInteraction.Xml_Interchangeable;

public class Coordinates implements Xml_Interchangeable{

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
        return String.format("Координаты:(%d; %f)", x, y);
    }

    @Override
    public String createXml() {
        return XmlTools.createXmlLine("Coordinates",
                "\n" + XmlTools.createXmlLine("x", String.valueOf(x)) +
                        XmlTools.createXmlLine("y", String.valueOf(y)));
    }

}

