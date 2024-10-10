public class Person {
    private final String name;
    private final int age;
    private PersonRole profession;

    public Person(String name, int age, PersonRole profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    @Override
    public String toString() {
        return "Імʼя: " + name +
                ", Вік: " + age +
                ", Професія: " + profession;
    }
}
