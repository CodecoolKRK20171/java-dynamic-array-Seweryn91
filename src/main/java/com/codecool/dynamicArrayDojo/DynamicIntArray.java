package com.codecool.dynamicArrayDojo;

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

    public void createArray(int size){

    }

    public void add(int index){
    }

    public void remove(int index){

    }

    public int size(){
        return size;
    }

    public void insert(int index){
    }

}
