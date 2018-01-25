package ru.geekbrains.java2.lesson1.competitors;

public class Human implements Competitor {
    String name;
    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;
    boolean active;

    public boolean isOnDistance(){
        return active;
    }

    public Human(String name) {
        this.name = name;
        //делаем людей разными
        this.maxRunDistance = (int)(2000 + Math.random() * 3000);   //человек бежит от 2 до 5 км
        this.maxJumpHeight = (int)(5 + Math.random() * 15);     //человек прыгает от 5 до 20 м
        this.maxSwimDistance = (int)(100 + Math.random() * 900);    //человек проплывает от 100 м до 1 км;
        this.active = true;
    }

    public void run(int distance){
        if (distance <= maxRunDistance){
            System.out.println(name + " успешно справился с кроссом");
        } else {
            System.out.println(name + " не смог преодолеть кросс");
            active = false;
        }
    }

    public void jump(int height){
        if (height <= maxJumpHeight){
            System.out.println(name + " успешно перепрыгнул препятствие");
        } else {
            System.out.println(name + " не смог перепрыгнуть препятствие");
            active = false;
        }
    }

    public void swim(int distance){
        if (distance <= maxSwimDistance){
            System.out.println(name + " успешно проплыл дистанцию");
        } else {
            System.out.println(name + " не смог проплыть дистанцию");
            active = false;
        }
    }

    public void showResult(){
        System.out.println(name + ": " + active);
    }


    public String getName() {
        return name;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }
}
