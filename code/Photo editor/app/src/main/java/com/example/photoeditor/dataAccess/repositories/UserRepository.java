package com.example.photoeditor.dataAccess.repositories;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.databaseEnums.TableFields.UserFields;
import com.example.photoeditor.dataAccess.databaseEnums.TableQueries.UserQueries;
import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.requests.UserRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

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
                        user.setId(jsonResponse.getInt(UserFields.ID.getKey()));
                        user.setUsername(jsonResponse.getString(UserFields.USERNAME.getKey()));
                        user.setName( jsonResponse.getString(UserFields.NAME.getKey()));
                        user.setPassword(jsonResponse.getString(UserFields.PASSWORD.getKey()));
                        userController.loginLogic(user);
                    } else {
                        userController.loginLogic(null);
                    }
                } catch (JSONException ex){
                    ex.getMessage();

                }
            }
        };


        HashMap<String, String > parameters= new HashMap<>();
        parameters.put(UserFields.USERNAME.getKey(), loginUser.getUsername());
        parameters.put(UserFields.PASSWORD.getKey(), loginUser.getPassword());

        UserRequest r = new UserRequest(parameters,
                response,
                UserQueries.SelecByUsernameAndPassword.getQuery());


        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(r);
    }

}
