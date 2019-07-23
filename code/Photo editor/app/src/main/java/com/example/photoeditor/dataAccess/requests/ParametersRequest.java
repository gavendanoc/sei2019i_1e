package com.example.photoeditor.dataAccess.requests;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.photoeditor.dataAccess.databaseEnums.RequestFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableQueries.ParametersQueries;
import com.example.photoeditor.dataAccess.databaseEnums.tableQueries.PermissionsQueries;

import java.util.HashMap;
import java.util.Map;

public class ParametersRequest extends StringRequest  {

    private static final String route = "https://aramonhred.000webhostapp.com/fotos/parametersManager.php";

    private Map<String, String > parameters;

    public ParametersRequest (Map<String, String > parameters, Response.Listener<String> listener){
        super(Request.Method.POST, route, listener, null);
        this.parameters = parameters;
    }

    protected Map<String,String> getParams(){
        return parameters;
    }


    public static Map<String,String> getValidPermissions(int idRole){
        Object[] args = {idRole};
        String query= ParametersQueries.SelectRoleFilters.getFormat(args);
        System.out.println(query);
        String type = ParametersQueries.SelectRoleFilters.getType();

        Map<String, String > parameter = new HashMap<>();
        parameter.put(RequestFields.QUERY.getKey(), query);
        parameter.put(RequestFields.TYPE.getKey(), type);
        return parameter;
    }


}
