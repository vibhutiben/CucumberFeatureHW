
  Feature: User should able to change currency successfully,so that he can use all user features from our website
    @tag2
    Scenario: User should able to change currency in euro
      When user select euro currency
      Then user able to see all products with euro price sucessfully