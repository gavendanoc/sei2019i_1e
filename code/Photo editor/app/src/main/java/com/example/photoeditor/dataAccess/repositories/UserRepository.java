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
        //THIS METHOD DOESNT WORKSSSS
    public ArrayList<UserModel> getAllUsers() {
        final ArrayList<UserModel> userList = new ArrayList<>();
        Response.Listener<String> response= new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonresponse = new JSONObject(response);
                    //JSONArray jsonresponse = jsonObject.getJSONArray(response);
                    System.out.println("after Response");
                    for (int i=0; i<jsonresponse.length();i++){
                        System.out.println("works here 2");
                        UserModel user = new UserModel();
                        System.out.println("works here 3");
                        user.setId(jsonresponse.getInt(UserFields.ID.getKey()));
                        user.setUsername(jsonresponse.getString(UserFields.USERNAME.getKey()));
                        user.setName( jsonresponse.getString(UserFields.NAME.getKey()));
                        user.setPassword(jsonresponse.getString(UserFields.PASSWORD.getKey()));
                        System.out.println(user.getName());
                        System.out.println("works here 4");
                        userList.add(user);
                        System.out.println("works here 5");
                    }
                }catch (JSONException ex){
                    System.out.println("debug issue");
                    ex.getMessage();

                }
            }
        };
        UserRequest r = new UserRequest(UserRequest.getUser(),response);

        System.out.println(response);
        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(r);
        //System.out.println(userList.get(0).getName());
        return userList;
    }
}
