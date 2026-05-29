package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {
    private int n;
    private int seed;
    private int lowerBound;
    private int upperBound;
    private List<Item> items;

    public Problem(int n, int seed, int lowerBound, int upperBound) {
        this.n = n;
        this.seed = seed;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.items = new ArrayList<>();

        Random random = new Random(seed);

        for (int i = 0; i < n; i++) {
            int weight = lowerBound + random.nextInt(upperBound - lowerBound + 1);
            int value = lowerBound + random.nextInt(upperBound - lowerBound + 1);
            items.add(new Item(i, value, weight));
        }
    }

    public Result Solve(int capacity) {
        Result result = new Result();

        List<Item> sortedItems = new ArrayList<>(items);

        sortedItems.sort((i1, i2) -> {
            double ratio1 = (double) i1.getValue() / i1.getWeight();
            double ratio2 = (double) i2.getValue() / i2.getWeight();
            return Double.compare(ratio2, ratio1);
        });

        int currentCapacity = capacity;

        for (Item item : sortedItems) {
            while (item.getWeight() <= currentCapacity) {
                result.addItem(item);
                currentCapacity -= item.getWeight();
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append("No: ").append(item.getId()).append(" ").append(item.toString()).append("\n");
        }
        return sb.toString();
    }

    public List<Item> getItems() {
        return items;
    }
}