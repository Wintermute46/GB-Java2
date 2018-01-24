package ru.geekbrains.java2.lesson1;

import ru.geekbrains.java2.lesson1.competitors.*;
import ru.geekbrains.java2.lesson1.obstacles.Cross;
import ru.geekbrains.java2.lesson1.obstacles.Obstacle;
import ru.geekbrains.java2.lesson1.obstacles.Wall;
import ru.geekbrains.java2.lesson1.obstacles.Water;

public class MainClass {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Obstacle[] course = {new Cross(400), new Wall(8), new Water(10)};

        for (Competitor a: competitors) {
            for(Obstacle o : course){
                o.doIt(a);
                if (!a.isOnDistance()) break;
            }
        }
        System.out.println("=======================");
        for (Competitor a: competitors){
            a.showResult();
        }
    }
}
