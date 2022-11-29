public class Main {

    public static void main(String[] args) {
        PersonBuilder personBuilder = new PersonBuilder();

        Person person = personBuilder
                .name("Kate")
                .surname("Naumov")
                .age(39)
                .build();
        System.out.println(person.toString());
        person.setAddress("Moscow");
        Person son = person.newChildBuilder()
                .name("Misha")
                .build();

        System.out.println("У " + person + " есть сын, " + son);

    }
}