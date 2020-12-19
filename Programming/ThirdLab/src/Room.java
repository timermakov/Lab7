import java.util.Objects;

public class Room extends Place {
    public Room(String name, Human human) {
        setName(name, human);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(Name, room.Name);
    }

    @Override
    public String toString() {
        return "Room{" +
                "Name='" + Name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);
    }

    private String Name;

    public void setName(String name, Human human) {
        this.Name = name + human.getName();
    }
    public String getName() {
        return this.Name;
    }
}
