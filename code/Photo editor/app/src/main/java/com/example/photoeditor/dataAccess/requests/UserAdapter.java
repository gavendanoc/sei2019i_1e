package com.example.photoeditor.dataAccess.requests;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.photoeditor.R;
import com.example.photoeditor.dataAccess.models.UserModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolderGen> {

    ArrayList<UserModel> userList;

    public UserAdapter(ArrayList<UserModel> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolderGen onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tarjeta_temp, viewGroup, false);
        return new ViewHolderGen(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGen viewHolderGen, int i) {
        UserModel userModel= userList.get(i);
        viewHolderGen.usuario.setText(userModel.getName());
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
        public ViewHolderGen(@NonNull View itemView) {
            super(itemView);
            System.out.println("HERE MISTAKE");
            usuario= itemView.findViewById(R.id.userTextF);
        }
    }
}
