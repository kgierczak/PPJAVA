package org.example;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        int seed = 1;
        int lowerBound = 1;
        int upperBound = 10;
        int capacity = 15;

        Problem problem = new Problem(n, seed, lowerBound, upperBound);

        System.out.println("\n" + "Liczba przedmiotów: " + n);
        System.out.println("Ziarno losowania: " + seed);
        System.out.println("Pojemność plecaka: " + capacity + "\n");

        System.out.println("Wygenerowane przedmioty:");
        System.out.println(problem.toString());

        System.out.println("Wynik działania algorytmu:");
        Result result = problem.Solve(capacity);
        System.out.println(result.toString());
    }
}