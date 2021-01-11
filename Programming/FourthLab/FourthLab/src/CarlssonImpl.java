import java.util.Objects;

public class CarlssonImpl extends Human implements CarlssonAbilities {
    private String name;
    private int age;

    public CarlssonImpl(String name) {
        setName(name);
    }

    @Override
    public void fallDown(String how) {
        System.out.print(getName() + " свалился " + how);
    }

    @Override
    public void turn(String how, Key key) {
        System.out.print( getName() + how + "повернул " + key.getName());
    }

    @Override
    public void laugh(String how) {
        System.out.print(how + " засмеялся");
    }

    @Override
    public void bet() {
        System.out.println("КАРЛСОН ДЕРЖИТ ПАРИ");
    }

    @Override
    public String toString() {
        return "CarlssonImpl{}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CarlssonImpl carlsson = (CarlssonImpl) o;
        return age == carlsson.age &&
                Objects.equals(name, carlsson.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, age);
    }
}
