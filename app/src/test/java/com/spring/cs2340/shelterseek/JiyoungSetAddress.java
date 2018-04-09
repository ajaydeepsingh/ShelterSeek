package com.spring.cs2340.shelterseek;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.spring.cs2340.shelterseek.model.*;

/**
 * Created by saman on 4/4/2018.
 */

public class JiyoungSetAddress {
    private Shelter shelter;

    @Before
    public void setUp() throws Exception {
        shelter = new Shelter(null, null, null, null, 0, 0, null, null, null, null);
    }

    @Test
    public void testAddressNull() {
        assertNull(shelter.getAddress());
    }

    @Test
    public void testAddressFilled(){
        shelter.setAddress("921 Howell Mill Road");
        assertEquals(shelter.getAddress(), "921 Howell Mill Road");
        assertNotNull(shelter.getAddress());
    }
    @Test
    public void testSetNull(){
        shelter.setAddress(null);
        assertEquals(shelter.getAddress(), null);
        assertNull(shelter.getAddress());
    }

    @Test
    public void testAddressChangeToDiffAddress() {
        shelter.setAddress("921 Howell Mill Road");
        shelter.setAddress("655 Ethel Street");
        assertEquals(shelter.getAddress(), "655 Ethel Street");
        assertNotNull(shelter.getAddress());
    }

    @Test
    public void testAddressChangetoNull() {
        shelter.setAddress("921 Howell Mill Road");
        shelter.setAddress(null);
        assertEquals(shelter.getAddress(), null);
        assertNull(shelter.getAddress());
    }
}
