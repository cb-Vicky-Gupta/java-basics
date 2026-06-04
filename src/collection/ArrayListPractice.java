package collection;

import java.util.*;

public class ArrayListPractice {
    static void main() {
        // 1. Create an ArrayList of 5 integers and print them in reverse order
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(150);
        list.add(15);
//        System.out.println(list);
//        for(int i = 0; i<list.size(); i ++){
//            System.out.print(list.get(i) + " ");
//        }
//        System.out.println();
//        for(int num : list){
//            System.out.print(num + " ");
//        }

        // 2. Remove all even numbers from an ArrayList
//        list.removeIf(num -> num %2 != 0);

//        System.out.println(list);

        // 3. Find maximum and minimum element
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) > max){
                max = list.get(i);
            }
            if(list.get(i) <min){
                min = list.get(i);
            }
        }
//        System.out.printf("max Value is : %d and min Value is : %d%n", max, min);
        // 4. Check if ArrayList contains an element
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList("Java", "Python", "C++", "Javascript"));
//        System.out.println(stringList.contains("Java"));

        // 5. Copy one ArrayList into another
        ArrayList<String> cpyList = new ArrayList<>(stringList);
//        System.out.println(cpyList);
        // LinkList
        // 6. Add elements at first, last and middle
        LinkedList<String> llist = new LinkedList<>();
        llist.addFirst("A");
        llist.addLast("B");
        llist.add(1, "C");
//        System.out.println(llist);

        //7. Convert LinkedList ↔ ArrayList
        LinkedList<Integer> linked = new LinkedList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        ArrayList<Integer> arrList = new ArrayList<>(linked);
        LinkedList<Integer> linked2 = new LinkedList<>(arrList);
//        System.out.println(arrList);
//        System.out.println(linked2);

        // 8. Remove first and last element
//        linked.removeFirst();
//        System.out.println(linked);
//        linked.removeLast();
//        System.out.println(linked);
//        linked.remove(3);
//        System.out.println(linked);

        // HashSet
        // 9. Add 10 elements and print unique ones
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        set.add(8);
        set.add(7);
//        System.out.println(set);
        // 10. Union and Intersection
        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(6,7,4,5));

        HashSet<Integer> unioun = new HashSet<>(s1);
        unioun.addAll(s2);
        HashSet<Integer> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);
//        System.out.println(unioun);
//        System.out.println(intersection);
        //11. Check subset
        HashSet<Integer> sub1 = new HashSet<>(Arrays.asList(1,2));
        HashSet<Integer> sub2 = new HashSet<>(Arrays.asList(1,2,3,4));
//        System.out.println(sub2.containsAll(sub1));

        //Hashmap
        //12. Student names and marks
        HashMap<String, Integer> map  = new HashMap<>();
        map.put("Vicky", 100);
        map.put("Jhon", 150);
        map.put("Doe", 90);
//        System.out.println(map);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
//            System.out.print(entry.getKey() + "->" + entry.getValue() + " ");
        }
        // 13. Remove Duplicates without Set
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(1,1,2,3,4,4));
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : l){
//            if(result.contains(num)){
//                continue;
//            }else{
//                result.add(num);
//            }
            if(!result.contains(num)){
                result.add(num);
            }
        }
//        System.out.println(result);
        // 14. Frequency Count
        ArrayList<Integer> freqA = new ArrayList<>(Arrays.asList(1,1,2,3,4,4));
        HashMap<Integer, Integer> mapFre = new HashMap<>();
        for(int num : freqA){
            if(mapFre.containsKey(num)){
                mapFre.put(num , mapFre.get(num)+1);
            }else{
                mapFre.put(num, 1);
            }
        }
//        System.out.println(mapFre);
        // 15. Sort Custom Objects

    }
}
