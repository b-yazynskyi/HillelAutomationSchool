public class Main {
    public static void main(String[] args) {

        try {
            Person person1 = new Man("John", 25, PersonRole.ENGINEER);
            Person person2 = new Woman("Mary", 25, PersonRole.TEACHER);
            Person person3 = new Man("Bob", 35, PersonRole.DOCTOR);
            Person person4 = new Woman("Alice", 28, PersonRole.ARCHITECT);

            person1.displayInformation();
            person2.displayInformation();
            person3.displayInformation();
            person4.displayInformation();

            person4.setProfession(PersonRole.DESIGNER);

            System.out.println("(Після оновлення професії)");

            person4.displayInformation();

            person1.displayInformation("Anton");
            person2.displayInformation("Julia", PersonRole.STUDENT);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }




    }
}
