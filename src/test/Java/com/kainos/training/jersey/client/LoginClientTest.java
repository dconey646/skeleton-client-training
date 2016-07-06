package com.kainos.training.jersey.client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by thomasf on 04/07/2016.
 */
public class LoginClientTest {

    LoginClient loginClient;

    @Before
    public void setup() {
        loginClient = mock(LoginClient.class);
        loginClient.getLogin("admin", "password");
    }

    @Test
    public void loginSuccessfulTest() {
        when(loginClient.getLogin("admin","password")).thenReturn(true);
        Assert.assertTrue(loginClient.getLogin("admin", "password"));
    }

    @Test
    public void incorrectUsernameAndPasswordTest() {
        Assert.assertFalse(loginClient.getLogin("admin1", "password1"));
    }

    @Test
    public void registrationSuccessfulTest() {
        when(loginClient.register("Thomas", "password")).thenReturn(true);
        Assert.assertTrue(loginClient.register("Thomas", "password"));
    }

    @Test
    public void caseSensitiveUsernameTryingToRegister() {
        Assert.assertFalse(loginClient.register("Admin", "passwo"));
    }

    @Test
    public void registrationFailedAsUserExistsTest() {
        Assert.assertFalse(loginClient.register("admin", "password1"));
    }

    @Test
    public void nullUsernameDuringRegistrationTest() {
        Assert.assertFalse(loginClient.register("", "password"));
    }

    @Test
    public void nullPasswordDuringRegistrationTest(){
        Assert.assertFalse(loginClient.register("Thomas", ""));
    }

    @Test
    public void successfullyChangePasswordTest() {
        when(loginClient.changePassword("admin", "password", "pass1")).thenReturn(true);
        Assert.assertTrue(loginClient.changePassword("admin", "password", "pass1"));
    }

    @Test
    public void incorrectDetailsChangePasswordTest() {
        Assert.assertFalse(loginClient.changePassword("adm", "password", "pass1"));
    }

}
