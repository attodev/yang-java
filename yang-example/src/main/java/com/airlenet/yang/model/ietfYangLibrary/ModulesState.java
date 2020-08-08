/* 
 * @(#)ModulesState.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-yang-library", revision: "2016-06-21".
 */

package com.airlenet.yang.model.ietfYangLibrary;

import com.airlenet.yang.model.ietfYangLibrary.YanglibPrefix;
import com.airlenet.yang.model.ietfYangLibrary.modulesState.Module;
import com.tailf.jnc.Element;
import com.tailf.jnc.ElementChildrenIterator;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangString;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an element from 
 * the namespace urn:ietf:params:xml:ns:yang:ietf-yang-library
 * generated to "src/main/java/com.airlenet.yang.model/ietfYangLibrary/modules-state"
 * <p>
 * See line 205 in
 * src/main/yang/module/ietf/ietf-yang-library.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class ModulesState extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty ModulesState object.
     */
    public ModulesState() {
        super(YanglibPrefix.NAMESPACE, "modules-state");
        setDefaultPrefix();
        setPrefix(YanglibPrefix.PREFIX);
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public ModulesState clone() {
        return (ModulesState)cloneContent(new ModulesState());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public ModulesState cloneShallow() {
        return (ModulesState)cloneShallowContent(new ModulesState());
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
            "module-set-id",
            "module",
        };
    }

    /* Access methods for optional leaf child: "module-set-id". */

    /**
     * Gets the value for child leaf "module-set-id".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangString getModuleSetIdValue() throws JNCException {
        return (com.tailf.jnc.YangString)getValue("module-set-id");
    }

    /**
     * Sets the value for child leaf "module-set-id",
     * using instance of generated typedef class.
     * @param moduleSetIdValue The value to set.
     * @param moduleSetIdValue used during instantiation.
     */
    public void setModuleSetIdValue(com.tailf.jnc.YangString moduleSetIdValue)
            throws JNCException {
        setLeafValue(YanglibPrefix.NAMESPACE,
            "module-set-id",
            moduleSetIdValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "module-set-id",
     * using a String value.
     * @param moduleSetIdValue used during instantiation.
     */
    public void setModuleSetIdValue(String moduleSetIdValue)
            throws JNCException {
        setModuleSetIdValue(new com.tailf.jnc.YangString(moduleSetIdValue));
    }

    /**
     * Unsets the value for child leaf "module-set-id".
     */
    public void unsetModuleSetIdValue() throws JNCException {
        delete("module-set-id");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "module-set-id" leaf will not have a value.
     */
    public void addModuleSetId() throws JNCException {
        setLeafValue(YanglibPrefix.NAMESPACE,
            "module-set-id",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "module-set-id" with operation "replace".
     */
    public void markModuleSetIdReplace() throws JNCException {
        markLeafReplace("module-set-id");
    }

    /**
     * Marks the leaf "module-set-id" with operation "merge".
     */
    public void markModuleSetIdMerge() throws JNCException {
        markLeafMerge("module-set-id");
    }

    /**
     * Marks the leaf "module-set-id" with operation "create".
     */
    public void markModuleSetIdCreate() throws JNCException {
        markLeafCreate("module-set-id");
    }

    /**
     * Marks the leaf "module-set-id" with operation "delete".
     */
    public void markModuleSetIdDelete() throws JNCException {
        markLeafDelete("module-set-id");
    }

    /**
     * Marks the leaf "module-set-id" with operation "remove".
     */
    public void markModuleSetIdRemove() throws JNCException {
        markLeafRemove("module-set-id");
    }

    /* Access methods for list child: "module". */

    /**
     * Gets list entry "module", with specified keys.
     */
    public Module getModule() throws JNCException {
        String path = "module";
        return (Module)searchOne(path);
    }

    /**
     * Iterator method for the list "module".
     * @return An iterator for the list.
     */
    public ElementChildrenIterator moduleIterator() {
        return new ElementChildrenIterator(children, "module");
    }

    /**
     * List method for the list "module".
     * @return An List for the list.
     */
    public List<Module> getModuleList() {
        List<Module> list = new ArrayList<>();
        ElementChildrenIterator iterator = moduleIterator();
        if(iterator==null){
            return null;
        }
        while (iterator.hasNext()){
            Module next =(Module) iterator.next();
            list.add(next);
        }
        return list;
    }

    /**
     * Adds list entry "module", using an existing object.
     * @param module The object to add.
     * @return The added child.
     */
    public Module addModule(Module module) throws JNCException {
        insertChild(module, childrenNames());
        return module;
    }

    /**
     * Adds list entry "module".
     * This method is used for creating subtree filters.
     * @return The added child.
     */
    public Module addModule() throws JNCException {
        Module module = new Module();
        insertChild(module, childrenNames());
        return module;
    }

    /**
     * Deletes list entry "module", with specified keys.
     */
    public void deleteModule() throws JNCException {
        String path = "module";
        delete(path);
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