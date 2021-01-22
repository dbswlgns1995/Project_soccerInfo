package com.example.project_soccerinfo.Team;

import android.graphics.drawable.Drawable;

public class Team {

    String rank;
    String team;
    String played;
    String winpoint;
    String win;
    String draw;
    String lose;
    String goal;
    String against;

    public Team(String rank, String team, String played, String winpoint, String win, String draw, String lose, String goal, String against) {
        this.rank = rank;
        this.team = team;
        this.played = played;
        this.winpoint = winpoint;
        this.win = win;
        this.draw = draw;
        this.lose = lose;
        this.goal = goal;
        this.against = against;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPlayed() {
        return played;
    }

    public void setPlayed(String played) {
        this.played = played;
    }

    public String getWinpoint() {
        return winpoint;
    }

    public void setWinpoint(String winpoint) {
        this.winpoint = winpoint;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getLose() {
        return lose;
    }

    public void setLose(String lose) {
        this.lose = lose;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getAgainst() {
        return against;
    }

    public void setAgainst(String against) {
        this.against = against;
    }
}
