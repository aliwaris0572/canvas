package com.example.myapplication;

public class Node {
    private Float angle, length, x, y;
    private Node destinationNode;

    public Node(Float angle, Float length, Float x, Float y) {
        this.angle = angle;
        this.length = length;
        this.x = x;
        this.y = y;
    }

    public Node(Float x, Float y, Node destinationNode) {
        this.x = x;
        this.y = y;
        this.destinationNode = destinationNode;
    }

    public Float getAngle() {
        return angle;
    }

    public Float getLength() {
        return length;
    }

    public Float getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    public Node getDestinationNode() {
        return destinationNode;
    }
}
