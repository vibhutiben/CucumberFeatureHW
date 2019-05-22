
  Feature: User should able to register successfully,so that he can use all user features from our website
    @register
    Scenario:User should able to register
      Given user is on register page
      When user enters all registration details
      Then user should able to register successfully