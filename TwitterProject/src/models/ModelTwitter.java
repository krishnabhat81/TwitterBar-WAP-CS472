package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import classes.Tweet;
import twitter4j.GeoLocation;
import twitter4j.Location;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

public class ModelTwitter {

	public ModelTwitter() {
	}

	public List<Tweet> fetchTweets(String queryString) {
		List<Tweet> list = new ArrayList<>();
		try {
			// OR, tf.getInstance()
			Twitter twitterConnection = new TwitterFactory().getInstance();

			Query query = new Query(queryString);
			query.setCount(8);// limit 8

			QueryResult result = twitterConnection.search(query);
			List<Status> tweets = result.getTweets();

			// JAVA 8 Stram API; Lambda expression...
			list = tweets.stream().map(tweet -> {
				User u = tweet.getUser();
				return new Tweet(u.getScreenName(), u.getName(), u.getProfileImageURL(), tweet.getText());
			}).collect(Collectors.toList());

		} catch (TwitterException e) {
			e.printStackTrace();
			System.out.println("Failed to search tweets: " + e.getMessage());
			System.exit(-1);
		}

		return list;
	}

	public List<Trend> fetchTrends(String lat, String lng) {
		List<Trend> list = new ArrayList<Trend>();
		try {
			Twitter twitter = new TwitterFactory().getInstance();

			ResponseList<Location> locations = twitter.getClosestTrends(new GeoLocation(Double.parseDouble(lat), Double.parseDouble(lng)));
			Trends placeTrends = twitter.getPlaceTrends(locations.get(0).getWoeid());

			Trend[] trends = placeTrends.getTrends();

			// save only 5 trends
			list = Arrays.stream(trends).limit(5).collect(Collectors.toList());
			
		} catch (TwitterException te) {
			te.printStackTrace();
			System.out.println("Failed to get trends: " + te.getMessage());
			// System.exit(-1);
		}

		return list;
	}

}
