package com.spring.cs2340.shelterseek;

import com.spring.cs2340.shelterseek.model.Account;
import com.spring.cs2340.shelterseek.model.Model;
import com.spring.cs2340.shelterseek.model.User;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    final Model instance = new Model();
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }




    // TESTS FOR MODEL addNewAccount Method, created by Justin Cozzone

    @Before
    public void setUp() {
        // nothing needed because Model initializes an arrayList
    }

    @Test
    public void testNull() {
        assertFalse(instance.addNewAccount(null));
    }

    @Test
    public void testNullString() {
        Account str = null;
        assertFalse(instance.addNewAccount(null));
    }

    @Test
    public void testValidAdd() {
        Account a = new User();
        assertTrue(instance.addNewAccount(a));
        assertTrue(instance.getAccounts().contains(a));
    }




}