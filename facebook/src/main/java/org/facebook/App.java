package org.facebook;

import facebook4j.Facebook;
//import com.mashape.unirest.http.Unirest;
//import com.mashape.unirest.http.exceptions.UnirestException;
import facebook4j.*;
import java.util.List;
import facebook4j.conf.ConfigurationBuilder;

public class App 
{
    public static void main( String[] args )
    {
    	ConfigurationBuilder cb = new ConfigurationBuilder();
 
    	cb.setDebugEnabled(true)
    		.setOAuthAppId("390280877977708")
    		.setOAuthAppSecret("******************************************")
    		.setOAuthAccessToken("**************************************************")
    		.setOAuthPermissions("email,publish_stream,...");//public_profile / user_friends / mail | utilisation sans certificat
    	
    	FacebookFactory ff = new FacebookFactory(cb.build());
    	Facebook facebook = ff.getInstance();
    	facebook.setOAuthAppId("390280877977708", "toto");
    	facebook.setOAuthPermissions(commaSeparetedPermissions);
    	facebook.setOAuthAccessToken(new AccessToken(accessToken, null));
    	
    	facebook.getOAuthAppAccessToken();
    	facebook.postStatusMessage("Hello World from Facebook4J.");
    }
}
