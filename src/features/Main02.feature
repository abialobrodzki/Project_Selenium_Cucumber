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
    # wybranie rozmiaru M
      # opcja dodatkowa: sparametryzowanie rozmiaru i wybranie: S,M,L,XL
    And I select "M" size.
    # wybranie 5 sztuk według parametru podanego w teście
      # opcja dodatkowa: sparametryzowanie liczby sztuk
    And I select "5" pieces.
    # dodanie produktu do koszyka
    Then I add item to cart.
    # przejście do opcji - checkout
    When I proceed to checkout.
    # potwierdzenie adresu, może zostać dodany wcześniej ręcznie
    And I confirm address.
    # wybranie metody odbioru - PrestaShop "Pick up in-store"
    And I select delivery - "Pick up in-store".
    # wybranie opcji płatności - "Pay by Check"
    And I select payment - "Pay by Check".
    # kliknięcie na "Order with an obligation to pay"
    And I click "Order with an obligation to pay".
    # screenshot z potwierdzeniem zamówienia i kwotą
    Then I make screenshot with confirm order and payment.
    # wejście w historię zamówień i detale (użytkownik -> kafelek)
    When I go to order history and details.
    # sprawdzenie zamówienie na liście i statusie "Awaiting check payment"
#    And I see order status: "Awaiting check payment".
    # porównanie kwoty zamówienia z kwotą na zamówieniu dwa kroki wcześniej.
#    Then I see correct price.
