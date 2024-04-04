package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Greedy {

    public static double calcGreedy(Double[][] distanceMatrix) {
        Random rand = new Random();
        boolean[] visited = new boolean[distanceMatrix.length];
        Arrays.fill(visited, false);

        List<Integer> path = new ArrayList<>();
        int currentCity = rand.nextInt(distanceMatrix.length);
        visited[currentCity] = true;
        path.add(currentCity);

        while (path.size() < distanceMatrix.length) {
            int nextCity = findNextCity(distanceMatrix, visited, currentCity, rand);
            path.add(nextCity);
            visited[nextCity] = true;
            currentCity = nextCity;
        }

        return CreateGraph.calculatePathLength(path, distanceMatrix);
    }

    private static int findNextCity(Double[][] distanceMatrix, boolean[] visited, int currentCity, Random rand) {
        List<Integer> closestCities = new ArrayList<>();
        double minDistance = Double.MAX_VALUE;

        for (int i = 0; i < distanceMatrix.length; i++) {
            if (!visited[i] && distanceMatrix[currentCity][i] <= minDistance) {
                if (distanceMatrix[currentCity][i] < minDistance) {
                    closestCities.clear();
                    minDistance = distanceMatrix[currentCity][i];
                }
                closestCities.add(i);
            }
        }

        return closestCities.get(rand.nextInt(closestCities.size()));
    }
}
