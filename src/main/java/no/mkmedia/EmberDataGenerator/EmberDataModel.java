package no.mkmedia.EmberDataGenerator;

import java.util.ArrayList;

/**
 * Ember Data Model main class
 */
public class EmberDataModel {

    private String modelName;
    private ArrayList<EmberDataModelObject> dataModelObjects = new ArrayList<EmberDataModelObject>();

    public EmberDataModel() {

    }

    /**
     * Constructor for the Ember Data Model
     *
     * @param modelName the name of the data model
     */
    public EmberDataModel(String modelName) {
        this.modelName = modelName;
    }

    /**
     * Get the model name
     *
     * @return the model name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Set the model name
     *
     * @param modelName the model name
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * Add a model object to this Ember Data Model
     *
     * @param name the raw input type name
     * @param type the raw input type text
     */
    public void addModelObject(String name, String type) {
        if (name.equals("id")) return;
        EmberDataModelObject emberDataModelObject = new EmberDataModelObject(TypeHelper.determineType(type), name);
        this.dataModelObjects.add(emberDataModelObject);
    }

    /**
     * Add a model object to this Ember Data Model
     *
     * @param name the raw input type name
     * @param type the raw input type text
     */
    public void addModelObject(String name, String type, String belongsTo) {
        if (name.equals("id")) return;
        EmberDataModelObject emberDataModelObject = new EmberDataModelObject(TypeHelper.determineType(type), name, belongsTo);
        this.dataModelObjects.add(emberDataModelObject);
    }

    /**
     * Get the array list with Ember Data Model objects
     *
     * @return a list with all the data model objects
     */
    public ArrayList<EmberDataModelObject> getDataModelObject() {
        return dataModelObjects;
    }

    /**
     * Determine if the model object already exists
     *
     * @param modelObjectName the name of the object
     * @return true if already in list, false if not
     */
    private boolean hasModelObject(String modelObjectName) {
        for (EmberDataModelObject obj : dataModelObjects) {
            if (obj.getName().equals(modelObjectName)) return true;
        }
        return false;
    }

}
