import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class MethodRepository {

    private static WebDriver driver;


    public void browserApplicationLaunch(String browserName, String url) throws InterruptedException {

        try {
            if (browserName.equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }

            if (browserName.equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
            if (browserName.equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
            }

            driver.get(url);
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    public void loginInApplication() throws InterruptedException {
//
//        //WebElement txtUsername = driver.findElement(By.id("UserID"));
//        // txtUsername.sendKeys("louissuman16@gmail.com");
//
//        //WebElement txtPassword = driver.findElement(By.id("Password"));
//        //txtPassword.sendKeys("123456");
//
//        //WebElement btnLogin = driver.findElement(By.id("btnLogin"));
//        //btnLogin.click();
//        // Relative path-Arc facilities website---Relative path
//        WebElement txtUserName = driver.findElement(By.xpath("//input[@id='UserID']"));
//        txtUserName.sendKeys("louissuman16@gmail.com");
//        Thread.sleep(3000);
//        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='Password']"));
//        txtPassword.sendKeys("123456");
//        Thread.sleep(3000);
//        WebElement btnLogin = driver.findElement(By.xpath("//button[@id='btnLogin']"));
//        btnLogin.click();
////        //Verification with Page Title
//        String expPageTitle = "ARC Facilities";
//        System.out.println(expPageTitle);
//        String actPageTitle = driver.getTitle();
//        System.out.println(actPageTitle);
//        if (expPageTitle.equals(actPageTitle)) {
//            System.out.println("Login is successful with valid credentials");
//        } else {
//            System.out.println("Login is unsuccessful with valid credentials");
//        }
//        //Verification with CurrentURL
//

//        String expCurrentURL = "https://app.skysite.com/Project/ProjectList?x=0&isFromLogin=True&isFromSharedProject=False";
//        String actCurrentURL = driver.getCurrentUrl();
//
//        if (expCurrentURL.equals(actCurrentURL)) {
//            System.out.println("Login is successful with valid credentials");
//        } else {
//            System.out.println("Login is unsuccessful with valid credentials");
//        }

    //Absolute path -Arc Facilities website---absolute path
//        WebElement txtUserName = driver.findElement(By.xpath("/html/body/form/div/div/div/div/div/div/div/input"));
//         txtUserName.sendKeys("louissuman16@gmail.com");
//        Thread.sleep(3000);
//        WebElement txtPassword = driver.findElement(By.xpath("/html/body/form/div/div/div/div/div/div/div[2]/input"));
//         txtPassword.sendKeys("123456");
//        Thread.sleep(3000);
//        WebElement btnLogin = driver.findElement(By.xpath("/html/body/form/div[1]/div/div/div[3]/div/div[1]/div[4]/button"));
//        btnLogin.click();
    //}
    public void loginWithPropertyFileData() throws InterruptedException {
        try {
            FileReader reader = new FileReader("./testdata/testdata.properties");
            Properties props = new Properties();
            props.load(reader);
            String uname = props.getProperty("username");
            String pwd = props.getProperty("password");
            WebElement username = driver.findElement(By.id("UserID"));
            username.sendKeys(uname);
            Thread.sleep(3000);
            WebElement Password = driver.findElement(By.id("Password"));
            Password.sendKeys(pwd);
            Thread.sleep(3000);
            WebElement btnLogin = driver.findElement(By.id("btnLogin"));
            btnLogin.click();

            String expPageTitle = "ARC Facilities";
            String actPageTitle = driver.getTitle();

            if (expPageTitle.equals(actPageTitle)) {
                System.out.println("Login is successful with valid credentials");
            } else {
                System.out.println("Login is unsuccessful with valid credentials");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void loginWithRobotClass() {
        try {
            FileReader reader = new FileReader("./testdata/testdata.properties");
            Properties props = new Properties();
            props.load(reader);
            String uname = props.getProperty("username");
            String pwd = props.getProperty("password");
            WebElement username = driver.findElement(By.xpath("//*[@id='UserID']"));
            username.sendKeys(uname);
            Thread.sleep(3000);
            WebElement txtpassword = driver.findElement(By.xpath("//*[@id='Password']"));
            txtpassword.sendKeys(pwd);
            Thread.sleep(3000);
            Robot robot = new Robot();
            Thread.sleep(4000);
            /* Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK, false); */
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(4000);
            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(4000);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(4000);
            String expPageTitle = "ARC Facilities";
            String actPageTitle = driver.getTitle();
            if (expPageTitle.equals(actPageTitle)) {
                System.out.println("Login is successful with valid credentials");
            } else {
                System.out.println("Login is unsuccessful with valid credentials");
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedOperationException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Building() throws InterruptedException {
        Thread.sleep(4000);
        driver.switchTo().frame("myFrameSPA");
        WebElement BldgBtn = driver.findElement(By.xpath("//div[@class='box-model-icon orange ng-tns-c161-1']"));
        //Thread.sleep(4000);
        BldgBtn.click();
        //BldgBtn.click();
        String MainWindow = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        while (i1.hasNext()) {
            String ChildWindow = i1.next();

            if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                Thread.sleep(8000);
                driver.close();
            }

        }
        driver.switchTo().window(MainWindow);
        //driver.switchTo().defaultContent();
    }

    public void popups() throws InterruptedException, AWTException {
        Thread.sleep(5000);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ishipdocs.com/ishipdocs/Secure/Login.aspx");
       // driver.get(" https://app.arcfacilities.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        WebElement pp=driver.findElement(By.xpath("//div[@id='securityUpdateMessage']/div[1]/button"));
        //WebElement af = driver.findElement(By.xpath("//div[@id='maintenance']/div/div/div/button"));
        Thread.sleep(3000);
        pp.click();
        //af.click();
        WebElement username = driver.findElement(By.xpath("//input[@id='txtUserID']"));
        username.sendKeys("louissuman16@gmail.com");
        Thread.sleep(3000);
        WebElement txtpassword = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        txtpassword.sendKeys("123456");
        Thread.sleep(3000);
        WebElement Signin=driver.findElement(By.xpath("//input[@id='btnLogin']"));
        Signin.click();


    }

    public void Multab() {
        try {
            Thread.sleep(5000);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://demo.guru99.com/popup.php");
            driver.manage().window().maximize();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
            String MainWindow = driver.getWindowHandle();
            Set<String> s1 = driver.getWindowHandles();
            Iterator<String> i1 = s1.iterator();
            while (i1.hasNext()) {
                String ChildWindow = i1.next();

                if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    Thread.sleep(5000);
                    driver.findElement(By.name("emailid"))
                            .sendKeys("Suman.striver@gmail.com");
                    Thread.sleep(5000);
                    driver.findElement(By.name("btnLogin")).click();
                    driver.close();
                }
            }

            driver.switchTo().window(MainWindow);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Wselect() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bstackdemo.com");
        WebElement filterDropDown = driver.findElement(By.xpath("//*[@id='__next']/div/div/main/div[2]/div[1]/div[1]/select"));
        filterDropDown.click();

        //Select st = new Select(filterDropDown);
        //st.selectByValue("highestprice");
        //st.selectByIndex(2);
        // st.selectByVisibleText("Name ()");
        // Thread.sleep(3000);
    }

    public static void dropDown() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.arcfacilities.com/");
        Thread.sleep(6000);
        WebElement userName = driver.findElement(By.id("UserID"));
        userName.sendKeys("r2-aguacaliente@e-arc.com");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("y49?tUPRoJe4IS!");
        WebElement signInBtn = driver.findElement(By.id("btnLogin"));
        signInBtn.click();
        Thread.sleep(12000);

        driver.switchTo().frame("myFrameSPA");

        WebElement dropDown = driver.findElement(By.xpath("//span[@class='mat-tooltip-trigger']"));
        dropDown.click();


        List<WebElement> listDropDownItems = driver.findElements(By.xpath("//*[@id='mat-menu-panel-0']/div/div/mat-selection-list/mat-list-option"));
        System.out.println("Number of items in list: " + listDropDownItems.size());

        for (int i = 1; i <= listDropDownItems.size(); i++) {
            System.out.println(driver.findElement(By.xpath("//*[@id='mat-menu-panel-0']/div/div/mat-selection-list/mat-list-option[" + i + "]")).getText());
            driver.findElement(By.xpath("//*[@id='mat-menu-panel-0']/div/div/mat-selection-list/mat-list-option[" + i + "]")).click();
            Thread.sleep(3000);

            Thread.sleep(4000);
            driver.switchTo().frame("myFrameSPA");
            WebElement BldgBtn = driver.findElement(By.xpath("//div[@class='box-model-icon orange ng-tns-c161-1']"));
            //Thread.sleep(4000);
            BldgBtn.click();
            //BldgBtn.click();
            String MainWindow = driver.getWindowHandle();
            Set<String> s1 = driver.getWindowHandles();
            Iterator<String> i1 = s1.iterator();
            while (i1.hasNext()) {
                String ChildWindow = i1.next();
                if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    Thread.sleep(8000);
                    driver.close();
                    Thread.sleep(4000);
                }
                driver.switchTo().window(MainWindow);
                //driver.switchTo().defaultContent();
            }
            if (i != listDropDownItems.size()) {
                dropDown.click();
            }
        }
    }
}










