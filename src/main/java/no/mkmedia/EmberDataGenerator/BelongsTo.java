package no.mkmedia.EmberDataGenerator;

/**
 * A small class to keep the belongsTo in order
 */
public class BelongsTo {
    private String name;
    private String type;

    /**
     * Constructor for BelongsTo
     * @param name name of the attribute (the name before colon)
     * @param type the type of the attribute (DS.belongsTo(type))
     */
    public BelongsTo(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Get the name of the attribute
     * @return the name of the attribute (before colon)
     */
    public String getName() {
        return name;
    }

    /**
     * Get the type of the attribute belongsTo
     * @return the type of the attribute belongsTo
     */
    public String getType() {
        return type;
    }
}
