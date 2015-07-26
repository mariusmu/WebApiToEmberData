package no.registrermeg.EmberDataGenerator;

import java.io.*;

/**
 * A class that writes the output files
 */
public class EmberDataModelWriter {
    private String outputFile;
    private EmberDataModel emberDataModel;

    public EmberDataModelWriter(String outputFile, EmberDataModel emberDataModel) {
        this.outputFile = outputFile;
        this.emberDataModel = emberDataModel;
    }

    /**
     * Write to output file
     */
    public void write(BelongsTo belongsTo) {
        try {
            File directory = new File(outputFile);
            if (!directory.exists()) directory.mkdirs();
            File output = new File(outputFile + "\\" + Formatter.toSnakeStyle(emberDataModel.getModelName()) + ".js");
            if (!output.exists()) output.createNewFile();

            FileWriter f = new FileWriter(output);
            f.write(EmberScheme.importHeader);
            f.write(EmberScheme.whiteSpace);
            f.write(EmberScheme.export);

            if(belongsTo != null) {
                f.write("    " + belongsTo.getName() + ":" + getBelongsTo(belongsTo.getType()) + "\n");
            }

            for (EmberDataModelObject obj : emberDataModel.getDataModelObject()) {
                if(obj.getHasMany() != null) {
                    f.write("    " + obj.getName() + ":" + getHasMany(obj.getHasMany()) + "\n");
                } else {
                    f.write("    " + obj.getName() + ":" + getDSAttr(obj.getType().getTypeName()) + "\n");
                }

            }
            f.write(EmberScheme.close);
            f.close();
            System.out.println("Output complete. Check Desktop or the other specified directory");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Helper to make the DS.attr
     *
     * @param type type of the value
     * @return DS.attr(type);
     */
    private String getDSAttr(String type) {
        return " DS.attr('" + type + "'),";
    }


    /**
     * Helper to make the DS.hasMany
     *
     * @param type type of the value
     * @return DS.hasMany(type);
     */
    private String getHasMany(String type) {
        return " DS.hasMany('" + type + "'),";
    }

    /**
     * Helper to make the DS.belongsTo
     *
     * @param type type of the value
     * @return DS.belongsTo(type);
     */
    private String getBelongsTo(String type) {
        return " DS.belongsTo('" + type + "'),";
    }
}
