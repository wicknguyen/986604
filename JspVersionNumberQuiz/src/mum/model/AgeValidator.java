package mum.model;

public class AgeValidator {
    private String age;

    public AgeValidator(String age) {
        this.age = age;
    }

    public String validateAge() {
        try {
            int convertedAge = Integer.valueOf(age);
            if (convertedAge < 4 || convertedAge > 100) {
               return "Age must be between 4 and 100.";
            }
        } catch (NumberFormatException e) {
            return "Age is required and must be an integer.";
        }
        return null;
    }

}
