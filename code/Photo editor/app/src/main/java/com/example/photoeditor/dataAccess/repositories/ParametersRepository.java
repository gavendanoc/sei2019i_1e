package com.example.photoeditor.dataAccess.repositories;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.photoeditor.bussinesLogic.controllers.ParametersController;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.ParametersFields;
import com.example.photoeditor.dataAccess.databaseEnums.tableFields.PermissionsFields;
import com.example.photoeditor.dataAccess.models.ParameterModel;
import com.example.photoeditor.dataAccess.models.pojos.PermissionsJoinModel;
import com.example.photoeditor.dataAccess.requests.ParametersRequest;
import com.example.photoeditor.dataAccess.requests.PermissionsRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParametersRepository {

    private Context context;

    public ParametersRepository (Context context) {
        this.context = context;
    }

    public void getValidFilters(int idRole, final ParametersController parametersController){
        Response.Listener<String> response= new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONArray jarray = new JSONArray(response);
                    ArrayList<ParameterModel> parameters = new ArrayList<>();

                    for (int i=0; i<jarray.length();i++){
                        JSONObject filtersTemp= jarray.getJSONObject(i);

                        ParameterModel parameterModel =  new ParameterModel();
                        parameterModel.setId(filtersTemp.getInt(ParametersFields.ID.getKey()));
                        parameterModel.setName(filtersTemp.getString(ParametersFields.NAME.getKey()));

                        parameters.add(parameterModel);
                    }
                    parametersController.returnFilters(parameters );
                }catch (JSONException ex){
                    System.out.println("debug issue");
                    ex.getMessage();

                }
            }
        };
        ParametersRequest  r = new ParametersRequest (ParametersRequest.getValidPermissions(idRole),response);
        RequestQueue cola = Volley.newRequestQueue(context);
        cola.add(r);
    }
}
