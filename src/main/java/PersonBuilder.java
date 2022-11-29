public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder age(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder address(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if ((name == null) || (surname == null)) {
            throw new IllegalStateException( "пустое имя");
        } else if (age> 121 || age < 0) {
            throw new IllegalArgumentException("странный возраст");
        }
        return new Person(name, surname, age, address);

    }
}
