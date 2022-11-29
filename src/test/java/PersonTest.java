import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.AbstractMap;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class PersonTest {
    private PersonBuilder personBuilder;
    private Person person;

    @BeforeEach
    void setUp() {
        personBuilder = new PersonBuilder();
        person = personBuilder
                .name("Misha")
                .surname("Naumov")
                .age(11)
                .build();
    }

    @Test
    void hasAge() {
        Assertions.assertEquals(true, person.hasAge());
    }

    @Test
    void hasAddress() {
        Assertions.assertEquals(false, person.hasAddress());
    }

    @Test
    void happyBirthday() {
        OptionalInt expected = OptionalInt.of(12);
        person.happyBirthay();
        Assertions.assertEquals(expected, person.getAge());
    }

    @Test
    void getSurname() {
        Assertions.assertEquals("Naumov", person.getSurname());
    }

    @Test
    void getName() {
        Assertions.assertEquals("Misha", person.getName());
    }

    @Test
    void getAddress() {
        person.setAddress("Moscow");
        Assertions.assertEquals("Moscow", person.getAddress());
    }

    @Test
    void getAgeIsNull() {
        PersonBuilder personBuilder = new PersonBuilder();
        Person person1 = personBuilder
                .name("Kate")
                .surname("Naumov")
                .build();
        Assertions.assertEquals(OptionalInt.empty(), person1.getAge());
    }

    @Test
    void setAddress() {
        person.setAddress("Moscow");
        Assertions.assertEquals("Moscow", person.getAddress());
    }

    @Test
    void newChildBuilder() {
        Assertions.assertEquals("Naumov", person.newChildBuilder().surname);
    }
}