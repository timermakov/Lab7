import java.util.Objects;

public abstract class Human {
    private String Name;

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(Name, human.Name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "Name='" + Name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);
    }
}
