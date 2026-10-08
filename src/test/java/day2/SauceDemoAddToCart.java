package day2;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoAddToCart {

    public static void main(String[] args) {

        // Launch browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        try {

            // =====================================================
            // 1. OPEN APPLICATION
            // =====================================================

            driver.get("https://www.saucedemo.com/");

            System.out.println("Application opened");


            // =====================================================
            // 2. LOGIN
            // =====================================================

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("user-name")
            )).sendKeys("standard_user");

            driver.findElement(
                    By.id("password")
            ).sendKeys("secret_sauce");

            driver.findElement(
                    By.id("login-button")
            ).click();

            System.out.println("Login successful");


            // =====================================================
            // 3. VERIFY PRODUCTS / PLP PAGE
            // =====================================================

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.className("inventory_list")
            ));

            String pageTitle = driver.findElement(
                    By.className("title")
            ).getText();

            System.out.println("Page: " + pageTitle);

            Assert.assertEquals(
                    pageTitle,
                    "Products"
            );

            System.out.println("Products page displayed");


            // =====================================================
            // 4. SELECT FIRST PRODUCT
            // =====================================================

            WebElement firstProduct = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath(
                                    "(//div[@class='inventory_item'])[1]"
                            )
                    )
            );

            // Get product name
            String productName = firstProduct.findElement(
                    By.className("inventory_item_name")
            ).getText();

            System.out.println(
                    "Selected Product: " + productName
            );


            // =====================================================
            // 5. GET PRODUCT PRICE
            // =====================================================

            String productPrice = firstProduct.findElement(
                    By.className("inventory_item_price")
            ).getText();

            System.out.println(
                    "Product Price: " + productPrice
            );


            // =====================================================
            // 6. CLICK ADD TO CART
            // =====================================================

            firstProduct.findElement(
                    By.tagName("button")
            ).click();

            System.out.println(
                    "Product added to cart"
            );


            // =====================================================
            // 7. VERIFY CART BADGE
            // =====================================================

            WebElement cartBadge = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.className("shopping_cart_badge")
                    )
            );

            String cartCount = cartBadge.getText();

            System.out.println(
                    "Cart Count: " + cartCount
            );

            Assert.assertEquals(
                    cartCount,
                    "1"
            );

            System.out.println(
                    "Cart count verified"
            );


            // =====================================================
            // 8. OPEN CART / BASKET
            // =====================================================

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.className("shopping_cart_link")
                    )
            ).click();

            System.out.println(
                    "Basket opened"
            );


            // =====================================================
            // 9. VERIFY CART PAGE
            // =====================================================

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.className("cart_list")
                    )
            );

            String cartPageTitle = driver.findElement(
                    By.className("title")
            ).getText();

            System.out.println(
                    "Cart Page: " + cartPageTitle
            );

            Assert.assertEquals(
                    cartPageTitle,
                    "Your Cart"
            );


            // =====================================================
            // 10. GET PRODUCT NAME FROM CART
            // =====================================================

            String basketProductName = driver.findElement(
                    By.className("inventory_item_name")
            ).getText();

            System.out.println(
                    "Product in Basket: "
                    + basketProductName
            );


            // =====================================================
            // 11. GET PRICE FROM CART
            // =====================================================

            String basketProductPrice = driver.findElement(
                    By.className("inventory_item_price")
            ).getText();

            System.out.println(
                    "Price in Basket: "
                    + basketProductPrice
            );


            // =====================================================
            // 12. VERIFY PRODUCT NAME
            // =====================================================

            Assert.assertEquals(
                    basketProductName,
                    productName,
                    "Product name is not matching"
            );

            System.out.println(
                    "Product name verified"
            );


            // =====================================================
            // 13. VERIFY PRICE
            // =====================================================

            Assert.assertEquals(
                    basketProductPrice,
                    productPrice,
                    "Product price is not matching"
            );

            System.out.println(
                    "Product price verified"
            );


            // =====================================================
            // 14. VERIFY QUANTITY
            // =====================================================

            String quantity = driver.findElement(
                    By.className("cart_quantity")
            ).getText();

            System.out.println(
                    "Quantity: " + quantity
            );

            Assert.assertEquals(
                    quantity,
                    "1",
                    "Quantity is not 1"
            );


            // =====================================================
            // FINAL RESULT
            // =====================================================

            System.out.println();
            System.out.println(
                    "======================================"
            );

            System.out.println(
                    "TEST PASSED"
            );

            System.out.println(
                    "Product: " + basketProductName
            );

            System.out.println(
                    "Price: " + basketProductPrice
            );

            System.out.println(
                    "Quantity: " + quantity
            );

            System.out.println(
                    "======================================"
            );


        } catch (Exception e) {

            System.out.println();
            System.out.println(
                    "======================================"
            );

            System.out.println(
                    "TEST FAILED"
            );

            System.out.println(
                    "Error: " + e.getMessage()
            );

            System.out.println(
                    "======================================"
            );

            e.printStackTrace();

        } finally {

            //driver.quit();
        }
    }
}