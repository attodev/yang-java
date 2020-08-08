/* 
 * @(#)Snmp.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "tailf-confd-monitoring", revision: "2013-06-14".
 */

package com.airlenet.yang.model.tailfConfdMonitoring.confdState;

import com.airlenet.yang.model.tailfCommonMonitoring.TfcgPrefix;
import com.airlenet.yang.model.tailfConfdMonitoring.confdState.snmp.Listen;
import com.airlenet.yang.model.tailfConfdMonitoring.confdState.snmp.Version;
import com.tailf.jnc.Element;
import com.tailf.jnc.ElementLeafListValueIterator;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.NodeSet;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangString;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an element from 
 * the namespace http://tail-f.com/yang/confd-monitoring
 * generated to "src/main/java/com.airlenet.yang.model/tailfConfdMonitoring/confdState/snmp"
 * <p>
 * See line 462 in
 * src/main/yang/module/tailf/tailf-common-monitoring.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Snmp extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Field for child container "listen".
     */
    public Listen listen = null;
    public Listen getListen() {
        return this.listen;
    }

    /**
     * Field for child container "version".
     */
    public Version version = null;
    public Version getVersion() {
        return this.version;
    }

    /**
     * Constructor for an empty Snmp object.
     */
    public Snmp() {
        super(TfcgPrefix.NAMESPACE, "snmp");
        setDefaultPrefix();
        setPrefix(TfcgPrefix.PREFIX);
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Snmp clone() {
        return (Snmp)cloneContent(new Snmp());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Snmp cloneShallow() {
        return (Snmp)cloneShallowContent(new Snmp());
    }

    /**
     * @return An array with the identifiers of any key children
     */
    public String[] keyNames() {
        return null;
    }

    /**
     * @return An array with the identifiers of any children, in order.
     */
    public String[] childrenNames() {
        return new String[] {
            "listen",
            "mib",
            "version",
            "engine-id",
        };
    }

    /* Access methods for container child: "listen". */

    /**
     * Adds container entry "listen", using an existing object.
     * @param listen The object to add.
     * @return The added child.
     */
    public Listen addListen(Listen listen) throws JNCException {
        this.listen = listen;
        insertChild(listen, childrenNames());
        return listen;
    }

    /**
     * Adds container entry "listen".
     * This method is used for creating subtree filters.
     * @return The added child.
     */
    public Listen addListen() throws JNCException {
        Listen listen = new Listen();
        this.listen = listen;
        insertChild(listen, childrenNames());
        return listen;
    }

    /**
     * Deletes container entry "listen".
     * @return An array of the deleted element nodes.
     */
    public NodeSet deleteListen() throws JNCException {
        this.listen = null;
        String path = "listen";
        return delete(path);
    }

    /* Access methods for optional leaf-list child: "mib". */

    /**
     * Iterator method for the leaf-list "mib".
     * @return An iterator for the leaf-list.
     */
    public ElementLeafListValueIterator mibIterator() {
        return new ElementLeafListValueIterator(children, "mib");
    }

    /**
     * List method for the leaf-list "mib".
     * @return An List for the leaf-list.
     */
    public List<com.tailf.jnc.YangString> getMibList() {
        List<com.tailf.jnc.YangString> list = new ArrayList<>();
        ElementLeafListValueIterator iterator = mibIterator();
        if(iterator==null){
            return null;
        }
        while (iterator.hasNext()){
            com.tailf.jnc.YangString next =(com.tailf.jnc.YangString) iterator.next();
            list.add(next);
        }
        return list;
    }

    /**
     * Sets the value for child leaf-list "mib",
     * using instance of generated typedef class.
     * @param mibValue The value to set.
     * @param mibValue used during instantiation.
     */
    public void setMibValue(com.tailf.jnc.YangString mibValue)
            throws JNCException {
        setLeafListValue(TfcgPrefix.NAMESPACE,
            "mib",
            mibValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf-list "mib",
     * using a String value.
     * @param mibValue used during instantiation.
     */
    public void setMibValue(String mibValue) throws JNCException {
        setMibValue(new com.tailf.jnc.YangString(mibValue));
    }

    /**
     * Deletes leaf-list entry "mib".
     * @param mibValue Value to delete.
     */
    public void deleteMib(YangString mibValue) throws JNCException {
        String path = "mib[mibValue]";
        delete(path);
    }

    /**
     * Deletes leaf-list entry "mib".
     * The value is specified as a string.
     * @param mibValue Value to delete.
     */
    public void deleteMib(String mibValue) throws JNCException {
        String path = "mib[mibValue]";
        delete(path);
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "mib" leaf-list will not have a value.
     */
    public void addMib() throws JNCException {
        setLeafListValue(TfcgPrefix.NAMESPACE,
            "mib",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf-list "mib" with operation "replace".
     * @param mibValue The value to mark
     */
    public void markMibReplace(YangString mibValue) throws JNCException {
        markLeafReplace("mib[name='" + mibValue + "']");
    }

    /**
     * Marks the leaf-list "mib" with operation "merge".
     * @param mibValue The value to mark
     */
    public void markMibMerge(YangString mibValue) throws JNCException {
        markLeafMerge("mib[name='" + mibValue + "']");
    }

    /**
     * Marks the leaf-list "mib" with operation "create".
     * @param mibValue The value to mark
     */
    public void markMibCreate(YangString mibValue) throws JNCException {
        markLeafCreate("mib[name='" + mibValue + "']");
    }

    /**
     * Marks the leaf-list "mib" with operation "delete".
     * @param mibValue The value to mark
     */
    public void markMibDelete(YangString mibValue) throws JNCException {
        markLeafDelete("mib[name='" + mibValue + "']");
    }

    /**
     * Marks the leaf-list "mib" with operation "remove".
     * @param mibValue The value to mark
     */
    public void markMibRemove(YangString mibValue) throws JNCException {
        markLeafRemove("mib[name='" + mibValue + "']");
    }

    /* Access methods for container child: "version". */

    /**
     * Adds container entry "version", using an existing object.
     * @param version The object to add.
     * @return The added child.
     */
    public Version addVersion(Version version) throws JNCException {
        this.version = version;
        insertChild(version, childrenNames());
        return version;
    }

    /**
     * Adds container entry "version".
     * This method is used for creating subtree filters.
     * @return The added child.
     */
    public Version addVersion() throws JNCException {
        Version version = new Version();
        this.version = version;
        insertChild(version, childrenNames());
        return version;
    }

    /**
     * Deletes container entry "version".
     * @return An array of the deleted element nodes.
     */
    public NodeSet deleteVersion() throws JNCException {
        this.version = null;
        String path = "version";
        return delete(path);
    }

    /* Access methods for optional leaf child: "engine-id". */

    /**
     * Gets the value for child leaf "engine-id".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangString getEngineIdValue() throws JNCException {
        return (com.tailf.jnc.YangString)getValue("engine-id");
    }

    /**
     * Sets the value for child leaf "engine-id",
     * using instance of generated typedef class.
     * @param engineIdValue The value to set.
     * @param engineIdValue used during instantiation.
     */
    public void setEngineIdValue(com.tailf.jnc.YangString engineIdValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "engine-id",
            engineIdValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "engine-id",
     * using a String value.
     * @param engineIdValue used during instantiation.
     */
    public void setEngineIdValue(String engineIdValue) throws JNCException {
        setEngineIdValue(new com.tailf.jnc.YangString(engineIdValue));
    }

    /**
     * Unsets the value for child leaf "engine-id".
     */
    public void unsetEngineIdValue() throws JNCException {
        delete("engine-id");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "engine-id" leaf will not have a value.
     */
    public void addEngineId() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "engine-id",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "engine-id" with operation "replace".
     */
    public void markEngineIdReplace() throws JNCException {
        markLeafReplace("engine-id");
    }

    /**
     * Marks the leaf "engine-id" with operation "merge".
     */
    public void markEngineIdMerge() throws JNCException {
        markLeafMerge("engine-id");
    }

    /**
     * Marks the leaf "engine-id" with operation "create".
     */
    public void markEngineIdCreate() throws JNCException {
        markLeafCreate("engine-id");
    }

    /**
     * Marks the leaf "engine-id" with operation "delete".
     */
    public void markEngineIdDelete() throws JNCException {
        markLeafDelete("engine-id");
    }

    /**
     * Marks the leaf "engine-id" with operation "remove".
     */
    public void markEngineIdRemove() throws JNCException {
        markLeafRemove("engine-id");
    }

    /**
     * Support method for addChild.
     * Adds a child to this object.
     * 
     * @param child The child to add
     */
    public void addChild(Element child) {
        super.addChild(child);
        if (child instanceof Listen) listen = (Listen)child;
        else if (child instanceof Version) version = (Version)child;
    }

}