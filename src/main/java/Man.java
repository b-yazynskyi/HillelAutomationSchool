public class Man extends Person {
    public static final String GENDER = "чоловік";

    public Man(String name, int age, PersonRole profession) {
        super(name, age, profession);
    }

    public String getGender() {
        return GENDER;
    }
}
