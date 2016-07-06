package com.kainos.training.jersey.client;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

public class LoginClient
{

    final String BASE_URL = "http://localhost:8080/";
    final String HOME_PATH = "home";
    final String LOGIN_PATH = "login";
    final String REGISTER_PATH = "register";
    final String CHANGE_PASSWORD_PATH = "changePassword";
    final String USERNAME_FORM_PARAM = "username";
    final String PASSWORD_FORM_PARAM = "password";
    final String NEW_PASSWORD_FORM_PARAM = "newPassword";
    final String REQUEST_ENCODING = "application/x-www-form-urlencoded";

    final int SUCCESS_RESPONSE = 204;

    Client client;
    WebTarget webTarget;
    WebTarget loginWebTarget;

    public LoginClient() {
        client = ClientBuilder.newClient();
        webTarget = client.target(BASE_URL);
        loginWebTarget = webTarget.path(HOME_PATH);
    }

	public Boolean getLogin(String username, String password){
		//Code goes here....
        loginWebTarget = webTarget.path(HOME_PATH + '/' +LOGIN_PATH);
        Form form = new Form();
        form.param(USERNAME_FORM_PARAM, username);
        form.param(PASSWORD_FORM_PARAM, password);

        Invocation.Builder builder = loginWebTarget.request();

        Response response = builder.post(Entity.entity(form, REQUEST_ENCODING));

        if(response.getStatus() == SUCCESS_RESPONSE) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean register(String username, String password) {
        loginWebTarget = webTarget.path(HOME_PATH + '/' + REGISTER_PATH);
        Form form = new Form();
        form.param(USERNAME_FORM_PARAM, username);
        form.param(PASSWORD_FORM_PARAM, password);

        Invocation.Builder builder = loginWebTarget.request();

        Response response = builder.post(Entity.entity(form, REQUEST_ENCODING));

        if(response.getStatus() == SUCCESS_RESPONSE) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean changePassword(String username, String password, String newPassword) {
        loginWebTarget = webTarget.path(HOME_PATH + '/' + CHANGE_PASSWORD_PATH);
        Form form = new Form();
        form.param(USERNAME_FORM_PARAM, username);
        form.param(PASSWORD_FORM_PARAM, password);
        form.param(NEW_PASSWORD_FORM_PARAM, newPassword);
        Invocation.Builder builder = loginWebTarget.request();

        Response response = builder.post(Entity.entity(form, REQUEST_ENCODING));

        if(response.getStatus() == SUCCESS_RESPONSE) {
            return true;
        } else {
            return false;
        }
    }
}
