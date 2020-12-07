import ru.ifmo.se.pokemon.*;

public class Giratina extends Pokemon {
    public Giratina(String name, int level) {
        super(name, level);
        setStats(150, 100, 120, 100, 120,90);
        setType(Type.GHOST, Type.DRAGON);
        setMove(new WillOWisp(), new Psychic(), new Rest(), new Swagger());
    }
}