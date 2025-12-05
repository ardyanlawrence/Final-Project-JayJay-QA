package org.ardyan.helper;

import java.io.File;
import java.util.Random;

public class Utilities {
    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/org/ardyan/JSONSchema/" + JSONFile);
    }

    public static String generateRandomEmail(String firstName, String lastName, String emailSpec) {
        if (emailSpec == null || emailSpec.isEmpty()) {
            return "";
        }
        return switch (emailSpec.toLowerCase()) {
            case "random" ->
                    firstName.toLowerCase() + "." + lastName.toLowerCase() + getRandomNumber() + "@testemail.com";
            case "blank", "empty", "invalid" -> "";
            default -> emailSpec;
        };
    }

    public static String getRandomNumber() {
        return String.valueOf(new Random().nextInt(1000));
    }
}
