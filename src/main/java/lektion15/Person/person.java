package lektion15.Person;

public abstract class person {
    String fach;

    public person(String fach) {
        this.fach = fach;
    }

    public abstract void gibTaetigkeitAus();
}
