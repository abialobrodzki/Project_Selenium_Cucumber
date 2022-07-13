@Main02
Feature: Add new order.

  @NewOrder
  Scenario: User adds a new order to the account.
    # logowanie na stworzonego użytkownika
    Given I'm on main page - order.
    When I go to login page - order.
    And I login using "private4@gmail.com" and "private4" - order.
    Then I can see my "My account" page: "https://mystore-testlab.coderslab.pl/index.php?controller=my-account".
    # przejście do sklepu
    When I go to shop.
    # wybranie do zakupu Hummingbird Printed Sweater
    And I select Hummingbird Printed Sweater.
    # opcja dodatkowa: sprawdzenie czy rabat wynosi 20%
    And I see discount 20%.
    # wybranie rozmiar M
      # opcja dodatkowa: sparametryzowanie rozmiaru i wybranie: S,M,L,XL
    And I select "M" size.
    # wybranie 5 sztuk według parametru podanego w teście
      # opcja dodatkowa: sparametryzowanie liczby sztuk
    And I select "5" pieces.

  # dodaj produkt do koszyka,
  # przejdzie do opcji - checkout,
  # potwierdzi address (możesz go dodać wcześniej ręcznie),
  # wybierze metodę odbioru - PrestaShop "pick up in store",
  # wybierze opcję płatności - Pay by Check,
  # kliknie na "order with an obligation to pay",
  # zrobi screenshot z potwierdzeniem zamówienia i kwotą.

 # Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
 # sprawdź, czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.
