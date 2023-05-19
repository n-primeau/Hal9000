package com.planner;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LifeSupportPlanner {
    public List<Map<String, Double>> trip(List<Map<String, Double>> items, List<Map<String, Integer>> crew) {
        List<Map<String, Double>> resources_required = new ArrayList<>();
        crew.forEach(System.out::println);

        String[] resources = new String[]{"water", "food", "oxygen"};

        for(int i=0; i < items.size(); i+=1) {
            Map<String, Double> it = items.get(i);
            for(int c=0; c < crew.size(); c+=1) {
                Map<String, Integer> cr = crew.get(c);
                for(int n=0; n < resources.length; n += 1) {
                    String resource = resources[n];
                    if (cr.containsKey(resource)
                            && cr.get(resource) <= it.getOrDefault(resource, 0.0)
                            && !resources_required.contains(it)) {
                        resources_required.add(it);
                        cr.remove(resource);
                    }

                }
            }
        }

        for(int i=0; i<crew.size(); i+=1) {
            Map<String, Integer> c = crew.get(i);
            if(c.containsKey("water") || c.containsKey("oxygen") || c.containsKey("food")) {
                throw new RuntimeException("not enough resources!");
            }
        }
        
        System.out.println(resources_required);
        return resources_required;

    }
}