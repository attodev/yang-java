/* 
 * @(#)Asset.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "tailf-webui", revision: "2013-03-07".
 */

package com.airlenet.yang.model.tailfWebui.webui.schematics.assets;

import com.airlenet.yang.model.tailfWebui.WebuiPrefix;
import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.Leaf;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangEnumeration;
import com.tailf.jnc.YangString;

/**
 * This class represents an element from 
 * the namespace http://tail-f.com/ns/webui
 * generated to "src/main/java/com.airlenet.yang.model/tailfWebui/webui/schematics/assets/asset"
 * <p>
 * See line 124 in
 * src/main/yang/module/tailf/tailf-webui.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Asset extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty Asset object.
     */
    public Asset() {
        super(WebuiPrefix.NAMESPACE, "asset");
    }

    /**
     * Constructor for an initialized Asset object,
     * 
     * @param nameValue Key argument of child.
     */
    public Asset(YangString nameValue) throws JNCException {
        super(WebuiPrefix.NAMESPACE, "asset");
        Leaf name = new Leaf(WebuiPrefix.NAMESPACE, "name");
        name.setValue(nameValue);
        insertChild(name, childrenNames());
    }

    /**
     * Constructor for an initialized Asset object,
     * with String keys.
     * @param nameValue Key argument of child.
     */
    public Asset(String nameValue) throws JNCException {
        super(WebuiPrefix.NAMESPACE, "asset");
        Leaf name = new Leaf(WebuiPrefix.NAMESPACE, "name");
        name.setValue(new com.tailf.jnc.YangString(nameValue));
        insertChild(name, childrenNames());
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Asset clone() {
        Asset copy;
        try {
            copy = new Asset(getNameValue().toString());
        } catch (JNCException e) {
            copy = null;
        }
        return (Asset)cloneContent(copy);
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Asset cloneShallow() {
        Asset copy;
        try {
            copy = new Asset(getNameValue().toString());
        } catch (JNCException e) {
            copy = null;
        }
        return (Asset)cloneShallowContent(copy);
    }

    /**
     * @return An array with the identifiers of any key children
     */
    public String[] keyNames() {
        return new String[] {
            "name",
        };
    }

    /**
     * @return An array with the identifiers of any children, in order.
     */
    public String[] childrenNames() {
        return new String[] {
            "name",
            "base-64-image",
            "type",
        };
    }

    /* Access methods for leaf child: "name". */

    /**
     * Gets the value for child leaf "name".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangString getNameValue() throws JNCException {
        return (com.tailf.jnc.YangString)getValue("name");
    }

    /**
     * Sets the value for child leaf "name",
     * using instance of generated typedef class.
     * @param nameValue The value to set.
     * @param nameValue used during instantiation.
     */
    public void setNameValue(com.tailf.jnc.YangString nameValue)
            throws JNCException {
        setLeafValue(WebuiPrefix.NAMESPACE,
            "name",
            nameValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "name",
     * using a String value.
     * @param nameValue used during instantiation.
     */
    public void setNameValue(String nameValue) throws JNCException {
        setNameValue(new com.tailf.jnc.YangString(nameValue));
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "name" leaf will not have a value.
     */
    public void addName() throws JNCException {
        setLeafValue(WebuiPrefix.NAMESPACE,
            "name",
            null,
            childrenNames());
    }

    /* Access methods for optional leaf child: "base-64-image". */

    /**
     * Gets the value for child leaf "base-64-image".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangString getBase64ImageValue() throws JNCException {
        return (com.tailf.jnc.YangString)getValue("base-64-image");
    }

    /**
     * Sets the value for child leaf "base-64-image",
     * using instance of generated typedef class.
     * @param base64ImageValue The value to set.
     * @param base64ImageValue used during instantiation.
     */
    public void setBase64ImageValue(com.tailf.jnc.YangString base64ImageValue)
            throws JNCException {
        setLeafValue(WebuiPrefix.NAMESPACE,
            "base-64-image",
            base64ImageValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "base-64-image",
     * using a String value.
     * @param base64ImageValue used during instantiation.
     */
    public void setBase64ImageValue(String base64ImageValue)
            throws JNCException {
        setBase64ImageValue(new com.tailf.jnc.YangString(base64ImageValue));
    }

    /**
     * Unsets the value for child leaf "base-64-image".
     */
    public void unsetBase64ImageValue() throws JNCException {
        delete("base-64-image");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "base-64-image" leaf will not have a value.
     */
    public void addBase64Image() throws JNCException {
        setLeafValue(WebuiPrefix.NAMESPACE,
            "base-64-image",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "base-64-image" with operation "replace".
     */
    public void markBase64ImageReplace() throws JNCException {
        markLeafReplace("base-64-image");
    }

    /**
     * Marks the leaf "base-64-image" with operation "merge".
     */
    public void markBase64ImageMerge() throws JNCException {
        markLeafMerge("base-64-image");
    }

    /**
     * Marks the leaf "base-64-image" with operation "create".
     */
    public void markBase64ImageCreate() throws JNCException {
        markLeafCreate("base-64-image");
    }

    /**
     * Marks the leaf "base-64-image" with operation "delete".
     */
    public void markBase64ImageDelete() throws JNCException {
        markLeafDelete("base-64-image");
    }

    /**
     * Marks the leaf "base-64-image" with operation "remove".
     */
    public void markBase64ImageRemove() throws JNCException {
        markLeafRemove("base-64-image");
    }

    /* Access methods for optional leaf child: "type". */

    /**
     * Gets the value for child leaf "type".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangEnumeration getTypeValue() throws JNCException {
        return (com.tailf.jnc.YangEnumeration)getValue("type");
    }

    /**
     * Sets the value for child leaf "type",
     * using instance of generated typedef class.
     * @param typeValue The value to set.
     * @param typeValue used during instantiation.
     */
    public void setTypeValue(com.tailf.jnc.YangEnumeration typeValue)
            throws JNCException {
        setLeafValue(WebuiPrefix.NAMESPACE,
            "type",
            typeValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "type",
     * using a String value.
     * @param typeValue used during instantiation.
     */
    public void setTypeValue(String typeValue) throws JNCException {
        setTypeValue(new com.tailf.jnc.YangEnumeration(typeValue, new String[] {
             "jpeg",
             "png",
             "gif",
        }));
    }

    /**
     * Unsets the value for child leaf "type".
     */
    public void unsetTypeValue() throws JNCException {
        delete("type");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "type" leaf will not have a value.
     */
    public void addType() throws JNCException {
        setLeafValue(WebuiPrefix.NAMESPACE,
            "type",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "type" with operation "replace".
     */
    public void markTypeReplace() throws JNCException {
        markLeafReplace("type");
    }

    /**
     * Marks the leaf "type" with operation "merge".
     */
    public void markTypeMerge() throws JNCException {
        markLeafMerge("type");
    }

    /**
     * Marks the leaf "type" with operation "create".
     */
    public void markTypeCreate() throws JNCException {
        markLeafCreate("type");
    }

    /**
     * Marks the leaf "type" with operation "delete".
     */
    public void markTypeDelete() throws JNCException {
        markLeafDelete("type");
    }

    /**
     * Marks the leaf "type" with operation "remove".
     */
    public void markTypeRemove() throws JNCException {
        markLeafRemove("type");
    }

    /**
     * Support method for addChild.
     * Adds a child to this object.
     * 
     * @param child The child to add
     */
    public void addChild(Element child) {
        super.addChild(child);
    }

}