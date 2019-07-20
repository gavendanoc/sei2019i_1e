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

import java.security.Policy;
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
                System.out.println("Aca imprime response permissions");
                System.out.println(response);
                try {

                    JSONArray jarray = new JSONArray(response);

                    for (int i=0; i<jarray.length();i++){

                        JSONObject permissionsTemp= jarray.getJSONObject(i);
                        System.out.println("ACA MUERE");
                        PermissionsJoinModel permissionsModel = new PermissionsJoinModel();
                        System.out.println("ACA VIVE");

                        permissionsModel.setId(permissionsTemp.getInt(PermissionsFields.ID.getKey()));
                        System.out.println("ACA VIVE 2");
                      permissionsModel.setroleType(permissionsTemp.getString(RolesFields.TYPE.getKey()));
                        System.out.println("ACA VIVE 3"+permissionsModel.getroleType());
                        permissionsModel.setparameterName(permissionsTemp.getString(ParametersFields.NAME.getKey()));
                        System.out.println("ACA VIVE 4" +permissionsModel.getparameterName());
                        permissionsModel.setStatus(permissionsTemp.getInt(PermissionsFields.STATUS.getKey()));
                        System.out.println("ACA VIVE 5");

                        permissionsList.add(permissionsModel);

                        System.out.println(permissionsList);

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



}
