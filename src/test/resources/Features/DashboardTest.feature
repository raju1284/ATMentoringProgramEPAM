Feature: Dashboard Test Feature

  Background: User is logged In
    Given User login the report portal
   @Test1
  Scenario Outline: Add Dashboard to the report portal
    When User clicks add dashboard button and enter the dashboard details "<dashboardName>" "<dashboardDesc>"
    Then User should be able to add dashboard successfully
    When User clicks edit dashboard button and add the widget details "<dashboardName>" "<widgetName>" "<widgetDesc>" "<filter>"
    Then User should be able to add widget to the dashboard successfully

    Examples:
      |dashboardName |dashboardDesc   |widgetName |widgetDesc   |filter|
      |DashboardT1 |Test1DB|WidgetT1 |Test1|Test-cases growth trend chart|
      |DashboardT2|Test2DB|WidgetT2|Test2|Launch statistics chart|

  @Test2
  Scenario Outline: Delete the Dashboard
    When User deletes the dashboard "<dashName>"
    Then User should be able to delete  the dashboard successfully

    Examples:
      |dashName|
      |DashboardT1 |
      |DashboardT2|