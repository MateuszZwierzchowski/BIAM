package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.example.CreateGraph.calculatePathLength;

public class ImprovedNearestNeighbor {

    private static List<Integer> nearestNeighborPath(Double[][] distanceMatrix) {
        int numberOfCities = distanceMatrix.length;
        boolean[] visited = new boolean[numberOfCities];
        List<Integer> path = new ArrayList<>();
        Random rand = new Random();
        int currentCity = rand.nextInt(distanceMatrix.length);
        path.add(currentCity);
        visited[currentCity] = true;

        for (int i = 1; i < numberOfCities; i++) {
            double minDistance = Double.MAX_VALUE;
            int nearestCity = -1;
            for (int j = 0; j < numberOfCities; j++) {
                if (!visited[j] && distanceMatrix[currentCity][j] < minDistance) {
                    minDistance = distanceMatrix[currentCity][j];
                    nearestCity = j;
                }
            }
            path.add(nearestCity);
            visited[nearestCity] = true;
            currentCity = nearestCity;
        }
        return path;
    }

    private static boolean apply2Opt(List<Integer> path, Double[][] distanceMatrix) {
        boolean improved = false;
        for (int i = 0; i < path.size() - 3; i++) {
            for (int j = i + 2; j < path.size() - 1; j++) {
                double beforeSwap = distanceMatrix[path.get(i)][path.get(i + 1)] + distanceMatrix[path.get(j)][path.get(j + 1)];
                double afterSwap = distanceMatrix[path.get(i)][path.get(j)] + distanceMatrix[path.get(i + 1)][path.get(j + 1)];
                if (afterSwap < beforeSwap) {
                    Collections.reverse(path.subList(i + 1, j + 1));
                    improved = true;
                }
            }
        }
        return improved;
    }

    public static double calcImprovedNN(Double[][] distanceMatrix) {
        List<Integer> path = nearestNeighborPath(distanceMatrix);
        boolean improved;
        do {
            improved = apply2Opt(path, distanceMatrix);
        } while (improved);

        return calculatePathLength(path, distanceMatrix);
    }
}
