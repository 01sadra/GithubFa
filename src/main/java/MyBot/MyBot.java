import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.StatusUpdate;
import twitter4j.RateLimitStatus;
import java.util.*;

public class MyBot{
    //If something goes wrong, we might see a TwitterException
    public static void main(String... args) throws TwitterException{
        //Access the twitter API using your twitter4j.properties file
        Twitter twitter = TwitterFactory.getSingleton();
        //search for all tweets that include "github.com" and their lang is fa
         Query query = new Query("\"github.com\" AND lang:fa");
         QueryResult result = twitter.search(query);

          try {
          //  Retweet the last 5 query
            for (int i =0; i <= 4 ; i++ ){
              Status tweetResult = result.getTweets().get(i);
              long statusId = tweetResult.getId();
              //Did retweeted by me or not
              if(tweetResult.isRetweetedByMe()) {
                System.out.println("we retweeted this before");
                System.out.println(statusId);
                }else{
                  //Retweet the tweet
                  twitter.retweetStatus(statusId);  
                }
                //sleep for 30 min
                System.out.println("sleeping ");
                Thread.sleep(60*1000*30); 
              }
              } catch (Exception e){
                System.out.println(e);
              }
        }
}
