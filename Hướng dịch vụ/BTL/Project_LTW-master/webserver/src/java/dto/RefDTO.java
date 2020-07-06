/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.User;

/**
 *
 * @author SA Nice
 */
public class RefDTO {
    private User user;
    private CartDTO cartDTO;

    public RefDTO(User user) {
        this.user = user;
    }
}
