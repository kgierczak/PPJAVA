Prosta aplikacja konsolowa napisana w języku Java, realizująca generator instancji oraz algorytm rozwiązujący **nieograniczony problem plecakowy** za pomocą podejścia zachłannego (greedy algorithm). Projekt został zbudowany w oparciu o narzędzie Maven.

## Funkcjonalności

* **Generator instancji:** Automatyczne losowanie zadanej liczby przedmiotów (waga i wartość) na podstawie zadanego ziarna (seed) oraz określonego przedziału wartości.
* **Algorytm zachłanny:** Rozwiązywanie problemu poprzez sortowanie przedmiotów według stosunku ich wartości do wagi (opłacalności) i umieszczanie ich w plecaku aż do wyczerpania pojemności.
* **Testy jednostkowe:** Wbudowane testy weryfikujące poprawność logiki przy użyciu biblioteki JUnit 5.

## Struktura projektu

Projekt znajduje się w paczce `org.example` i składa się z następujących klas:

* `Item` - reprezentuje pojedynczy przedmiot (posiada id, wagę i wartość).
* `Problem` - odpowiada za generowanie listy przedmiotów oraz zawiera metodę `Solve`, realizującą algorytm zachłanny.
* `Result` - przechowuje i formatuje wynik działania algorytmu (wybrane przedmioty, łączna waga, łączna wartość).
* `Main` - punkt wejścia do aplikacji; definiuje parametry początkowe i wyświetla wyniki w konsoli.
* `ProblemTest` - klasa testowa (w folderze `src/test/java`) sprawdzająca poprawność działania aplikacji.

### Uruchomienie aplikacji:
1. Przejdź do pliku `src/main/java/org/example/Main.java`.
2. Kliknij zieloną strzałkę obok metody `main`, aby uruchomić aplikację.
### Uruchomienie testów jednostkowych:
1. Przejdź do pliku `src/test/java/org/example/ProblemTest.java`.
2. Kliknij zieloną strzałkę obok nazwy klasy `ProblemTest`, aby uruchomić wszystkie testy.