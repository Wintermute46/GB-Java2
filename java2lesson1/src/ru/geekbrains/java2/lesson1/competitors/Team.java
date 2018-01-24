package ru.geekbrains.java2.lesson1.competitors;

public class Team {
    public String teamName;
    public Competitor[] members = new Human[4];

    public Team(String teamName, Human member1, Human member2, Human member3, Human member4) {
        this.teamName = teamName;
        this.members[0] = member1;
        this.members[1] = member2;
        this.members[2] = member3;
        this.members[3] = member4;
    }

    public Team(String teamName, Competitor[] members) {
        this.teamName = teamName;
        this.members = members;
    }

    public void showMembersList() {
        System.out.println("Состав участников команды " + this.teamName + " :");
        for (Competitor member: members) {
            System.out.println(((Human)member).getName());
        }
    }

    public void showResults() {
        System.out.println("В команде " + this.teamName + " прошли дистанцию:");
        for (Competitor member: members) {
            if (member.isOnDistance()) member.showResult();
        }
    }


    public String getTeamName() {
        return teamName;
    }

    public Competitor[] getMembers() {
        return members;
    }
}
