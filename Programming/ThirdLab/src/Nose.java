import java.util.Objects;

public class Nose {
    private String name;
    private Human human;
    BetanEricsonImpl noseBetanEricson;

    public Nose(String name, Human human) {
        this.name = name;
        this.human = human;
        noseBetanEricson = new BetanEricsonImpl("Бетан");
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name + noseBetanEricson;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nose nose = (Nose) o;
        return Objects.equals(name, nose.name) &&
                Objects.equals(human, nose.human) &&
                Objects.equals(noseBetanEricson, nose.noseBetanEricson);
    }

    @Override
    public String toString() {
        return "Nose{" +
                "name='" + name + '\'' +
                ", human=" + human +
                ", noseBetanEricson=" + noseBetanEricson +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, human, noseBetanEricson);
    }
}