package com.example.photoeditor.dataAccess.requests;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.photoeditor.dataAccess.databaseEnums.TableFields.RequestFields;
import com.example.photoeditor.dataAccess.databaseEnums.TableFields.UserFields;
import com.example.photoeditor.dataAccess.databaseEnums.TableQueries.UserQueries;

import java.util.HashMap;
import java.util.Map;

public class UserRequest extends StringRequest {
    private static final String ruta = "https://aramonhred.000webhostapp.com/fotos/login.php";
    private Map<String, String > parameters;

    public UserRequest(Map<String, String> parameters, Response.Listener<String> listener, String type){
        super(Request.Method.POST, ruta, listener, null);
        this.parameters = parameters;
        this.parameters.put(RequestFields.TYPE.getKey(), type);
    }

    protected Map<String,String> getParams(){
        return parameters;
    }
}
