package com.example.photoeditor.dataAccess.requests;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.photoeditor.dataAccess.databaseEnums.RequestFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.UserFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableQueries.UserQueries;
import com.example.photoeditor.dataAccess.models.UserModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserRequest extends StringRequest {
    private static final String route = "https://aramonhred.000webhostapp.com/fotos/userManager.php";

    private Map<String, String > parameters;

    public UserRequest(Map<String, String > parameters, Response.Listener<String> listener){
        super(Request.Method.POST, route, listener, null);
        this.parameters = parameters;
    }

    protected Map<String,String> getParams(){
        return parameters;
    }


    public static Map<String, String > selecByUsernameAndPassword(String username, String password){
        Object[] args = {username, password};
        String query = UserQueries.SelecByUsernameAndPassword.getFormat(args);
        String type = UserQueries.SelecByUsernameAndPassword.getType();

        Map<String, String > parameter = new HashMap<>();
        parameter.put(RequestFields.QUERY.getKey(), query);
        parameter.put(RequestFields.TYPE.getKey(), type);
        return parameter;
    }
    public static Map<String,String> insertUser(UserModel user){
        Object[] args = {user.getName(),user.getUsername(),user.getEmail(),user.getPassword()};
        String query= UserQueries.InsertUser.getFormat(args);
        String type= UserQueries.InsertUser.getType();

        Map<String, String > parameter = new HashMap<>();
        parameter.put(RequestFields.QUERY.getKey(), query);
        parameter.put(RequestFields.TYPE.getKey(), type);
        return parameter;
    }
    public static Map<String,String> getUser(){
        String query= UserQueries.GetUsers.getFormat(null);
        System.out.println(query);
        String type= UserQueries.GetUsers.getType();

        Map<String, String > parameter = new HashMap<>();
        parameter.put(RequestFields.QUERY.getKey(), query);
        parameter.put(RequestFields.TYPE.getKey(), type);
        return parameter;
    }
}
