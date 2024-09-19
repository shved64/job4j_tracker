package ru.job4j.polymorphism;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("Автобус движется");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Колличество пассажиров" + count);
    }

    @Override
    public int refuel(int fuel) {
        int fuelPrice = 50;
        int cost = fuel * fuelPrice;
        System.out.println("Стоимость заправки" + cost);
        return cost;
    }
}
