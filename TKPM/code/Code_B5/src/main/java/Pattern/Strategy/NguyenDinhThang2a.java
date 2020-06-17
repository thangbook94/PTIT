/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.Strategy;

public class NguyenDinhThang2a {

    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.add("Java Core");
        sortedList.add("Java Design Pattern");
        sortedList.add("Java Library");
        sortedList.add("Java Framework");
        sortedList.setSortStrategy(new QuickSort());
        sortedList.sort();
        sortedList.setSortStrategy(new MergeSort());
        sortedList.sort();
    }
}
