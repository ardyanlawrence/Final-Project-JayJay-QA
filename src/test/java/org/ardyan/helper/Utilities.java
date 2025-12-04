package org.ardyan.helper;

import java.io.File;
import java.util.Random;

public class Utilities {
    public static File getJSONSchemaFile(String JSONFile) {
        return new File("src/test/java/org/ardyan/JSONSchema/" + JSONFile);
    }

    public static String generateRandomEmail(String firstName, String lastName) {
        return firstName.toLowerCase() + "." + lastName.toLowerCase() + getRandomNumber() + "@testemail.com";
    }

    public static String getRandomNumber() {
        return String.valueOf(new Random().nextInt(1000));
    }
}
