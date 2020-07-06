/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import api.ApiCaller;
import model.User;
import utils.BaseUtils;
import utils.CheckingUtils;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SA Nice
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String typeSubmit = req.getParameter("submit");
        HttpSession session = req.getSession();
        if (typeSubmit.equals("login")) {
            String user_name = req.getParameter("user_name");
            String password = req.getParameter("password");
            try {
                password = BaseUtils.sha1(password);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!CheckingUtils.checkUsername(user_name)) {
                session.setAttribute("error", "Username or password in correct!");
                resp.sendRedirect("login");
            } else {
                User u = new User();
                u.setUsername(user_name);
                u.setPassword(password);
                u.setTypeUserId(0);

                User user = ApiCaller.doPostLogin(u);
                if (user != null) {
                    session.setAttribute("user", user);
                    resp.sendRedirect("home");
                } else {
                    session.setAttribute("error", "Username or password in correct!");
                    resp.sendRedirect("login");
                }
            }
        } else if (typeSubmit.equals("register")) {
            String user_name = req.getParameter("user_name");
            String password = req.getParameter("password");
            String name = req.getParameter("name");
            String last_name = req.getParameter("last_name");
            String address = req.getParameter("address");
            String email = req.getParameter("email");

            if (!CheckingUtils.checkUsername(user_name)) {
                session.setAttribute("error", "Username don't have special character ");
                resp.sendRedirect("register");
            } else if (user_name.length() < 6) {
                session.setAttribute("error", "Username have at least 6 characters");
                resp.sendRedirect("register");
            } else if (CheckingUtils.checkPassword(password)) {
                session.setAttribute("error", "Password have at least 8 characters, contains at least one digit, contains at least one lower alpha char and one upper alpha char, contains at least one char within a set of special chars, does not contain space,tab");
                resp.sendRedirect("register");
            } else if (!CheckingUtils.checkName(name) || !CheckingUtils.checkName(last_name)) {
                session.setAttribute("error", "Your name is not right ");
                resp.sendRedirect("register");
            } else if (last_name.length() < 2) {
                session.setAttribute("error", "Last name have at least 2 characters");
                resp.sendRedirect("register");
            } else if (name.length() < 2) {
                session.setAttribute("error", "Your name have at least 2 characters");
                resp.sendRedirect("register");
            } else if (address.length() < 2) {
                session.setAttribute("error", "Your name have at least 2 characters");
                resp.sendRedirect("register");
            } else {
                Pattern regex = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher matcher = regex.matcher(email);
                if (!matcher.matches()) {
                    session.setAttribute("error", "Email not right form");
                    resp.sendRedirect("register");
                } else {
                    try {
                        password = BaseUtils.sha1(password);
                    } catch (NoSuchAlgorithmException ex) {
                        System.out.println("Khong ma hoa duoc");
                    }
                    User user = new User(user_name, password, name, address, 3, email, last_name);

                    if (ApiCaller.doPostRegister(user)) {
                        session.setAttribute("message", "Register success!");
                        resp.sendRedirect("login");
                    } else {
                        session.setAttribute("error", "This account already exists!");
                        resp.sendRedirect("register");
                    }
//                    
//                    if (userDAO.register(user)) {
//                        session.setAttribute("message", "Register success!");
//                        resp.sendRedirect("login");
//                    } else {
//                        session.setAttribute("error", "This account already exists!");
//                        resp.sendRedirect("register");
//                    }
                }
            }
        } else if (typeSubmit.equals("edit_user")) {
            String name = req.getParameter("name");
            String last_name = req.getParameter("last_name");
            String address = req.getParameter("address");
            String email = req.getParameter("email");

            Pattern regex = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher matcher = regex.matcher(email);
            if (!matcher.matches()) {
                session.setAttribute("error", "Email not right form");
                resp.sendRedirect("editUser");
            } else {
                User user = (User) session.getAttribute("user");
                String user_name = user.getUsername();
                user.setAddress(address);
                user.setName(name);
                user.setLastName(last_name);
                user.setEmail(email);
                if (ApiCaller.doPostEdit(user)) {
                    session.setAttribute("user", user);
                    session.setAttribute("message", "Edit success!");
                    resp.sendRedirect("editUser");
                } else {
                    session.setAttribute("error", "Edit false!");
                    resp.sendRedirect("editUser");
                }
            }
        } else if (typeSubmit.equals("logout")) {
            session.setAttribute("user", null);
            resp.sendRedirect("home");
        }
    }
}
