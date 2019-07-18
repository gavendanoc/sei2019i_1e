package com.example.photoeditor.presentation.activities.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.models.UserModel;


import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolderGen> {

    ArrayList<UserModel> userList;
    Context context;
    public UserAdapter(ArrayList<UserModel> userList, Context context) {
        this.userList = userList;
        this.context= context;

    }

    @NonNull
    @Override
    public ViewHolderGen onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_card_control_final, viewGroup, false);
        return new ViewHolderGen(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderGen viewHolderGen, int i) {
        final UserModel userModel = userList.get(i);
        viewHolderGen.usuario.setText(userModel.getName());
        if (userModel.getId_role() == 4) {
            viewHolderGen.payment.setChecked(true);
        }
        viewHolderGen.payment.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                userModel.setName(viewHolderGen.usuario.getText().toString());

                if (b) {
                    userModel.setId_role(4);
                } else {
                    userModel.setId_role(3);
                }

                userModel.setUsername(getByName(userModel.getName()));

                viewHolderGen.userController.updateUser(userModel.getId_role(), userModel.getUsername());
            }
        });
    }

    @Override
    public int getItemCount() {
        if(this.userList.isEmpty()){
            return 0;
        }
        return this.userList.size();
    }
    public String getByName(String name){
        for (int i=0; i<userList.size();i++){
            if(name.equals(userList.get(i).getName())){
                return userList.get(i).getUsername();
            }
        }
        return null;
    }
    public class ViewHolderGen extends RecyclerView.ViewHolder {
        TextView usuario;
        Switch payment;
        UserController userController;

        public ViewHolderGen(@NonNull View itemView) {
            super(itemView);
            payment= (Switch) itemView.findViewById(R.id.Payment);
            usuario= (TextView) itemView.findViewById(R.id.userTextF);
            userController= new UserController(context);
        }

    }
}
