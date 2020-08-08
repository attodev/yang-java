/* 
 * @(#)AccessOperationsType.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-netconf-acm", revision: "2012-02-22".
 */

package com.airlenet.yang.model.ietfNetconfAcm;

import com.tailf.jnc.YangBits;
import com.tailf.jnc.YangException;

import java.math.BigInteger;

/**
 * This class represents an element from 
 * the namespace 
 * generated to "src/main/java/com.airlenet.yang.model/ietfNetconfAcm/access-operations-type"
 * <p>
 * See line 111 in
 * src/main/yang/module/ietf/ietf-netconf-acm.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class AccessOperationsType extends YangBits {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for AccessOperationsType object from a string.
     * @param value Value to construct the AccessOperationsType from.
     */
    public AccessOperationsType(String value) throws YangException {
        super(value,
            new java.math.BigInteger("31"),
            new String[] {"create", "read", "update", "delete", "exec", },
            new int[] {0, 1, 2, 3, 4, }
        );
        check();
    }

    /**
     * Constructor for AccessOperationsType object from a java.math.BigInteger.
     * @param value Value to construct the AccessOperationsType from.
     */
    public AccessOperationsType(BigInteger value) throws YangException {
        super(value,
            new java.math.BigInteger("31"),
            new String[] {"create", "read", "update", "delete", "exec", },
            new int[] {0, 1, 2, 3, 4, }
        );
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
     * Sets the value using a value of type java.math.BigInteger.
     * @param value The value to set.
     */
    public void setValue(BigInteger value) throws YangException {
        super.setValue(value);
        check();
    }

    /**
     * Checks all restrictions (if any).
     */
    public void check() throws YangException {
        super.check();
    }

}