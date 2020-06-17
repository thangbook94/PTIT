/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
@WebService
@SOAPBinding(style = Style.RPC)
public class TravelSerivce {

    @WebMethod
    public String payment(
            @WebParam(name = "name") String name,
            @WebParam(name = "type") String type,
            @WebParam(name = "number") long number,
            @WebParam(name = "CVC") int cvc,
            @WebParam(name = "date") Date date
    ) {
        if (type.equals("VISA")) {
            return "OK";
        }
        return "Not OK";
    }

}
