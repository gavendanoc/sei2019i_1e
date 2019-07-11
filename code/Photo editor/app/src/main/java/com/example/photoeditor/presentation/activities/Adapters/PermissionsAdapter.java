package com.example.photoeditor.presentation.activities.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.photoeditor.R;
import com.example.photoeditor.dataAccess.models.UserModel;
import com.example.photoeditor.dataAccess.requests.UserAdapter;

import java.util.ArrayList;

public class PermissionsAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolderGen> {

    @NonNull
    @Override
    public UserAdapter.ViewHolderGen onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolderGen viewHolderGen, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderGen extends RecyclerView.ViewHolder {
        public ViewHolderGen(@NonNull View itemView) {
            super(itemView);
        }
    }
}