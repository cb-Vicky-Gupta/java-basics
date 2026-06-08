package collections.ArrayList;

import java.util.ArrayList;

import java.util.Arrays;

public class EasyArrayList {
    public static void main(String [] args){
//        System.out.println(getDividedByThree(10));
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
        System.out.println(covertUpperCase(list));
    }
    // 1 Create an ArrayList of 10 integers. Print only elements that are divisible by 3.
    public static ArrayList<Integer> getDividedByThree(int n){
        ArrayList <Integer> arr = new ArrayList<>();
        for(int i =1; i<=n; i++){
            if(i%3 == 0){
                arr.add(i);
            }
        }
        return arr;
    }
    // 2 Given an ArrayList of strings, convert all strings to uppercase and store in a new ArrayList.
    public static ArrayList<String> covertUpperCase(ArrayList<String> s){
        ArrayList<String> newS = new ArrayList<>();
        for(String text : s){
            newS.add(text.toUpperCase());
        }
        return newS;
    }

}
