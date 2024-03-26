package common;

import org.testng.log4testng.Logger;
import pages.HomePage;

public class PageFactory {

    static final Logger logger = Logger.getLogger(PageFactory.class);

    public static HomePage buildHomePage() {
        logger.info ("Page opening");
        return new HomePage("/inventory.html");
    }

}
