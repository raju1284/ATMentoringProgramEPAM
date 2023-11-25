package managers;

import com.ui.BasePage;
import com.ui.DashboardPage;
import com.ui.LoginReportPortalPage;
import com.ui.WidgetPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    public BasePage basePage;
    public LoginReportPortalPage loginReportPortalPage;
    public DashboardPage dashboardPage;
    public WidgetPage widgetPage;

    public PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }
    public BasePage getBasePage()
    {
        return  (basePage == null) ? basePage = new BasePage(driver) : basePage;

    }

    public LoginReportPortalPage getLoginReportPortalPage()
    {
        return  (loginReportPortalPage == null) ? loginReportPortalPage = new LoginReportPortalPage(driver) : loginReportPortalPage;

    }

    public DashboardPage getDashboardPage()
    {
        return  (dashboardPage == null) ? dashboardPage = new DashboardPage(driver) : dashboardPage;

    }

    public WidgetPage getWidgetPage()
    {
        return  (widgetPage == null) ? widgetPage = new WidgetPage(driver) : widgetPage;

    }


}
