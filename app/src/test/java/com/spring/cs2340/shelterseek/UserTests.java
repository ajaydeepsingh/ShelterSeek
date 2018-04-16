package com.spring.cs2340.shelterseek;

import com.spring.cs2340.shelterseek.model.Account;
import com.spring.cs2340.shelterseek.model.Model;
import com.spring.cs2340.shelterseek.model.Shelter;
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
    public Shelter s;
    /**
     * sets up method
     */
    @Before
    public void setUp() {
        s = new Shelter(null);
    }

    @Test
    public void testNoShelterKey() {
        assertNull(s.getUniqueKey());
    }

    @Test
    public void testNullSet() {
        s.setUniqueKey(null);
        assertNull(s.getUniqueKey());
    }

    @Test
    public void testValidSet() {
        s.setUniqueKey("a");
        assertTrue(s.getUniqueKey().equals("a"));
    }
}
