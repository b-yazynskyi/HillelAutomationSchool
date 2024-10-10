public class Woman extends Person {
    public static final String GENDER = "жінка";

    public Woman(String name, int age, PersonRole profession) {
        super(name, age, profession);
    }

    public String getGender() {
        return GENDER;
    }
}
