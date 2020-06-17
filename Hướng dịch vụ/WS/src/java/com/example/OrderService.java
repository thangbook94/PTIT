/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Phạm Ngọc Hoàng - B16DCCN159
 */
@WebService
public class OrderService {
    @WebMethod
    public String checkOrderStatus(
            @WebParam(name="order-number") Order or
    ) {
        return "PENDING";
    }
}
