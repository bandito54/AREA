/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.twitter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *
 * @author Thomas BARIC
 */
public class oauth {
     public static void main(String args[]) throws Exception{
    // The factory instance is re-useable and thread safe.
    Twitter twitter = TwitterFactory.getSingleton();
    twitter.setOAuthConsumer("SjLUa1Pwrs81nIAGiR4f1l4I7", "ISAXBmzqzYLKWQXAaOe09j34APvVOyxahHghLBSvvR0Psnhozl");
    RequestToken requestToken = twitter.getOAuthRequestToken();
    AccessToken accessToken = null;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (null == accessToken) {
      System.out.println("Open the following URL and grant access to your account:");
      System.out.println(requestToken.getAuthorizationURL());
      System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
      String pin = br.readLine();
      try{
         if(pin.length() > 0){
           accessToken = twitter.getOAuthAccessToken(requestToken, pin);
         }else{
           accessToken = twitter.getOAuthAccessToken();
         }
      } 
      catch (TwitterException te) {
        if(401 == te.getStatusCode()){
          System.out.println("Unable to get the access token.");
        }else{
         te.printStackTrace();
        }
      }
    }
    //persist to the accessToken for future reference.
    storeAccessToken((int) twitter.verifyCredentials().getId(), accessToken);
    Status status = twitter.updateStatus(args[0]);
    System.out.println("Successfully updated the status to [" + status.getText() + "].");
    System.exit(0);
  }
  private static void storeAccessToken(int useId, AccessToken accessToken){
    //store accessToken.getToken()
    //store accessToken.getTokenSecret()
  }
}
