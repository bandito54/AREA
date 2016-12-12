package org.twitter;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import twitter4j.*;
import java.util.List;
import twitter4j.conf.ConfigurationBuilder;

public class App 
{
    public static void main( String[] args ) throws TwitterException, UnirestException
    {
       ConfigurationBuilder cf = new ConfigurationBuilder();
       
       cf.setDebugEnabled(true)
               .setOAuthConsumerKey("XCQQo3KcxGEyb0fRb75FxhYYq")
               .setOAuthConsumerSecret("GgqjtgFG0t9YI22wWj1IPwYJQknULQ5tqKzZTqsvfR2RrkSerz")
               .setOAuthAccessToken("808268446370791424-zcBycg7iWA6Auzw3ZrAUqs36DL6Njjl")
               .setOAuthAccessTokenSecret("Ecfq9Uvc3zjtHzOJ1efE1KaxxL0sGBl3iKp6GOwbwEpbj");
               
               TwitterFactory tf = new TwitterFactory(cf.build());   
               twitter4j.Twitter twitter = tf.getInstance();
               
               //get username, status, time of post
               Unirest.post("https://api.twitter.com/1.1/statuses/update.json\n")
                .queryString("status", "Test d'un tweet, will it blend ?")
                .field("status", "Test d'un tweet, will it blend ?")
                .asJson();
               //get username, status, time of post
               
               List<Status> status;
        status = twitter.getHomeTimeline();
               for (Status st : status)
               {
                  System.out.println(st.getUser() + "-----------" + st.getUser().getName() + "---------" + st.getText());
               }
    }
}
