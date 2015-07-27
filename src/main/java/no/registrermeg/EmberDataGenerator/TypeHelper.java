package no.registrermeg.EmberDataGenerator;

/**
 * A helper class for the types
 */
public class TypeHelper {


    /**
     * A helper for determining the type
     *
     * @param type the raw string type
     * @return the type
     */
    public static Type determineType(String type) {


        if (type.equals("string")) return new Type("string", 2);
        if (type.equals("int")) return new Type("number", 1);
        if (type.equals("int?")) return new Type("number", 1);
        if (type.equals("boolean")) return new Type("boolean", 3);
        if (type.equals("boolean?")) return new Type("boolean", 3);
        if (type.equals("string?")) return new Type("string", 2);
        if (type.equals("string?")) return new Type("List", 3);
        if (type.equals("double")) return new Type("number", 3);
        if (type.equals("double?")) return new Type("number", 3);
        if (type.equals("float")) return new Type("number", 3);
        if (type.equals("float?")) return new Type("number", 3);
        if (type.equals("decimal")) return new Type("number", 3);
        if (type.equals("decimal?")) return new Type("number", 3);

        return null;
    }

}
