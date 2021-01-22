package com.example.project_soccerinfo.player;

public class Player {
    String rank;
    String name;
    String team;
    String goal;
    String assist;

    public Player(String rank, String name, String team, String goal, String assist) {
        this.rank = rank;
        this.name = name;
        this.team = team;
        this.goal = goal;
        this.assist = assist;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getAssist() {
        return assist;
    }

    public void setAssist(String assist) {
        this.assist = assist;
    }
}
