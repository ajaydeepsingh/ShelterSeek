package com.spring.cs2340.shelterseek;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.spring.cs2340.shelterseek.model.*;

/**
 * @author Kevin Wong (kwong61)
 *
 */


public class kevinSetCapacity {
    private Shelter shelter;

    @Before
    public void setUp() throws Exception {
        shelter = new Shelter(null, null, null, null, 0, 0, null, null, null, null);
    }

    @Test
    public void testNull() {
        assertNull(shelter.getCapacity());
    }

    @Test
    public void testCapacity(){
        shelter.setCapacity("0");
        assertEquals(shelter.getCapacity(), "0");
        assertNotNull(shelter.getCapacity());
    }
    @Test
    public void testSetNull(){
        shelter.setCapacity(null);
        assertEquals(shelter.getCapacity(), null);
        assertNull(shelter.getCapacity());
    }

    @Test
    public void testChange() {
        shelter.setCapacity("50");
        shelter.setCapacity("60");
        assertEquals(shelter.getCapacity(), "60");
        assertNotNull(shelter.getCapacity());
    }

    @Test
    public void testChangetoNull() {
        shelter.setCapacity("50");
        shelter.setCapacity(null);
        assertEquals(shelter.getCapacity(), null);
        assertNull(shelter.getCapacity());
    }

    @Test
    public void testNegativeCapacity() {
        shelter.setCapacity("-1");
        assertEquals(shelter.getCapacity(), "0");
        assertNotNull(shelter.getCapacity());
    }
}