package com.example.photoeditor.bussinesLogic.controllers;

import android.content.Context;

import com.example.photoeditor.dataAccess.models.ParameterModel;
import com.example.photoeditor.dataAccess.repositories.ParametersRepository;

import java.util.ArrayList;

public class ParametersController {

    private Context context;


    public ParametersController(Context context) {
        this.context = context;
    }


    public void getValidFilters(int idRole){
        ParametersRepository parametersRepository = new ParametersRepository(context);
        parametersRepository.getValidFilters(idRole,this);
    }

    public void returnFilters ( ArrayList<ParameterModel> parameters){
        ArrayList<Integer> filterIds = new ArrayList<Integer>();
        for (ParameterModel parameter : parameters) {
            System.out.println("ID:: " + parameter.getId());
            filterIds.add(parameter.getId());
        }
    }


}
