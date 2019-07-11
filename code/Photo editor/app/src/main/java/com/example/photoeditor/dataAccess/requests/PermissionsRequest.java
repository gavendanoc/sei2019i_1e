package com.example.photoeditor.dataAccess.requests;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

import static com.android.volley.Request.*;

public class PermissionsJoinRequest extends StringRequest {
    private static final String route = "https://aramonhred.000webhostapp.com/fotos/PermissionsManager.php";

    private Map<String, String > parameters;

    public PermissionsJoinRequest(Map<String, String > parameters, Response.Listener<String> listener){
        super(Method.POST, route, listener, null);
        this.parameters = parameters;
    }

    protected Map<String,String> getParams(){
        return parameters;
    }
}
