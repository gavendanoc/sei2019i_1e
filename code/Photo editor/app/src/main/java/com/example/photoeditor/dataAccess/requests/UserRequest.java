package com.example.photoeditor.dataAccess.requests;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UserRequest extends StringRequest {
    private static final String ruta = "https://aramonhred.000webhostapp.com/fotos/login.php";
    private Map<String, String > parametros;
    public UserRequest(String username, String password, Response.Listener<String> listener, String type){
        super(Request.Method.POST, ruta, listener, null);
        parametros= new HashMap<>();
        parametros.put("username",username+"");
        parametros.put("password",password+"");
        parametros.put("type", type);
    }

    protected Map<String,String> getParams(){
        return parametros;
    }
}
