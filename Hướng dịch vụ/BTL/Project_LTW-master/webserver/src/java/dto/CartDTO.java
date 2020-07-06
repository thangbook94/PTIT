/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SA Nice
 */
public class CartDTO {
    private List<Product> list;
    private float totalMoney;

    public CartDTO() {
        list = new ArrayList<>();
        totalMoney = 0;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public float getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }
    
    public void addProduct(Product product){
        boolean check = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == product.getId()){
                list.get(i).setQuantity(list.get(i).getQuantity() + product.getQuantity());
                check = true;
                break;
            }
        }
        if(check == false){
            list.add(product);
        }
        totalMoney += product.getPrice() * product.getQuantity();
    }
    
    public void removeProductByID(int id){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                totalMoney -= (list.get(i).getPrice() * list.get(i).getQuantity());
                list.remove(i);
                break;
            }
        }
    }
    
    public void increaseProductByID(int id){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                totalMoney += list.get(i).getPrice();
                list.get(i).setQuantity(list.get(i).getQuantity() + 1);
                break;
            }
        }
    }
    
    public void substractProductByID(int id){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getId() == id){
                totalMoney -= list.get(i).getPrice();
                if(list.get(i).getQuantity() == 1){
                    list.remove(i); 
                }
                else{
                    list.get(i).setQuantity(list.get(i).getQuantity() - 1);
                }
                break;
            }
        }
    }
}
