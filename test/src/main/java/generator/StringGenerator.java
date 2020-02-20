package generator;

import org.apache.commons.lang3.RandomStringUtils;

public class StringGenerator {

    public static String getRandomString(){
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
        int length = AB.length();
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        System.out.println(generatedString);
        return generatedString;
    }
}
