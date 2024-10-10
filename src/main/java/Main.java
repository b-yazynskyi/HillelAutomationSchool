public class Main {
    public static void main(String[] args) {

        Person person1 = new Man("John", 25, Person.PersonRole.ENGINEER);
        Person person2 = new Woman("Mary", 25, Person.PersonRole.TEACHER);
        Person person3 = new Man("Bob", 35, Person.PersonRole.DOCTOR);
        Person person4 = new Woman("Alice", 28, Person.PersonRole.ARCHITECT);

        person1.displayInformation();
        person2.displayInformation();
        person3.displayInformation();
        person4.displayInformation();

        person4.setProfession(Person.PersonRole.DESIGNER);

        System.out.println("(Після оновлення професії)");

        person4.displayInformation();

    }
}
