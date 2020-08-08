/* 
 * @(#)DottedQuad.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-yang-types", revision: "2013-07-15".
 */

package com.airlenet.yang.model.ietfYangTypes;

import com.tailf.jnc.YangException;
import com.tailf.jnc.YangString;

/**
 * This class represents an element from 
 * the namespace 
 * generated to "src/main/java/com.airlenet.yang.model/ietfYangTypes/dotted-quad"
 * <p>
 * See line 463 in
 * src/main/yang/module/ietf/ietf-yang-types.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class DottedQuad extends YangString {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for DottedQuad object from a string.
     * @param value Value to construct the DottedQuad from.
     */
    public DottedQuad(String value) throws YangException {
        super(value);
        check();
    }

    /**
     * Sets the value using a string value.
     * @param value The value to set.
     */
    public void setValue(String value) throws YangException {
        super.setValue(value);
        check();
    }

    /**
     * Checks all restrictions (if any).
     */
    public void check() throws YangException {
    }

}