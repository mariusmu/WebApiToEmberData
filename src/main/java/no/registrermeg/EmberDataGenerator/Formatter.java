package no.registrermeg.EmberDataGenerator;

/**
 * SnakeStyleFormatter class
 * To generateSnakeStyle string
 */
public class Formatter {
    public static String toSnakeStyle(String from) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < from.length(); i++) {
            if (i == 0) {
                s.append(from.toLowerCase().charAt(i));
            } else {
                if (Character.isUpperCase(from.charAt(i))) {
                    s.append("_" + from.toLowerCase().charAt(i));
                } else {
                    s.append(from.charAt(i));
                }
            }
        }
        return s.toString();
    }
}
