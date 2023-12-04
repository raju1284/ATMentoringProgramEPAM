  Feature: Dashboard API Tests
    @Test1
    Scenario Outline: Positive Test - Add Dashboard using API post request
      When User creates the dashboard with  given dashboard name "<dashboardName>" and description "<dashboardDesc>" under the Project "<projectName>"
      Then User receives "<statusCode>" status code
      Examples:
      |dashboardName|dashboardDesc|projectName|statusCode|
      |apiTest8     |Test8        |Nagaraju_Dasari_Personal|201|

    @Test2
    Scenario Outline: Negative Test- Add existing Dashboard using API post request
      When User creates the dashboard with  given dashboard name "<dashboardName>" and description "<dashboardDesc>" under the Project "<projectName>"
      Then User receives "<statusCode>" status code
      And User validates the error code "<errorCode>" and message "<message>"

      Examples:
        |dashboardName|dashboardDesc|projectName|statusCode|errorCode|message|
        |apiTest6     |Test6        |Nagaraju_Dasari_Personal|409|4091|Resource 'apiTest6' already exists. You couldn't create the duplicate.|

    @Test3
    Scenario Outline: Negative Test- Add Dashboard in another project using API post request
      When User creates the dashboard with  given dashboard name "<dashboardName>" and description "<dashboardDesc>" under the Project "<projectName>"
      Then User receives "<statusCode>" status code
      And User validates the error code "<errorCode>" and message "<message>"

      Examples:
        |dashboardName|dashboardDesc|projectName|statusCode|errorCode|message|
        |apiTest6     |Test6        |Nagaraju_Dasari|403|4003|You do not have enough permissions. Access is denied|

    @Test4
    Scenario Outline: Positive Test-Get a Dashboard using API Get request
      When User gets the dashboard with given dashboard Id "<dashboardId>"  under the Project "<projectName>"
      Then User receives "<statusCode>" status code
      And User validates the response name "<name>" and description "<description>"
      Examples:
        |dashboardId|projectName|statusCode|name|description|
        |141909     |Nagaraju_Dasari_Personal|200|apiTest6|Test6|

    @Test5
    Scenario Outline: Negative Test-Get a non existing Dashboard using API Get request
      When User gets the dashboard with given dashboard Id "<dashboardId>"  under the Project "<projectName>"
      Then User receives "<statusCode>" status code
      And User validates the error code "<errorCode>" and message "<message>"
      Examples:
        |dashboardId|projectName|statusCode|errorCode|message|
        |14191     |Nagaraju_Dasari_Personal|404|40422|Dashboard with ID '14191' not found on project 'nagaraju_dasari_personal'. Did you use correct Dashboard ID?|

    @Test6
    Scenario Outline: Positive Test-Delete a Dashboard using API Delete request
      When User deletes the dashboard with given dashboard Id "<dashboardId>"  under the Project "<projectName>"
      Then User receives "<statusCode>" status code

    Examples:
        |dashboardId|projectName|statusCode|
        |141909     |Nagaraju_Dasari_Personal|200|

    @Test7
    Scenario Outline: Negative Test-Delete a non existing Dashboard using API Get request
      When User deletes the dashboard with given dashboard Id "<dashboardId>"  under the Project "<projectName>"
      Then User receives "<statusCode>" status code
      And User validates the error code "<errorCode>" and message "<message>"
      Examples:
        |dashboardId|projectName|statusCode|errorCode|message|
        |14191     |Nagaraju_Dasari_Personal|404|40422|Dashboard with ID '14191' not found on project 'nagaraju_dasari_personal'. Did you use correct Dashboard ID?|

    @Test8
    Scenario Outline: Positive Test - Add widget to the Dashboard using API put request
      When User adds the widget to the dashboardId "<dashboardId>" under the Project "<projectName>" with widget name "<widgetName>" Id "<widgetId>" and type "<widgetType>"
      Then User receives "<statusCode>" status code
      Examples:
        |dashboardId|projectName|statusCode|widgetName|widgetId|widgetType|
        |141906     |Nagaraju_Dasari_Personal|200|Widget1|129984|statisticTrend|

    @Test9
    Scenario Outline: Negative Test - Add widget to the non Dashboard using API put request
      When User adds the widget to the dashboardId "<dashboardId>" under the Project "<projectName>" with widget name "<widgetName>" Id "<widgetId>" and type "<widgetType>"
      Then User receives "<statusCode>" status code
      And User validates the error code "<errorCode>" and message "<message>"

      Examples:
        |dashboardId|projectName|statusCode|widgetName|widgetId|widgetType|errorCode|message|
        |141905     |Nagaraju_Dasari_Personal|404|Widget1|142130|statisticTrend|40422|Dashboard with ID '141905' not found on project 'nagaraju_dasari_personal'. Did you use correct Dashboard ID?|

    @Test10
    Scenario Outline: Positive Test - Delete widget  using API delete request
      When User deletes the widget in the dashboardId "<dashboardId>" under the Project "<projectName>" with widget Id "<widgetId>"
      Then User receives "<statusCode>" status code
      Examples:
        |dashboardId|projectName|statusCode|widgetId|
        |141906     |Nagaraju_Dasari_Personal|200|129984|
