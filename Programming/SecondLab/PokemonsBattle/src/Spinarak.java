import ru.ifmo.se.pokemon.*;

public class Spinarak extends Pokemon {
    public Spinarak(String name, int level) {
        super(name, level);
        setStats(40,60,40,40,40,30);
        setType(Type.BUG, Type.POISON);
        setMove(new CrossPoison(), new XScissor(), new ScaryFace());
    }
}