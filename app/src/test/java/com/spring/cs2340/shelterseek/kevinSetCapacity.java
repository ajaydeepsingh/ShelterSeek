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
        System.out.println("Expected: null");
        assertNull(shelter.getCapacity());
        System.out.println("Actual: " + shelter.getCapacity());

    }

    @Test
    public void testSetNull(){
        shelter.setCapacity(null);
        System.out.println("Expected: null");
        assertEquals(shelter.getCapacity(), null);
        assertNull(shelter.getCapacity());
        System.out.println("Actual: " + shelter.getCapacity());
    }

    @Test
    public void testSetCapacity() {
        shelter.setCapacity("0");
        assertEquals(shelter.getCapacity(), "0");
        assertNotNull(shelter.getCapacity());
        System.out.println("Expected: 0");
        System.out.println("Actual: " + shelter.getCapacity());
    }

    @Test
    public void testNegativeCapacity() {
        shelter.setCapacity("-1");
        assertEquals(shelter.getCapacity(), "0");
        assertNotNull(shelter.getCapacity());
        System.out.println("Expected: 0");
        System.out.println("Actual: " + shelter.getCapacity());
    }

    @Test
    public void testChange() {
        shelter.setCapacity("50");
        shelter.setCapacity("60");
        assertEquals(shelter.getCapacity(), "60");
        assertNotNull(shelter.getCapacity());
        System.out.println("Expected: 60");
        System.out.println("Actual: " + shelter.getCapacity());
    }

    @Test
    public void testChangeNull() {
        shelter.setCapacity("50");
        shelter.setCapacity(null);
        assertEquals(shelter.getCapacity(), null);
        assertNull(shelter.getCapacity());
        System.out.println("Expected: null");
        System.out.println("Actual: " + shelter.getCapacity());
    }
}