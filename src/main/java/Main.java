public class Main {
    public static void main(String[] args) {

        try {
            try {
                Person person1 = new Man(null,25, PersonRole.ENGINEER);
                person1.displayInformation();
                System.out.println("Display person1 object with new name:");
                person1.displayInformation("Anton");
            } catch (IllegalArgumentException | NullNameException e) {
                System.out.println(e.getMessage());
            }

            try {
                Person person2 = new Woman("Mary", 25, PersonRole.TEACHER);
                person2.displayInformation();
                System.out.println("Display person2 object with new name:");
                person2.displayInformation("Julia", PersonRole.STUDENT);
            } catch (IllegalArgumentException | NullNameException e) {
                System.out.println(e.getMessage());
            }

            try {
                Person person3 = new Man("Bob", 35, PersonRole.DOCTOR);
                person3.displayInformation();
            } catch (IllegalArgumentException | NullNameException e) {
                System.out.println(e.getMessage());
            }

            try {
                Person person4 = new Woman("Alice", 28, PersonRole.ARCHITECT);
                person4.displayInformation();

                person4.setProfession(PersonRole.DESIGNER);

                System.out.println("(Після оновлення професії)");

                person4.displayInformation();
            } catch (IllegalArgumentException | NullNameException e) {
                System.out.println(e.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




    }
}
