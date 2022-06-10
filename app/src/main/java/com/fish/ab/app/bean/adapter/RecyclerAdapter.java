package com.fish.ab.app.bean.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fish.ab.R;
import com.fish.ab.app.bean.ProjectInfo;
import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private ArrayList<ProjectInfo> project_list;

    private RecyclerViewClickListener listener;

    public RecyclerAdapter(ArrayList<ProjectInfo> info_list, RecyclerViewClickListener listener){
        this.project_list = info_list;

        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTextView;

        public MyViewHolder(final View view){
            super(view);
            nameTextView = view.findViewById(R.id.name_textView);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAbsoluteAdapterPosition());
        }
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String name = project_list.get(position).getName();
        holder.nameTextView.setText(name);
    }


    @Override
    public int getItemCount() {
        return project_list.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

}

