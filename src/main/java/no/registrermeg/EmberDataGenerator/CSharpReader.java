package no.registrermeg.EmberDataGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * A class that reads CSharp code an generate a list of all the possible objects
 */
public class CSharpReader {

    private File file;
    private String fileName;

    /**
     * Constructor for the CSharpReader
     *
     * @param filePath the output file path
     */
    public CSharpReader(String filePath) {

        try {
            if (filePath.length() <= 0) throw new Exception("pathname of file is zero");
            File file = new File(filePath);
            if (!file.exists()) throw new FileNotFoundException();
            this.file = file;
        } catch (FileNotFoundException ex) {
            System.out.println("The file was not found: " + filePath);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Generates an Ember Model
     * Starts reading the CSharp-file
     * Then adds all the entries to an Ember Data Model
     *
     * @return EmberDataModel
     * @throws FileNotFoundException if the file is not found
     */
    public EmberDataModel generateStack() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(file);
        EmberDataModel dataModel = new EmberDataModel();
        while (fileScanner.hasNextLine()) {
            String read = fileScanner.nextLine();
            if (read.contains("class")) {
                dataModel.setModelName(parseName(read, "class"));
            } else if (read.contains("int?")) {
                dataModel.addModelObject(parseName(read, "int?"), "int?");
            } else if (read.contains("int")) {
                dataModel.addModelObject(parseName(read, "int"), "int");
            } else if (read.contains("bool")) {
                dataModel.addModelObject(parseName(read, "bool"), "boolean");
            } else if (read.contains("bool?")) {
                dataModel.addModelObject(parseName(read, "bool?"), "boolean");
            } else if (read.contains("string")) {
                dataModel.addModelObject(parseName(read, "string"), "string");
            } else if (read.contains("string?")) {
                dataModel.addModelObject(parseName(read, "string?"), "string");
            } else if(read.contains("List")) {
                String listName = parseListName(read, "List");
                String listType = parseListType(read);
                dataModel.addModelObject(listName, "list", listType);
            }
        }
        return dataModel;

    }

    /**
     * Parse by name tag
     *
     * @param line the raw input text string
     * @param checkAgainst string to check against
     * @return the parsed name
     */
    private String parseName(String line, String checkAgainst) {
        int index = line.indexOf(checkAgainst) + checkAgainst.length();
        int nextOccurance = getNextOccurance(line.substring(index));
        String className = line.substring(index + nextOccurance);
        return removeAtSpace(className);


    }

    /**
     * Delete all the text after the space
     *
     * @param line the raw input text string
     * @return the string that cointains only one word
     */
    private String removeAtSpace(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') return stringBuilder.toString();
            stringBuilder.append(charArray[i]);
        }
        return stringBuilder.toString();
    }

    /**
     * Get the next occurrence of a word
     *
     * @param line the raw text input string
     * @return the index in the text string of the next word
     */
    private int getNextOccurance(String line) {
        char[] charArray = line.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ' && charArray[i] != '?') return i;
        }
        return 0;
    }

    /**
     * Substring from start of space
     * @param line the raw input string
     * @return a substring text from start of space
     */
    private String removeBeforeSpace(String line) {
        char[] charArray = line.toCharArray();
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == ' ') return line.substring(i);
        }
        return null;
     }

    /**
     * Parse the list name
     * @param line the raw input text
     * @param checkAgainst line to start from and ignore
     * @return the name of the list (Ember Data Model attribute name)
     */
    private String parseListName(String line, String checkAgainst) {
        int index = line.indexOf(checkAgainst) + checkAgainst.length();
        String toNextSpace = removeBeforeSpace(line.substring(index));
        String className = parseName(toNextSpace, "");
        return className;
    }

    /**
     *
     * @param line the raw input line
     * @return the typename of the list
     */
    private String parseListType(String line) {
        char[] charArray = line.toCharArray();
        int startIndex = -1;
        int stopIndex = -1;
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == '<') startIndex = i;
            if(charArray[i] == '>') stopIndex = i;
        }
        String toReturn = line.substring(startIndex +1, stopIndex);
        return toReturn.toLowerCase();
    }
}
