package com.example.photoeditor.dataAccess.repositories;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.UserFields;
import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.requests.UserRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserRepository {
    private Context context;
    ArrayList<UserModel> userList = new ArrayList<>();
    public UserRepository(Context context) {
        this.context = context;
    }
    public void insertUser(UserModel user, final UserController userController){
        final boolean[] success = {false};
        Response.Listener<String> response= new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean r=jsonResponse.getBoolean("success");
                    if(r){
                        userController.regSuccess(r);
                    }
                } catch (JSONException ex){
                    ex.getMessage();
                    System.out.println("debug problem");
                }
            }
        };
        UserRequest r = new UserRequest(UserRequest.insertUser(user), response);
        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(r);
    }
    public void getByUsernameAndPassword(UserModel loginUser, final UserController userController){
        Response.Listener<String> response = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("debug here" );
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean ok = jsonResponse.getBoolean("success");
                    System.out.println("debug" + ok);
                    System.out.println("debug" + jsonResponse.getString("info"));
                    if (ok){

                        UserModel user = new UserModel();
                        user.setId(jsonResponse.getInt(UserFields.ID.getKey()));
                        user.setUsername(jsonResponse.getString(UserFields.USERNAME.getKey()));
                        user.setName( jsonResponse.getString(UserFields.NAME.getKey()));
                        user.setPassword(jsonResponse.getString(UserFields.PASSWORD.getKey()));
                        userController.loginLogic(user);
                    } else {
                        userController.loginLogic(null);
                    }
                }catch (JSONException ex){
                    System.out.println("debug problem");

                    ex.getMessage();

                }
            }
        };


        UserRequest r = new UserRequest(
                UserRequest.selecByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword()),
                response);

        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(r);
    }
    public void getAllUsers(final UserController userController) {
        Response.Listener<String> response= new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONArray jarray = new JSONArray(response);
                    for (int i=0; i<jarray.length();i++){
                        JSONObject userTemp= jarray.getJSONObject(i);
                        UserModel user= new UserModel();
                        user.setId(userTemp.getInt(UserFields.ID.getKey()));
                        user.setUsername(userTemp.getString(UserFields.USERNAME.getKey()));
                        user.setName(userTemp.getString(UserFields.NAME.getKey()));
                        user.setPassword(userTemp.getString(UserFields.PASSWORD.getKey()));
                        user.setId_role(userTemp.getInt(UserFields.ID_ROL.getKey()));
                        userList.add(user);
                    }
                    userController.retunOfUsers(userList);
                }catch (JSONException ex){
                    System.out.println("debug issue");
                    ex.getMessage();

                }
            }
        };
        UserRequest r = new UserRequest(UserRequest.getUser(),response);
        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(r);
    }

    public void updateUser(int role, String username, final UserController userController) {
        Response.Listener<String> response = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                System.out.println(response+" ON UPDATE");
                try {
                    System.out.println("WORKS");
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean ok = jsonResponse.getBoolean("success");
                        userController.returnUpdate(ok);
                }catch (JSONException ex){
                    System.out.println("debug problem");
                    ex.getMessage();

                }
            }
        };
        UserRequest r = new UserRequest(
                UserRequest.updateUser(role,username),response);
        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(r);
    }
}
