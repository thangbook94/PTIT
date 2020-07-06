/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptit.hdv.nhom8.server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author SA Nice
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "user")
//@Data
public class Product {
    private int id;
    private String name;
    private String size;
    private int typeProductId;
    private float price;
    private String link_image;
    private String color;
    private int quantity;
    private String description;

}
