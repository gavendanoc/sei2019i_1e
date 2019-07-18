package com.example.photoeditor.presentation.activities.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.photoeditor.R;
import com.example.photoeditor.dataAccess.models.pojos.PermissionsJoinModel;

import java.util.ArrayList;

public class PermissionsAdapter extends RecyclerView.Adapter<PermissionsAdapter.ViewHolderGen> {

    ArrayList<PermissionsJoinModel> permissionsList;

    public PermissionsAdapter(ArrayList<PermissionsJoinModel> permissionsList) {
        this.permissionsList = permissionsList;
    }

    @NonNull
    @Override
    public PermissionsAdapter.ViewHolderGen onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.tarjeta_temp_permissions, viewGroup, false);
        return new PermissionsAdapter.ViewHolderGen(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PermissionsAdapter.ViewHolderGen viewHolderGen, int i) {
        PermissionsJoinModel permissionsModel= permissionsList.get(i);
        viewHolderGen.filtro.setText(permissionsModel.getId());

    }

    @Override
    public int getItemCount() {
        if(this.permissionsList.isEmpty()){
            return 0;
        }
        return this.permissionsList.size();
    }

    public class ViewHolderGen extends RecyclerView.ViewHolder {
        TextView filtro;
        public ViewHolderGen(@NonNull View itemView) {
            super(itemView);

            filtro= itemView.findViewById(R.id.permissionsTextF);
        }
    }
}