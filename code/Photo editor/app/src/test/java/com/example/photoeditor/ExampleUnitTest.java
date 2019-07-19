package com.example.photoeditor;

import com.example.photoeditor.presentation.activities.RegisterActivity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void checkEmail_isCorrect() {
        assertEquals(false, RegisterActivity.checkEmail("prueba"));
    }
    @Test
    public void checkEmail_isCorrect2() {
        assertEquals(true, RegisterActivity.checkEmail("prueba@hotmail.com"));
    }
    @Test
    public void password_isCorrect() {
        assertEquals(true, RegisterActivity.checkPassword("password"));
    }
    @Test
    public void password_isCorrect2() {
        assertEquals(false, RegisterActivity.checkPassword("pass"));
    }

}