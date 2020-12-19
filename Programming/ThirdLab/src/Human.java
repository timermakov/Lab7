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

    public class Legs {
        private String name;
        private Human human;
        private EricEricsonImpl EricEricson;
        private CarlssonImpl Carlsson;

        public Legs(String name, Human human) {
            this.name = name;
            this.human = human;
            EricEricson = new EricEricsonImpl("его ");
            Carlsson = new CarlssonImpl(" Карлсона");
            this.setName(name, human);
        }

        public void setName(String name, Human human) {
            if (human.equals(EricEricson)) {
                this.name = EricEricson.getName() + name;
            }
            else if (human.equals(Carlsson)) {
                this.name = name + Carlsson.getName();
            }
        }
        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return "Legs{" +
                    "name='" + name + '\'' +
                    ", human=" + human +
                    ", EricEricson=" + EricEricson +
                    ", Carlsson=" + Carlsson +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Legs legs = (Legs) o;
            return Objects.equals(name, legs.name) &&
                    Objects.equals(human, legs.human) &&
                    Objects.equals(EricEricson, legs.EricEricson) &&
                    Objects.equals(Carlsson, legs.Carlsson);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, human, EricEricson, Carlsson);
        }
    }

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
            this.name = name + noseBetanEricson.getName();
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

}
