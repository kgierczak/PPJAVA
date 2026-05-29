package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private List<Item> chosenItems;
    private int totalValue;
    private int totalWeight;

    public Result() {
        this.chosenItems = new ArrayList<>();
        this.totalValue = 0;
        this.totalWeight = 0;
    }

    public void addItem(Item item) {
        this.chosenItems.add(item);
        this.totalValue += item.getValue();
        this.totalWeight += item.getWeight();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Item item : chosenItems) {
            sb.append("No: ").append(item.getId()).append(" ").append(item.toString()).append("\n");
        }
        sb.append("Waga: ").append(totalWeight).append("\n");
        sb.append("Wartość: ").append(totalValue).append("\n");
        return sb.toString();
    }

    public List<Item> getChosenItems() {
        return chosenItems;
    }

    public int getTotalValue() {
        return totalValue;
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}