public abstract class Person implements Displayable {
    private final String name;
    private final int age;
    private PersonRole profession;

    public Person(String name, int age, PersonRole profession) {
        this.name = name;
        this.age = age;
        this.profession = profession;
    }

    public void setProfession(PersonRole profession) {
        this.profession = profession;
    }

    @Override
    public void displayInformation() {
        System.out.println("Імʼя: " + this.name +
                ", Вік: " + this.age +
                ", Професія: " + this.profession +
                ", Стать: " + getGender());
    }

    public void displayInformation(String name) {
        System.out.println("Імʼя: " + name +
                ", Вік: " + this.age +
                ", Професія: " + this.profession +
                ", Стать: " + getGender());
    }

    public void displayInformation(String name, PersonRole profession) {
        System.out.println("Імʼя: " + name +
                ", Вік: " + this.age +
                ", Професія: " + profession +
                ", Стать: " + getGender());
    }

    protected abstract String getGender();

    @Override
    public String toString() {
        return "Імʼя: " + name +
                ", Вік: " + age +
                ", Професія: " + profession;
    }
}
