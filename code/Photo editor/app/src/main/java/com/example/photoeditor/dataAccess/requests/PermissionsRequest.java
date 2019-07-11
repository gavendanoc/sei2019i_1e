package com.example.photoeditor.dataAccess.requests;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.photoeditor.dataAccess.databaseEnums.RequestFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableQueries.PermissionsQueries;
import com.example.photoeditor.dataAccess.databaseEnums.tableQueries.UserQueries;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.Request.*;

public class PermissionsRequest extends StringRequest {
    private static final String route = "https://aramonhred.000webhostapp.com/fotos/PermissionsManager.php";

    private Map<String, String > parameters;

    public PermissionsRequest(Map<String, String > parameters, Response.Listener<String> listener){
        super(Method.POST, route, listener, null);
        this.parameters = parameters;
    }

    protected Map<String,String> getParams(){
        return parameters;
    }


    public static Map<String,String> getAllPermissions(){
        String query= PermissionsQueries.SelectAllPermissions.getFormat(null);
        System.out.println(query);
        String type= PermissionsQueries.SelectAllPermissions.getType();

        Map<String, String > parameter = new HashMap<>();
        parameter.put(RequestFields.QUERY.getKey(), query);
        parameter.put(RequestFields.TYPE.getKey(), type);
        return parameter;
    }
}
