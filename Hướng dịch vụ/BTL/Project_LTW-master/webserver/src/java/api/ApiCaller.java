/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import org.apache.http.NameValuePair;
import org.apache.http.client.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Phạm Ngọc Hoàng - B16DCCN159
 */
public class ApiCaller {

    public static User doPostLogin(User u) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(u);
            System.out.println(jsonString);
            String result = "";
            HttpPost post = new HttpPost("http://localhost:8888/user/login");
            post.addHeader("Content-Type", "application/json");

            // add request parameters or form parameters
            try {

                post.setEntity(new StringEntity(jsonString));
                CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(post);

                result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            } catch (Exception e) {

            }

            User user = mapper.readValue(result, User.class);
            return user;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean doPostRegister(User u) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(u);
            System.out.println(jsonString);
            String result = "";
            HttpPost post = new HttpPost("http://localhost:8888/user/register");
            post.addHeader("Content-Type", "application/json");

            // add request parameters or form parameters
            try {

                post.setEntity(new StringEntity(jsonString));
                CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(post);

                result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            } catch (Exception e) {

            }

            
            return result.equals("ok");
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean doPostEdit(User u) {

        try {

            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(u);
            System.out.println(jsonString);
            String result = "";
            HttpPost post = new HttpPost("http://localhost:8888/user/editProfile");
            post.addHeader("Content-Type", "application/json");

            // add request parameters or form parameters
            try {

                post.setEntity(new StringEntity(jsonString));
                CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(post);

                result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            } catch (Exception e) {

            }

            
            return result.equals("ok");
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ApiCaller.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
