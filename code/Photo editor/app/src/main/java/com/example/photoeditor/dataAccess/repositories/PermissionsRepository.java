package com.example.photoeditor.dataAccess.repositories;
import android.content.Context;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.photoeditor.bussinesLogic.controllers.PermissionsController;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.ParametersFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.PermissionsFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.RolesFields;
import com.example.photoeditor.dataAccess.models.pojos.PermissionsJoinModel;
import com.example.photoeditor.dataAccess.requests.PermissionsRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class PermissionsRepository {
    private Context context;
    ArrayList<PermissionsJoinModel> permissionsList = new ArrayList<>();

    public PermissionsRepository(Context context) {
        this.context = context;
    }

    public void getAllPermissions(final PermissionsController permissionsController) {
        Response.Listener<String> response= new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jarray = new JSONArray(response);
                    for (int i=0; i<jarray.length();i++){
                        JSONObject permissionsTemp= jarray.getJSONObject(i);
                        PermissionsJoinModel permissionsModel = new PermissionsJoinModel();
                        permissionsModel.setId(permissionsTemp.getInt(PermissionsFields.ID.getKey()));
                        permissionsModel.setroleType(permissionsTemp.getString(RolesFields.TYPE.getKey()));
                        permissionsModel.setparameterName(permissionsTemp.getString(ParametersFields.NAME.getKey()));
                        permissionsModel.setStatus(permissionsTemp.getInt(PermissionsFields.STATUS.getKey()));
                        permissionsList.add(permissionsModel);
                    }
                    permissionsController.retunOfPermissions(permissionsList);
                }catch (JSONException ex){
                    System.out.println("debug issue");
                    ex.getMessage();

                }
            }
        };
        PermissionsRequest r = new PermissionsRequest (PermissionsRequest.getPermissions(),response);
        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(r);
    }


    public void updatePermissions(int status, int id,final  PermissionsController permissionsController) {
        Response.Listener<String> response = new Response.Listener<String>(){
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean ok = jsonResponse.getBoolean("success");
                    permissionsController.returnUpdate(ok);
                }catch (JSONException ex){
                    System.out.println("debug problem");
                    ex.getMessage();

                }
            }
        };
        PermissionsRequest r = new PermissionsRequest(PermissionsRequest.updatePermissions(status,id),response);
        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(r);
    }
}
