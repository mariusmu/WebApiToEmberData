package no.registrermeg.EmberDataGenerator;

import java.io.FileNotFoundException;

/**
 * A small program to transform WebApiModels to Ember Data Models
 */
public class EmberDataGenerator {

    public static void main(String[] args) {
        if (args.length <= 0) {
            System.out.println("Not enough arguments. Syntax | java -jar thisprogram.jar inputFile [belongsToName] {belongsToType] ");
            return;
        }
        CSharpReader cSharpReader = new CSharpReader(args[0]);
        try {
            EmberDataModel dataModel = cSharpReader.generateStack();
            String outputDir = "EmberFromCs";
            BelongsTo belongsTo = null;
            if (args.length == 2) {
                System.out.println("You have just specified the belongsToName - Syntax | java -jar thisprogram.jar inputFile [belongsToName] {belongsToType] ");
            } else if(args.length == 3) {
                belongsTo = new BelongsTo(args[1], args[2]);
            }
            EmberDataModelWriter dataModelWriter = new EmberDataModelWriter(outputDir, dataModel);

            dataModelWriter.write(belongsTo);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }


}
