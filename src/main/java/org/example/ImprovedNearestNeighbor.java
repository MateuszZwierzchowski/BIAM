package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.example.CreateGraph.calculatePathLength;

public class RandomEdge {
    public static double calcRandomEdge(Double[][] distanceMatrix) {
        Random rand = new Random();
        int numberOfCities = distanceMatrix.length;
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[numberOfCities];

        // Start od losowego miasta
        int currentCity = rand.nextInt(numberOfCities);
        path.add(currentCity);
        visited[currentCity] = true;

        // Główna pętla - dodawaj krawędzie do niewykorzystanych miast
        while (path.size() < numberOfCities) {
            List<Integer> potentialNextCities = new ArrayList<>();
            for (int i = 0; i < numberOfCities; i++) {
                if (!visited[i]) {
                    potentialNextCities.add(i);
                }
            }
            int nextCityIndex = rand.nextInt(potentialNextCities.size());
            int nextCity = potentialNextCities.get(nextCityIndex);
            path.add(nextCity);
            visited[nextCity] = true;
        }

        return calculatePathLength(path, distanceMatrix);
    }
}

