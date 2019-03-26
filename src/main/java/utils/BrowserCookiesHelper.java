package utils;

import org.openqa.selenium.WebDriver;

public class BrowserCookiesHelper {

    /**
     * Returns True if the browser has a cookie with the specified name, False
     * otherwise
     *
     * @param driver     the WebDriver instance to search for the cookie with
     * @param cookieName the name of the cookie to search for
     * @return Returns True if the browser has a cookie with the specified name,
     *         False otherwise
     */
    public static boolean hasNamedCookie(WebDriver driver, String cookieName) {
        if (driver.manage().getCookieNamed(cookieName) == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Deletes a named cookie from the browser instance
     *
     * @param driver     the WebDriver instance to search for the cookie with
     * @param cookieName the name of the cookie to delete
     *
     */
    public static void deleteCookieByName(WebDriver driver, String cookieName) {
        driver.manage().deleteCookieNamed(cookieName);
    }

    /**
     *
     * @param driver     the WebDriver instance to search for the cookie with
     * @param cookieName the name of the cookie to retrieve the value for
     * @return the value of the named cookie
     * @throws RuntimeException if the browser does not have a the named cookie
     */
    public static String getCookieValue(WebDriver driver, String cookieName) {
        if (driver.manage().getCookieNamed(cookieName) != null) {
            return driver.manage().getCookieNamed(cookieName).getValue();
        } else {
            throw new RuntimeException(String.format("The browser does not have a cookie named '%s'", cookieName));
        }
    }
}

