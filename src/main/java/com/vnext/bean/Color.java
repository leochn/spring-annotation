package com.vnext.bean;

/**
 * @author leo
 * @version 2018/4/6 8:13
 * @since 1.0.0
 */
public class Color {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color [car=" + car + "]";
    }
}
