public class Person {
    private final String name;
    private final int age;
    private PersonRole profession;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Імʼя: " + name +
                ", Вік: " + age +
                ", Професія: " + profession;
    }
}
