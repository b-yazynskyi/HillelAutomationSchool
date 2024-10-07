public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("John", 30, "Інженер");
        Person person2 = new Person("Mary", 25, "Вчитель");
        Person person3 = new Person("Bob", 35, "Лікар");

        Person person4 = new Person("Alice", 28, "Архітектор");

        System.out.printf("Імʼя: %s , Вік: %d, Професія: %s %n", person1.getName(),
                person1.getAge(), person1.getProfession());
        System.out.printf("Імʼя: %s , Вік: %d, Професія: %s %n", person2.getName(),
                person2.getAge(), person2.getProfession());
        System.out.printf("Імʼя: %s , Вік: %d, Професія: %s %n", person3.getName(),
                person3.getAge(), person3.getProfession());
        System.out.printf("Імʼя: %s , Вік: %d, Професія: %s %n", person4.getName(),
                person4.getAge(), person4.getProfession());

        person4.setProfession("Дизайнер");

        System.out.println("(Після оновлення професії)");
        System.out.printf("Імʼя: %s , Вік: %d, Професія: %s %n", person4.getName(),
                person4.getAge(), person4.getProfession());
    }
}
