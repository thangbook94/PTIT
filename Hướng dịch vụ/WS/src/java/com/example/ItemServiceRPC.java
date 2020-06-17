/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Phạm Ngọc Hoàng - B16DCCN159
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ItemServiceRPC {

    @WebMethod
    public int checkInventory(
            @WebParam(name = "id") String id,
            @WebParam(name = "amount") int amount
    ) {
        return 10;
    }
}
