/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern.Strategy;

import java.util.List;

public interface SortStrategy {

    <T> void sort(List<T> items);
}