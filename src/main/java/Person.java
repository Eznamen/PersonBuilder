import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return (getAge().isPresent());
    }

    public boolean hasAddress() {
        return !(this.address == null);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public OptionalInt getAge() {
        if (age == 0) {
            return OptionalInt.empty();
        } else {
            return OptionalInt.of(age);
        }
    }

    public void setAddress( String address) {
        if (getAddress() == null) {
            this.address = address;
        }
    }

    public void happyBirthay() {
        if (hasAge()) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.surname = this.surname;
        personBuilder.address = this.address;
        personBuilder.age = this.age - 30;
        return personBuilder;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Person)) return false;
//        Person person = (Person) o;
//        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(address, person.address);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {

        return name + " " + surname + ", " + age + " y.o., address: " + address +". " ;

    }
}
