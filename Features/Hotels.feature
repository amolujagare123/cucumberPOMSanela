# new feature
# Tags: optional

Feature: Hotels.com website testing

# 1
  @starVerify
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select property class <stars>
    Then I verify system displays only <stars> hotels on search result
    Examples:
      | stars   |
      | 5 stars |
      | 4 stars |
      | 3 stars |

#2
 @verifyHotelName
  Scenario: verify "The Orchid Hotel" is within radius
   Given I am on default locations search result screen
    And I verify "The Orchid Hotel" is within radius
  @verifydistance
  Scenario: List of all of hotel within 35 km radius of airport or downtown // zip code 08837
    Given I am on default locations search result screen
    Then I verify system displays all hotels within "35" Km radius of airport

#3
  @dealPrice
  Scenario: Verify todays deal price value
    Given I am on default locations search result screen
    Then I verify todays deal is less than "10000" rs

#4
  @roomcount
  Scenario Outline: Verify room count dropdown
    Given I am on hotels.com home page
    When I select <select_rooms> from room dropdown
    Then I verify <number_of_room_dropdown> is displayed
    Examples:
      |select_rooms            | number_of_room_dropdown |
      | 1                      | 1                       |
      | 2                      | 2                       |

