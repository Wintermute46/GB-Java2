package ru.geekbrains.java2.lesson1.competitors;

public class Team {
    public String teamName;
    public Competitor[] members = new Human[4];




    public String getTeamName() {
        return teamName;
    }

    public Competitor[] getMembers() {
        return members;
    }
}
