import java.util.Objects;

public class Sound {
    public Sound(String name) {
        setName(name);
    }

    private String name;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void happened() { }

    @Override
    public String toString() {
        return "Sound{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sound sound = (Sound) o;
        return Objects.equals(name, sound.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
