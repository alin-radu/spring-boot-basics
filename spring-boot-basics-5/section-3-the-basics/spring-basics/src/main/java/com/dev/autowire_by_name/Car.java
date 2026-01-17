package com.dev.autowire_by_name;

public class Car {
    private Specification specification;

    public void setSpecification(Specification specification) {
        System.out.println("Car | setSpecification | setter executed");
        this.specification = specification;
    }

    public void displayDetails() {
        System.out.println("Car Details: " + specification.toString());
    }
}
