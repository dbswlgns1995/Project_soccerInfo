package com.example.project_soccerinfo.player;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_soccerinfo.R;

import java.util.ArrayList;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {

    private ArrayList<Player> arrayList;

    public PlayerAdapter(ArrayList<Player> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public PlayerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerAdapter.ViewHolder holder, int position) {
        holder.rank_text.setText(arrayList.get(position).getRank());
        holder.player_text.setText(arrayList.get(position).getName());
        holder.team_text.setText(arrayList.get(position).getTeam());
        holder.goal_text.setText(arrayList.get(position).getGoal());
        holder.assist_text.setText(arrayList.get(position).getAssist());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView rank_text, player_text, team_text, goal_text, assist_text;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rank_text = itemView.findViewById(R.id.p_rank_text);
            player_text = itemView.findViewById(R.id.p_name_text);
            team_text = itemView.findViewById(R.id.p_team_text);
            goal_text = itemView.findViewById(R.id.p_goal_text);
            assist_text = itemView.findViewById(R.id.p_assist_text);

        }
    }
}
