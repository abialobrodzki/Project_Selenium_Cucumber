@Main01
Feature: Add new user address.

  Scenario Outline: User adds new address to the account.
    # logowanie na stworzonego użytkownika
    Given I'm on main page.
    When I go to login page.
    And I login using "private4@gmail.com" and "private4".
    # wejście w kafelek Addresses po zalogowaniu
    And I go to my "Addresses" page url: "https://mystore-testlab.coderslab.pl/index.php?controller=addresses".
#
#    #- kliknie w + Create new address,
#    Then I can create new address.
#    When I create new address.
#
#      #- wypełni formularz New address -
#      # dane z tabeli Examples (alias, address, city, zip/postal code, country, phone),
#    And I enter new data address data: <alias>, <address>, <city>, <zip/postal code>, <country>, <phone>.
#
#    #- sprawdzi, czy dane w dodanym adresie są poprawne.
#    Then I can see my new address.
#
#      #- usunie powyższy adres klikając w "delete",
#    When I delete new address.
#
#      #- sprawdzi, czy adres został usunięty.
#    Then I can't see deleted address.
#
#    And I close browser.
    Examples:
      | alias | address     | city     | zip/postal code | country | phone     |
      | Boss  | Nowogrodzka | Warszawa | 12-007          | Polska  | 123456789 |