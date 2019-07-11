package com.example.photoeditor.dataAccess.repositories;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.photoeditor.bussinesLogic.controllers.PermissionsController;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.databaseEnums.RequestFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.PermissionsFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.UserFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableQueries.PermissionsQueries;
import com.example.photoeditor.dataAccess.databaseEnums.tableQueries.UserQueries;
import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.models.pojos.PermissionsJoinModel;
import com.example.photoeditor.dataAccess.requests.PermissionsRequest;
import com.example.photoeditor.dataAccess.requests.UserRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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
                System.out.println(response);
                try {
                    JSONArray jarray = new JSONArray(response);
                    System.out.println("YES");
                    for (int i=0; i<jarray.length();i++){
                        JSONObject permissionsTemp= jarray.getJSONObject(i);

                        PermissionsJoinModel permissionsJoinModel = new PermissionsJoinModel();


                        permissionsJoinModel.setId(permissionsTemp.getInt(PermissionsFields.ID.getKey()));
                        permissionsJoinModel.setIdRol(permissionsTemp.getString(PermissionsFields.ID_ROL.getKey()));
                        permissionsJoinModel.setIdParameter(permissionsTemp.getString(PermissionsFields.ID_PARAMETER.getKey()));
                        permissionsJoinModel.setStatus(permissionsTemp.getInt(PermissionsFields.STATUS.getKey()));

                        permissionsList.add(permissionsJoinModel );
                    }
                    permissionsController.retunOfPermissions(permissionsList);
                }catch (JSONException ex){
                    System.out.println("debug issue");
                    ex.getMessage();

                }
            }
        };
        PermissionsRequest r = new PermissionsRequest (PermissionsRequest.getAllPermissions(),response);
        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(r);
    }



}
