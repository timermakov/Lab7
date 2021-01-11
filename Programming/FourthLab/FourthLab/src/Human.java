import java.util.Objects;
import exceptions.NameLengthRuntimeException;
import exceptions.NegativeAgeRuntimeException;

public abstract class Human {
    private String name;
    private int age;

    public void setName(String name) throws NameLengthRuntimeException {
        if (name.length() == 0)
            throw new NameLengthRuntimeException("Имя отсутствует", name);
        else this.name = name;
    }

    public void setAge(int age) throws NegativeAgeRuntimeException {
        if (age < 0)
            throw new NegativeAgeRuntimeException("Возраст не может быть отрицательным", age);
        else this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(name, human.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Human{" +
                "Name='" + name + '\'' +
                ", Age=" + age +
                '}';
    }

    public class Legs {
        private String name;
        private Human human;
        private EricEricsonImpl ericEricson;
        private CarlssonImpl carlsson;

        public Legs(String name, Human human) {
            this.name = name;
            this.human = human;
            ericEricson = new EricEricsonImpl("его ");
            carlsson = new CarlssonImpl(" Карлсона");
            this.setName(name, human);
        }

        public void setName(String name, Human human) {
            if (human.equals(ericEricson)) {
                this.name = ericEricson.getName() + name;
            }
            else if (human.equals(carlsson)) {
                this.name = name + carlsson.getName();
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
                    ", EricEricson=" + ericEricson +
                    ", Carlsson=" + carlsson +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Legs legs = (Legs) o;
            return Objects.equals(name, legs.name) &&
                    Objects.equals(human, legs.human) &&
                    Objects.equals(ericEricson, legs.ericEricson) &&
                    Objects.equals(carlsson, legs.carlsson);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, human, ericEricson, carlsson);
        }
    }

    public class Nose {
        private String name;
        private Human human;
        BetanEricsonImpl noseBetanEricson;

        public Nose(String name, Human human) {
            this.name = name;
            this.human = human;
            noseBetanEricson = new BetanEricsonImpl(1);
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

    public class Forehead {
        private String Name;
        public Forehead(String name) {
            this.setName(name);
        }

        public void setName(String name) {
            this.Name = name;
        }

        public String getName() {
            return this.Name;
        }

        public class Bump {
            private String Name;

            public Bump(String name) {
                this.setName(name);
            }

            public void setName(String name) {
                this.Name = name;
            }

            public String getName() {
                return this.Name;
            }
        }
    }
}
