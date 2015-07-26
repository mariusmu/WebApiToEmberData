package no.registrermeg.EmberDataGenerator;

/**
 * An attribute used in an Ember Data model
 */
public class EmberDataModelObject {

    private Type type;
    private String name;
    private String belongsTo;
    public String hasMany;

    /**
     * Constructor for EmberDataModelObject
     * @param type type of the object
     * @param name name of the object
     */
    public EmberDataModelObject(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * Constructor for EmberDataModelObject
     * @param type type of the object
     * @param name name of the object
     * @param hasMany the name of the Ember Data Model it has many of
     */
    public EmberDataModelObject(Type type, String name, String hasMany) {
        this.type = type;
        this.name = name;
        this.hasMany = hasMany;
    }


    /**
     * Set what Ember Data Model's name it belongs to
     * @param belongsTo name of the Ember Data Model it belongs to
     */
    public void setBelongsTo(String belongsTo) {
        this.belongsTo = belongsTo;
    }

    /**
     * Set has many of (Ember Data Model)
     * @param hasMany hasMany
     */
    public void setHasMany(String hasMany) {
        this.hasMany = hasMany;
    }

    /**
     * Get which Ember Data Model it belongs to
     * @return the Ember Data Model it belongs to
     */
    public String getBelongsTo() {
        return belongsTo;
    }

    /**
     * Get what this model has many of (Ember Data Model)
     * @return the Ember Data Model it has many of
     */
    public String getHasMany() {
        return hasMany;
    }

    /**
     * Get the type
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * Get the name
     * @return the name
     */
    public String getName() {
        return name;
    }
}
