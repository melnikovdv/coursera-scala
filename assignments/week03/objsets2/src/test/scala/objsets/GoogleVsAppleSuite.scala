package objsets

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GoogleVsAppleSuite extends FunSuite{

  test("reader test") {
//    TweetReader.ParseTweets
    val tweets = TweetReader.allTweets
    assert(tweets.size === 695)
  }

  test("Tweets count") {
    assert(GoogleVsApple.googleTweets.size === 38)
    assert(GoogleVsApple.appleTweets.size === 150)
  }

  test("trending") {
    GoogleVsApple.trending.foreach(t => println(t.retweets + ": " + t.text))
  }


}
