package com.example.photoeditor.dataAccess.requests;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.photoeditor.R;
import com.example.photoeditor.bussinesLogic.controllers.UserController;
import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.presentation.activities.CardControlFinal;


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
    public void onBindViewHolder(@NonNull ViewHolderGen viewHolderGen, int i) {
        UserModel userModel= userList.get(i);
        viewHolderGen.usuario.setText(userModel.getName());
        if(userModel.getId_role()==4){
           viewHolderGen.payment.setChecked(true);
        }
    }

    @Override
    public int getItemCount() {
        if(this.userList.isEmpty()){
            return 0;
        }
        return this.userList.size();
    }

    public class ViewHolderGen extends RecyclerView.ViewHolder {
        TextView usuario;
        Switch payment;
        UserModel user;
        public ViewHolderGen(@NonNull View itemView) {
            super(itemView);
            payment= (Switch) itemView.findViewById(R.id.Payment);
            usuario= (TextView) itemView.findViewById(R.id.userTextF);
            user= new UserModel();
            user.setUsername(usuario.getText().toString());
            final UserController userController= new UserController(context);
            payment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("CLICKED");
                    if (payment.isEnabled()) {
                        user.setId_role(4);
                    } else {
                        user.setId_role(3);
                    }
                    userController.updateUser(user.getId_role(),user.getUsername());
                }
            });
        }

    }
}
