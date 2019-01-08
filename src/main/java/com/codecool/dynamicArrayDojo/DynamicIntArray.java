package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {

    private int size; //number of elements
    private int[] data; //array for storing elements


    public DynamicIntArray(){
        data = new int[1];
        size = 0;
    }

    public DynamicIntArray(int size){
        if (capacity < 1){
            capacity = 1;}
        data = new int[capacity];
        size = 0;
    }

    public void add(int element){
        updateCapacity(size + 1);
        data[size++] = element;
        decreaseCapacity();
    }

    public void remove(int index){

    }

    public int size(){
        return size;
    }

    public void insert(int index){
    }

    private void updateCapacity(int minimumCapacity) {
        int previousCapacity = data.length;

        if (minimumCapacity > previousCapacity) {
            int newCapacity = (previousCapacity * 2);
            if (newCapacity < minimumCapacity)
                newCapacity = minimumCapacity;
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    /**This method is used to decrease visible capacity for toString method*/
    private void decreaseCapacity(){
        int currentCapacity = data.length;

        if(currentCapacity > size){
            int[] newArray = Arrays.copyOf(data, size);
            data = newArray;
        }
    }



}
