package ru.geekbrains.java2.lesson1;

import ru.geekbrains.java2.lesson1.competitors.*;
import ru.geekbrains.java2.lesson1.obstacles.*;

public class MainClass {
    public static void main(String[] args) {
//        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Obstacle[] courses = {new Cross(400), new Wall(8), new Water(10)};
//
//        for (Competitor a: competitors) {
//            for(Obstacle o : course){
//                o.doIt(a);
//                if (!a.isOnDistance()) break;
//            }
//        }

        Course course = new Course(courses);
        Team team = new Team("Спартак", new Human("Вася"), new Human("Петя"), new Human("Вова"), new Human("Коля"));
        course.doIt(team);

        System.out.println("=======================");
//        for (Competitor a: competitors){
//            a.showResult();
//        }
        team.showResults();
    }
}
