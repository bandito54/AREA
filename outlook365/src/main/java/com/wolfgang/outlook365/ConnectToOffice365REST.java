/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wolfgang.outlook365;

//import com.fasterxml.jackson.databind.JsonNode;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.io.UnsupportedEncodingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.UnsupportedEncodingException;

public class ConnectToOffice365REST
{
  /**
* This methods accepts a username and password of the Office 365   * mailbox and send API request to Office 365 Server. Which returns * json object with list of unread mails.
* @param user
* @param password
* @return JSON object in string format.
    **/

 public static String getMessagesFromOffice(String user, String password) throws UnsupportedEncodingException, UnirestException
 {
              JsonNode jsonObject = null;
              HttpResponse<JsonNode> response;
              String returnString = "";
               try {
// It send request to get list of unread mails from
// inbox folder of mailbox and does basic
// authentication with provided username and password
String url_s = "https://outlook.office365.com/api/v1.0/me/messages?$filter=" + java.net.URLEncoder.encode("IsRead eq false", "UTF-8");    
response = Unirest.get(url_s).basicAuth(user,password).asJson();
  System.out.println("response : " + response.getBody());
                           jsonObject = response.getBody();
                           if(response.getBody() == null){
                                  returnString = "NULL";
                           }
                           else{
                                  returnString = jsonObject.toString();
                           } 
                     }catch (UnsupportedEncodingException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                     }
     // TODO Auto-generated catch block
                     return returnString;
              }
 
 public static void main(String[] args) throws UnsupportedEncodingException, UnirestException
 {
     String test;
     test = getMessagesFromOffice("");
 }
 
}