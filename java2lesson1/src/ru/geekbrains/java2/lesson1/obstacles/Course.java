package ru.geekbrains.java2.lesson1.obstacles;

import ru.geekbrains.java2.lesson1.competitors.Competitor;
import ru.geekbrains.java2.lesson1.competitors.Team;

public class Course {
    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Obstacle obstracle: obstacles) {
            for (Competitor member: team.getMembers()) {
                obstracle.doIt(member);
            }
        }
    }

    public Obstacle[] getObstacles() {
        return obstacles;
    }
}
