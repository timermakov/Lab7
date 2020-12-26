import java.util.Objects;

public class Door {
    public Door(String name) {
        setName(name);
    }

    private String Name;
    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return this.Name;
    }
    public String close() {
        return ("захлопнув " + getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Door door = (Door) o;
        return Objects.equals(Name, door.Name);
    }

    @Override
    public String toString() {
        return "Door{" +
                "Name='" + Name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name);
    }

    public static class Key {
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
            return "Door.Key{" +
                    "Name='" + Name + '\'' +
                    '}';
        }

        @Override
        public int hashCode() {
            return Objects.hash(Name);
        }
    }
}