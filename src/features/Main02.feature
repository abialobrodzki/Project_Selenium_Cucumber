@Main02
Feature: Add new order.

  @NewOrder
  Scenario: User adds a new order to the account.
    # logowanie na stworzonego użytkownika
    Given I'm on main page - order.
#    When I go to login page.
#    And I login using "private4@gmail.com" and "private4".

  # wybierze do zakupu Hummingbird Printed Sweater
    # (opcja dodatkowa: sprawdzi czy rabat na niego wynosi 20%),
  # wybierze rozmiar M
    # (opcja dodatkowa: zrób tak żeby można było sparametryzować rozmiar i wybrać S,M,L,XL),
  # wybierze 5 sztuk według parametru podanego w teście
    # (opcja dodatkowa: zrób tak żeby można było sparametryzować liczbę sztuk),
  # dodaj produkt do koszyka,
  # przejdzie do opcji - checkout,
  # potwierdzi address (możesz go dodać wcześniej ręcznie),
  # wybierze metodę odbioru - PrestaShop "pick up in store",
  # wybierze opcję płatności - Pay by Check,
  # kliknie na "order with an obligation to pay",
  # zrobi screenshot z potwierdzeniem zamówienia i kwotą.

 # Wejdź w historię zamówień i detale (najpierw kliknij w użytkownika zalogowanego, później kafelek),
 # sprawdź, czy zamówienie znajduje się na liście ze statusem "Awaiting check payment" i kwotą taką samą jak na zamówieniu dwa kroki wcześniej.
