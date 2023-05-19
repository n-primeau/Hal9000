package com.planner;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class LifeSupportPlannerTest {
    @Test
    public void test1() {
        LifeSupportPlanner planner = new LifeSupportPlanner();

        List<Map<String, Integer>> crew = Arrays.asList(
                new HashMap<>(Map.of(
                        "food", 5,
                        "water", 2,
                        "oxygen", 10
                )),
                new HashMap<>(Map.of(
                        "food", 6,
                        "water", 3,
                        "oxygen", 10
                )),
                new HashMap<>(Map.of(
                        "food", 2,
                        "water", 1,
                        "oxygen", 10
                ))
        );
        List<Map<String, Double>> items = Arrays.asList(
                Map.of(
                      "food", 6.0,
                      "water", 2.0,
                      "weight", 4.0
                ),
                Map.of(
                        "food", 8.0,
                        "weight", 3.0
                ),
                Map.of(
                        "food", 8.0,
                        "weight", 2.0
                ),
                Map.of(
                        "food", 2.0,
                        "weight", 0.5
                ),
                Map.of(
                        "water", 2.0,
                        "weight", 1.0
                ),
                Map.of(
                        "water", 3.0,
                        "weight", 2.0
                ),
                Map.of(
                        "water", 4.0,
                        "weight", 3.0
                ),
                Map.of(
                        "water", 5.0,
                        "weight", 4.0
                ),
                Map.of(
                        "oxygen", 10.0,
                        "weight", 2.0
                ),
                Map.of(
                        "oxygen", 10.0,
                        "weight", 4.0
                ),
                Map.of(
                        "oxygen", 10.0,
                        "weight", 3.0
                )
        );

        List<Map<String, Double>> requiredItems = planner.trip(items, crew);
        Double weight = requiredItems.stream().mapToDouble(i -> i.get("weight")).sum();
        assertEquals(weight, 21.5);

    }

}