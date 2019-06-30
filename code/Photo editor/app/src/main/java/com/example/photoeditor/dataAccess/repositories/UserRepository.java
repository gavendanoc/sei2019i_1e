package com.example.photoeditor.dataAccess.repositories;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.requests.UserRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class UserRepository {
    private Context context;

    public UserRepository(Context context) {
        this.context = context;
    }

    public void getByUsernameAndPassword(UserModel loginUser, final UserController userController){
        Response.Listener<String> response = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean ok = jsonResponse.getBoolean("success");
                    if (ok){
                        UserModel user = new UserModel();
                        user.setId(jsonResponse.getInt("id"));
                        user.setUsername(jsonResponse.getString("username"));
                        user.setName( jsonResponse.getString("name"));
                        user.setPassword(jsonResponse.getString("password"));
                        userController.loginLogic(user);
                    } else {
                        userController.loginLogic(null);
                    }
                } catch (JSONException ex){
                    ex.getMessage();

                }
            }
        };

        UserRequest r = new UserRequest(loginUser.getUsername(),loginUser.getPassword(),response, "login");
        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(r);
    }

}
