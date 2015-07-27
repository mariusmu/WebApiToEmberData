package no.mkmedia.EmberDataGenerator;

/**
 * The type of the attribute
 */
public class Type {
    private String typeName;
    private int typeId;
    private boolean nullable;

    public Type() {

    }

    /**
     * Constructor for the Ember Data Attribute Type
     *
     * @param typeName the name of the type
     * @param typeId   the id of the type
     */
    public Type(String typeName, int typeId) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    /**
     * Get the name of the type
     *
     * @return name of the type
     */
    public String getTypeName() {
        return typeName;
    }


    /**
     * Set the type name
     *
     * @param typeName the name of the type
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * Get the type id
     *
     * @return the type id
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * Set the type id
     *
     * @param typeId the type id
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }


}
