package com.example.photoeditor.bussinesLogic.controllers;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.photoeditor.dataAccess.models.ParameterModel;
import com.example.photoeditor.dataAccess.repositories.ParametersRepository;
import com.example.photoeditor.presentation.activities.OpenCameraActivity;

import java.util.ArrayList;
import java.util.Collections;

public class ParametersController {

    private Context context;


    public ParametersController(Context context) {
        this.context = context;
    }


    public void getValidFilters(int idRole){
        ParametersRepository parametersRepository = new ParametersRepository(context);
        parametersRepository.getValidFilters(idRole,this);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void returnFilters (ArrayList<ParameterModel> parameters){
        ArrayList<Integer> filterIds = new ArrayList<Integer>();
        for (ParameterModel parameter : parameters) {
            System.out.println("ID:: " + parameter.getId());
            filterIds.add(parameter.getId());
        }
        Collections.sort(filterIds);
        ((OpenCameraActivity) context).createFilters(filterIds);
    }
}
