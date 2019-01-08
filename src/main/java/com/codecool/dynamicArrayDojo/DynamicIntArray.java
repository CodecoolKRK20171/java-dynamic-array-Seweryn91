package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {

    private int size; //number of elements
    private int[] data; //array for storing elements
    private int capacity;


    public DynamicIntArray(){
        data = new int[1];
        size = 0;
    }

    public DynamicIntArray(int capacity){
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
        checkIfInBounds(index);
        int[] newArray = new int[data.length-1];
        if(index > 0){
        
            for(int i=0; i < index; i++){
            newArray[i] = data[i];
        }


        for(int i=index; i < newArray.length; i++){
            newArray[i] = data[i+1];
            }
        }else{

            for(int i=1; i < data.length; i++){
                newArray[i-1] = data[i];
            }
        }
        
        data = newArray;
        size = newArray.length;
    }

    public int size(){
        return size;
    }

    public void insert(int index, int element){
        updateCapacity(size + 1);

        if(index < 0){
            throw new IllegalArgumentException("Index must be equal to or higher than 0!");
        }

        int[] newArray = new int[size+1];

        if(index > size){
            index = data.length;
            newArray = new int[size+2];
        }

        for(int i=0; i < index; i++){
            newArray[i] = data[i];
        }

        for(int i=index; i < size; i++){
            newArray[i+1] = data[i];
        }
        newArray[index] = element;
        decreaseCapacity();
        data = newArray;
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

    private void checkIfInBounds(int index) {
        if(index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + index + " size: " + size);

    }

    /**This method is used to decrease visible capacity for toString method*/
    private void decreaseCapacity(){
        int currentCapacity = data.length;

        if(currentCapacity > size){
            int[] newArray = Arrays.copyOf(data, size);
            data = newArray;
        }
    }

    @Override
    /**this one looks bad, but...
     * ONE DOES NOT SIMPLY BLAME TESTS*/
    public String toString(){
        String output = "";

        for(int i = 0; i < data.length; i++){
            output += " " + data[i];
        }

        return output;
    }

}
