package Main;

import com.sun.tools.xjc.gen.Var;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.lang.model.element.Element;
import java.net.URL;
import java.util.*;

public class DM {
	public AppiumDriver driver;

	@Before
	public void SetUp() throws Exception{

		//Android
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("deviceName", "FA7AH1A04756");
//		capabilities.setCapability("app", "/Users/elderhuffman/Documents/doctrinalmastery-alpha-25006.apk");
//		capabilities.setCapability("platformName", "android");
//		capabilities.setCapability("appPackage", "org.lds.sm.dev");
//		capabilities.setCapability("appActivity", "org.lds.sm.ui.activity.StartupActivity");

		//iOS


		driver = new AndroidDriver(new URL ("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@After
	public void tearDown() throws Exception{
		driver.quit();
	}

	public String GetSelectedCollectionText(){
		return driver.findElement(By.id("org.lds.sm.dev:id/spinner_subtitle")).getText();
	}

	//Tests

	@Test
	public void OpenApp() throws InterruptedException {
		//Open app
		//Verify Memorize appears
		Assert.assertTrue(driver.findElement(By.id("org.lds.sm.dev:id/memorize_card")).isDisplayed());

		//Verify Flashcards appears
		Assert.assertTrue(driver.findElement(By.id("org.lds.sm.dev:id/flashcard_card")).isDisplayed());

		//Verify Quiz appears
		Assert.assertTrue(driver.findElement(By.id("org.lds.sm.dev:id/quiz_card")).isDisplayed());

		//Verify Quiz Scores appears
		Assert.assertTrue(driver.findElement(By.id("org.lds.sm.dev:id/score_card")).isDisplayed());
	}


	@Test
	public void SelectCollection() throws InterruptedException{
		WebElement dropdown = driver.findElement(By.id("org.lds.sm.dev:id/category_spinner"));

		//Select Old Testament
		dropdown.click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.RelativeLayout")).click();

		//Verify Old Testament text
		Assert.assertEquals("Old Testament", GetSelectedCollectionText());

		//Select New Testament
		dropdown.click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout[2]/android.widget.RelativeLayout")).click();

		//Verify New Testament text
		Assert.assertEquals("New Testament", GetSelectedCollectionText());

		//Select Book of Mormon
		dropdown.click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout[3]/android.widget.RelativeLayout")).click();

		//Verify book of Mormon text
		Assert.assertEquals("Book of Mormon", GetSelectedCollectionText());

		//Select Doctrine and Covenants
		dropdown.click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout[4]/android.widget.RelativeLayout")).click();

		//Verify Doctrine and Covenants text
		Assert.assertEquals("Doctrine and Covenants and Church History", GetSelectedCollectionText());

		//Select The Articles of Faith
		dropdown.click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout[5]/android.widget.RelativeLayout")).click();

		//Verify The Articles of Faith text
		Assert.assertEquals("The Articles of Faith", GetSelectedCollectionText());

		//Select My Scriptures
		dropdown.click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout[6]/android.widget.RelativeLayout")).click();

		//Verify My Scriptures text
		Assert.assertEquals("My Scriptures", GetSelectedCollectionText());
	}

	private String GetQuizPhrase(){
		return driver.findElement(By.id("org.lds.sm.dev:id/phrase")).getText();
	}

	private String GetOTCorrectAnswer(){
		//Get the scripture phrase
		String phrase = GetQuizPhrase();

		if (phrase.equals("God's work and glory is to bring to pass the immortality and eternal life of man.")){
			return "Moses 1:39";
		}
		else if (phrase.equals("Zion—one heart and one mind in righteousness")){
			return "Moses 7:18";
		}
		else if (phrase.equals("Abraham was chosen before he was born.")){
			return "Abraham 3:22–23";
		}
		else if (phrase.equals("God created man in His own image.")){
			return "Genesis 1:26–27";
		}
		else if (phrase.equals("Multiply and replenish the earth.")){
			return "Genesis 1:28";
		}
		else if (phrase.equals("Husband and wife are to be one.")){
			return "Genesis 2:24";
		}
		else if (phrase.equals("Joseph resisted temptation.")){
			return "Genesis 39:9";
		}
		else if (phrase.equals("Keep my covenant and ye shall be a holy nation.")){
			return "Exodus 19:5–6";
		}
		else if (phrase.equals("God revealed the Ten Commandments.")){
			return "Exodus 20:3–17";
		}
		else if (phrase.equals("Choose you this day whom ye will serve.")){
			return "Joshua 24:15";
		}
//		else if (phrase.equals(){
//			return "1 Samuel 16:7";
//		}
		else if (phrase.equals("To stand worthy in the Lord’s presence, we must have clean hands and a pure heart.")){
			return "Psalm 24:3–4";
		}
//		else if (phrase.equals(){
//			return "Psalm 119:105";
//		}
//		else if (phrase.equals(){
//			return "Psalm 127:3";
//		}
		else if (phrase.equals("Trust in the Lord with all thine heart, and He shall direct thy paths.")){
			return "Proverbs 3:5–6";
		}
		else if (phrase.equals("If we repent, our sins shall be as white as snow.")){
			return "Isaiah 1:18";
		}
		else if (phrase.equals("Woe unto them that call evil good, and good evil.")){
			return "Isaiah 5:20";
		}
		else if (phrase.equals("The Restoration is a marvelous work and a wonder.")){
			return "Isaiah 29:13–14";
		}
		else if (phrase.equals("Jesus Christ bore our griefs and suffered for our sins.")){
			return "Isaiah 53:3–5";
		}
		else if (phrase.equals("Fasting helps us to loose the bands of wickedness, undo heavy burdens, and provide for the poor.")){
			return "Isaiah 58:6–7";
		}
		else if (phrase.equals("The Sabbath is the Lord’s holy day.")){
			return "Isaiah 58:13–14";
		}
		else if (phrase.equals("Jeremiah was foreordained to be a prophet.")){
			return "Jeremiah 1:4–5";
		}
		else if (phrase.equals("The Bible and the Book of Mormon are joined together.")){
			return "Ezekiel 37:15–17";
		}
		else if (phrase.equals("God reveals His secret to His prophets.")){
			return "Amos 3:7";
		}
		else if (phrase.equals("Paying tithing brings blessings.")){
			return "Malachi 3:8–10";
		}
		else if (phrase.equals("God’s kingdom shall stand forever.")){
			return "Daniel 2:44";
		}
		else /*(phrase.equals("Elijah will turn the hearts of fathers and children."))*/{
			return "Malachi 4:5–6";
		}
	}

	public void SelectCorrectAnswer(){
		//Find the correct answer
		String ans = GetOTCorrectAnswer();

		//Get the answer elements
		WebElement answers[] = new WebElement[4];

		//String answers = driver.findElement(By.)
		answers[0] = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.TextView"));
		answers[1] = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.TextView"));
		answers[2] = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[3]/android.widget.RelativeLayout/android.widget.TextView"));
		answers[3] = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[4]/android.widget.RelativeLayout/android.widget.TextView"));

		//driver.findElement(By.xpath("//android.widget.TextView[@text='" + ans + "']")).click();

		//Select the correct answer
		for (int i = 0; i < 4; i++){
			String option = answers[i].getText();
			if (option.equals(ans)){
				driver.tap(1, answers[i], 500);
				i = 4;
			}
		}
	}

	@Test
	public void OldTestamentQuiz() throws InterruptedException{
		//Open Collection drop down
		driver.findElement(By.id("org.lds.sm.dev:id/category_spinner")).click();

		//Select Old Testament
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.FrameLayout[1]/android.widget.RelativeLayout")).click();

		//Select Quiz
		driver.findElement(By.id("org.lds.sm.dev:id/quiz_card")).click();

		//Select 5 questions
		driver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.TextView[1]"))).click();

		//Select the correct answers
		int i = 1;
		while (i <= 5){

			//Select the correct answer
			SelectCorrectAnswer();

			//Click Next
			driver.findElement(By.id("org.lds.sm.dev:id/next_button")).click();
			i++;
		}

		//Verify finished menu
		Assert.assertTrue(driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout")).isDisplayed());

		//Enter name
		driver.findElement(By.id("org.lds.sm.dev:id/name")).sendKeys("Test");

		//Click Save
		driver.findElement(By.id("android:id/button1")).click();

		//Click View High Scores
		driver.findElement((By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"))).click();

		//Verify score
		Assert.assertEquals("Test", driver.findElement(By.id("org.lds.sm.dev:id/name")).getText());
	}

}
