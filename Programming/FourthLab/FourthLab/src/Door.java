import java.util.Objects;

public class Door {
    public Door(String name) {
        setName(name);
    }

    private String name;
    private boolean condition;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public String close() {
        return ("захлопнув " + getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Door door = (Door) o;
        return Objects.equals(name, door.name);
    }

    @Override
    public String toString() {
        return "Door{" +
                "name='" + name + '\'' +
                ", condition=" + condition +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public boolean isOpened() {
        if (condition) return true;
        else return false;
    }

    public class Handle {
        Door door = new Door("дверь");
        public void press(Door door) {
            if (door.isOpened()) {
                door.condition = false;
            }
            else door.condition = true;
        }
    }
}