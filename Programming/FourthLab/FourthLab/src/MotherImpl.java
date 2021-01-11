import java.util.Objects;

public class MotherImpl extends Human implements MotherAbilities {
    public MotherImpl(int form) {
        this.setName(form);
    }

    private String name;
    private int age;

    public void setName(int form) {
        if (form == 1) this.name = "Мама";
        else if (form == 2) this.name = "она";
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void cook(String where) {
        System.out.print(getName() + " хлопотала " + where);
    }

    @Override
    public void see(String what) {
        Forehead foreheadEricEricson = this.new Forehead("лбу");
        Forehead.Bump bumpEricEricson = foreheadEricEricson.new Bump(what);
        System.out.print("Увидев " + bumpEricEricson.getName());
    }

    @Override
    public void sad() {
        setName(2);
        System.out.print(getName() + Words.AS.getName() + "следовало ожидать, огорчилась");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MotherImpl mother = (MotherImpl) o;
        return Objects.equals(name, mother.name);
    }

    @Override
    public String toString() {
        return "MotherImpl{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
