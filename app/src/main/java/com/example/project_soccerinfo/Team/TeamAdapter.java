package com.example.project_soccerinfo.Team;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_soccerinfo.R;

import java.util.ArrayList;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.ViewHolder> {

    private ArrayList<Team> arrayList;

    public TeamAdapter(ArrayList<Team> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public TeamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamAdapter.ViewHolder holder, int position) {
        holder.rank_text.setText(arrayList.get(position).getRank());


        holder.name_text.setText(arrayList.get(position).getTeam());
        holder.played_text.setText(arrayList.get(position).getPlayed());
        holder.winpoint_text.setText(arrayList.get(position).getWinpoint());
        holder.win_text.setText(arrayList.get(position).getWin());
        holder.draw_text.setText(arrayList.get(position).getDraw());
        holder.lose_text.setText(arrayList.get(position).getLose());
        holder.goal_text.setText(arrayList.get(position).getGoal());
        holder.against_text.setText(arrayList.get(position).getAgainst());

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView rank_text, name_text, played_text, winpoint_text, win_text, draw_text, lose_text, goal_text, against_text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rank_text = (TextView) itemView.findViewById(R.id.rank_text);
            name_text = (TextView) itemView.findViewById(R.id.name_text);
            played_text = (TextView) itemView.findViewById(R.id.played_text);
            winpoint_text = (TextView) itemView.findViewById(R.id.winpoint_text);
            win_text = (TextView) itemView.findViewById(R.id.win_text);
            draw_text = (TextView) itemView.findViewById(R.id.draw_text);
            lose_text = (TextView) itemView.findViewById(R.id.lose_text);
            goal_text = (TextView) itemView.findViewById(R.id.goal_text);
            against_text = (TextView) itemView.findViewById(R.id.against_text);


        }
    }
}
