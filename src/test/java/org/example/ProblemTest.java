package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProblemTest {

    // 1. Sprawdzenie, czy jeśli co najmniej jeden przedmiot spełnia ograniczenia,to zwrócono co najmniej jeden element.
    @Test
    public void testAtLeastOneItemFits() {
        Problem problem = new Problem(5, 1, 1, 10);

        Result result = problem.Solve(15);

        assertFalse(result.getChosenItems().isEmpty(), "Rozwiązanie powinno zawierać co najmniej jeden element.");
    }

    // 2. Sprawdzenie, czy jeśli żaden przedmiot nie spełnia ograniczeń,to zwrócono puste rozwiązanie.
    @Test
    public void testNoItemFits() {
        Problem problem = new Problem(5, 1, 5, 10);

        Result result = problem.Solve(0);

        assertTrue(result.getChosenItems().isEmpty(), "Rozwiązanie powinno być puste.");
        assertEquals(0, result.getTotalValue(), "Suma wartości powinna wynosić 0.");
        assertEquals(0, result.getTotalWeight(), "Suma wag powinna wynosić 0.");
    }

    // 3. Sprawdzenie, czy waga i wartość wszystkich przedmiotów z listy mieści się w założonym przedziale.
    @Test
    public void testItemsWithinBounds() {
        int lowerBound = 1;
        int upperBound = 10;
        Problem problem = new Problem(100, 123, lowerBound, upperBound);

        for (Item item : problem.getItems()) {
            assertTrue(item.getWeight() >= lowerBound && item.getWeight() <= upperBound,
                    "Waga przedmiotu " + item.getWeight() + " jest poza przedziałem!");
            assertTrue(item.getValue() >= lowerBound && item.getValue() <= upperBound,
                    "Wartość przedmiotu " + item.getValue() + " jest poza przedziałem!");
        }
    }

    // 4. Sprawdzenie poprawności wyniku (sumy wag i wartości w plecaku) dla konkretnej instancji.
    @Test
    public void testSpecificInstanceCorrectness() {
        int capacity = 15;
        Problem problem = new Problem(10, 1, 1, 10);
        Result result = problem.Solve(capacity);

        int calculatedWeight = 0;
        int calculatedValue = 0;

        for (Item item : result.getChosenItems()) {
            calculatedWeight += item.getWeight();
            calculatedValue += item.getValue();
        }

        assertEquals(calculatedWeight, result.getTotalWeight(), "Całkowita waga się nie zgadza z sumą przedmiotów.");
        assertEquals(calculatedValue, result.getTotalValue(), "Całkowita wartość się nie zgadza z sumą przedmiotów.");

        assertTrue(result.getTotalWeight() <= capacity, "Waga przedmiotów przekroczyła pojemność plecaka!");
    }
}