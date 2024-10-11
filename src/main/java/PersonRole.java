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
