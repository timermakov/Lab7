import java.util.Objects;

public class Key {
    public Key(String name) {
        setName(name);
    }

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
        Key key = (Key) o;
        return Objects.equals(Name, key.Name);
    }

    @Override
    public String toString() {
        return "Key{" +
                "Name='" + Name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);
    }
}