import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {

  public static double[] calcEquation(List<List<String>> equations,
      double[] values,
      List<List<String>> queries) {
    Map<String, Map<String, Double>> map = new HashMap<>();
    for (int i = 0; i < values.length; i++) {
      List<String> equation = equations.get(i);
      String start = equation.getFirst();
      String end = equation.get(1);

      map.computeIfAbsent(start, k -> new HashMap<>());
      map.get(start).put(end, values[i]);

      map.computeIfAbsent(end, k -> new HashMap<>());
      map.get(end).put(start, 1 / values[i]);

    }

    double[] result = new double[queries.size()];

    for (int i = 0; i < result.length; i++) {
      result[i] = calculate(new HashSet<>(), map, queries.get(i).get(0), queries.get(i).get(1));
    }
    return result;
  }

  public static double calculate(Set<String> visited, Map<String, Map<String, Double>> graph, String start,
      String end) {
    if (!graph.containsKey(start)) {
      return -1;
    }
    if (graph.get(start).containsKey(end)) {
      return graph.get(start).get(end);
    }
    visited.add(start);

    for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
      if (!visited.contains(neighbour.getKey())) {
        double productWeight = calculate(visited, graph, neighbour.getKey(), end);
        if (productWeight != -1) {
          return neighbour.getValue() * productWeight;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
    double[] values = {2.0, 3.0};
    List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"));
    System.out.println(Arrays.toString(calcEquation(equations, values, queries)));
  }
}
