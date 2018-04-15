package com.spring.cs2340.shelterseek;

import com.spring.cs2340.shelterseek.model.Account;
import com.spring.cs2340.shelterseek.model.Model;
import com.spring.cs2340.shelterseek.model.ShelterEmployee;
import com.spring.cs2340.shelterseek.model.User;
import org.junit.Test;
import org.junit.Before;


import android.os.Parcel;
import android.util.Pair;
import org.junit.runner.RunWith;
import java.lang.Exception;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author ajaydeep singh
 * @version M10
 *
 *
 */
public class UserTests {
    final Model modelInstance = new Model();
    /**
     * sets up method
     */
    @Before
    public void setUp() {
        // nothing needed because Model initializes an arrayList
    }
    @Test
    public void testValidShelterEmployeeAdd() {
        Account a = new ShelterEmployee("test", "testemployee", "password", "123456786", "randomshelterid");
        assertTrue(modelInstance.addNewAccount(a));
        assertTrue(modelInstance.getAccounts().contains(a));
        assertEquals(a.getUserName(),"testemployee");
        assertEquals(a.getName(),"test");
        assertFalse(a.isLockedOut());
        a.setPassword("newpassword");
        assertEquals(a.getPassword(),"newpassword");
    }

    @Test
    public void testNull() {
        assertFalse(modelInstance.addNewAccount(null));
    }

    @Test
    public void testNullString() {
        ShelterEmployee str = null;
        assertFalse(modelInstance.addNewAccount(str));
    }




}
