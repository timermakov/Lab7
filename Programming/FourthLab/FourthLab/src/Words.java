public enum Words {

    THEN("Потом "),
    SO(" так и "),
    ASPOSSIBLE(" как можно более "),
    ALTHOUGH(", хотя "),
    ALREADY(" уже "),
    THATISWHY(", поэтому "),
    ANDRIGHT(" и, право, "),
    WHILE(", в то время, как "),
    IF("Если бы "),
    NOTSO(" не так "),
    WOULD(" бы "),
    THAT(", что "),
    ONEDAY("Однажды "),
    AS(", как и ");

    @Override
    public String toString() {
        return "Words{" +
                "name='" + name + '\'' +
                '}';
    }

    private final String name;

    Words(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
