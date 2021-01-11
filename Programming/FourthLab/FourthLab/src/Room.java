import java.util.Objects;

public class Room extends Place {
    public Room(String name, Human human) {
        setName(name, human);
    }

    private String name;

    public void setName(String name, Human human) {
        this.name = name + human.getName();
    }
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(name, room.name);
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
