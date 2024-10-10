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
        System.out.println("Імʼя: " + name +
                ", Вік: " + age +
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

    public enum PersonRole {
        STUDENT("Студент"),
        TEACHER("Вчитель"),
        DOCTOR("Лікар"),
        ENGINEER("Інженер"),
        ARTIST("Артист"),
        DESIGNER("Дизайнер"),
        ARCHITECT("Архітектор"),
        OTHER("Інший");

        private final String name;

        PersonRole(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
