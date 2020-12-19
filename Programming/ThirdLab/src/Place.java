import java.util.Objects;

public class Place {
    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }

    public String location (Room room){
        return (" в " + room.getName());
    }

    @Override
    public String toString() {
        return "Place{" +
                "Name='" + Name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Objects.equals(Name, place.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);
    }
}
