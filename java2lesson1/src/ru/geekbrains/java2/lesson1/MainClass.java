package ru.geekbrains.java2.lesson1;

import ru.geekbrains.java2.lesson1.competitors.*;
import ru.geekbrains.java2.lesson1.obstacles.*;

public class MainClass {
    public static void main(String[] args) {
        Obstacle[] courses = {new Cross(400), new Wall(8), new Water(500)};

        Course course = new Course(courses);
        Team team = new Team("Спартак", new Human("Вася"), new Human("Петя"), new Human("Вова"), new Human("Коля"));
        course.doIt(team);

        System.out.println("=======================");
        team.showResults();
    }
}
