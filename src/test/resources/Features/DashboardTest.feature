Feature: Dashboard Test Feature

  Background: User is logged In
    Given User login the report portal with valid username "raju1284" and password "Devraj@1284"
   @Test1
  Scenario Outline: Add Dashboard to the report portal
    When User creates the dashboard with  given dashboard name "<dashboardName>" and description "<dashboardDesc>"
    Then Verify the dashboard "<dashboardName>" added successfully
    When User adds the widget to the dashboard with name: "<dashboardName>" widgetName: "<widgetName>" widgetDesc: "<widgetDesc>" and filter: "<filter>"
    Then Verify the widget "<widgetName>" added to the dashboard successfully

    Examples:
      |dashboardName |dashboardDesc   |widgetName |widgetDesc   |filter|
      |DashboardT1 |Test1DB|WidgetT1 |Test1|Test-cases growth trend chart|
      |DashboardT2|Test2DB|WidgetT2|Test2|Launch statistics chart|

  @Test2
  Scenario Outline: Delete the Dashboard
    When User deletes the dashboard "<dashName>"
    Then Verify the dashboard "<dashName>" deleted successfully

    Examples:
      |dashName|
      |DashboardT1 |
      |DashboardT2|