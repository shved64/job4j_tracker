package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void area() {
        Point d = new Point(0, 0);
        Point e = new Point(2, 0);
        Point f = new Point(4, 0);
        Triangle invalidTriangle = new Triangle(d, e, f);

        double invalidResult = invalidTriangle.area();
        assertEquals(-1, invalidResult);
    }
}