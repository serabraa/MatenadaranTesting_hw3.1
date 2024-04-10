package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class TestSelenium {
    public static WebDriver driver;
    public static String matenadaranUrl = "https://matenadaran.am/";


    @BeforeClass
    public static void settingUpWebDrvier()
    {
        System.setProperty("webdriver.chrome.driver","/Users/sergey/Downloads/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }
    @Before
    public void settingUpSUT(){
        driver.get("https://www.matenadaran.am");
    }

    @Test
    public void openMatenadaran() {
        String actualname = driver.getTitle();
        String expectedTitle = "ՄԱՏԵՆԱԴԱՐԱՆ — Մեսրոպ Մաշտոցի անվան հին ձեռագրերի գիտահետազոտական ինստիտուտ";
        assertEquals(expectedTitle,actualname);

    }
    @Test
    public void clickabilityTest(){
        WebElement wb = driver.findElement(By.xpath("//header/div[@id='site-header']/div[@id='header']/div[@id='header-core']/div[@id='header-links']/div[@id='header-links-inner']/ul[@id='menu-%d5%b4%d5%a1%d5%bf%d5%a5%d5%b6%d5%a1%d5%a4%d5%a1%d6%80%d5%a1%d5%b6']/li[@id='menu-item-1586']/a[1]/span[1]"));
        wb.click();
        String expectedTitle = "Պատմական ակնարկ — ՄԱՏԵՆԱԴԱՐԱՆ";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void buyingTicketButtonTest(){
        WebElement bt = driver.findElement(By.cssSelector("body.home.page-template-default.page.page-id-7.page-child.parent-pageid-101.wp-custom-logo.layout-sidebar-left.layout-responsive.slider-full.pre-header-style1.header-style1.scrollup-on.group-blog:nth-child(2) div.hfeed.site:nth-child(1) div:nth-child(1) aside.widget_text.widget.widget_custom_html:nth-child(2) div.textwidget.custom-html-widget a:nth-child(1) > strong:nth-child(1)"));
        bt.click();
        String expectedTitle = "Գնել առցանց տոմս — ՄԱՏԵՆԱԴԱՐԱՆ";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

    }
    @Test
    public void searchingMesropMashtots(){
        WebElement searchBar = driver.findElement(By.xpath("//body/div[@id='body-core']/div[@id='content']/div[@id='content-core']/div[@id='sidebar']/div[@id='sidebar-core']/aside[1]/form[1]/input[1]"));
        searchBar.click();
        searchBar.sendKeys("Մեսրոպ Մաշտոց");
        searchBar.sendKeys(Keys.ENTER);
        String expectedTitle = "‘Մեսրոպ Մաշտոց’-ի որոնման արդյունքները — ՄԱՏԵՆԱԴԱՐԱՆ";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle,actualTitle);
    }
    @Test
    public void languageChange(){
        WebElement hover = driver.findElement(By.xpath("//header/div[@id='site-header']/div[@id='pre-header']/div[1]/div[1]/div[1]/ul[1]/li[6]/a[1]/span[1]"));
        hover.click();
//        System.out.println(hover.isSelected());
        WebElement english = driver.findElement(By.xpath("//header/div[@id='site-header']/div[@id='pre-header']/div[1]/div[1]/div[1]/ul[1]/li[6]/ul[1]/li[2]/a[1]/span[1]"));
        english.click();
        String expectedTitle = "Matenadaran – Mesrop Mashtots Research Institute of Ancient Manuscripts";
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void findingSimiliarElements(){
        int count =0;
        List<WebElement>elementList = driver.findElements(By.tagName("span"));
        for (WebElement singleElement:elementList) {
            System.out.println(singleElement);
            count++;
        }
        assertEquals(count,78);
    }

    @AfterClass
    public static void quitDriver(){
        driver.quit();
    }
}
