public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("John", 30, "Інженер");
        Person person2 = new Person("Mary", 25, "Вчитель");
        Person person3 = new Person("Bob", 35, "Лікар");

        Person person4 = new Person("Alice", 28, "Архітектор");

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);

        person4.setProfession("Дизайнер");

        System.out.println("(Після оновлення професії)");
        System.out.println(person4);


    }
}
