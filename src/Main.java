import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<Figure> input = buildTestData(15,
                List.of("red", "blue", "green"),
                List.of("squad", "circle", "triangle"));

        System.out.println("Input is: " + input);

        Map<String, TreeSet<Figure>> result = new HashMap<>();
        Map<String, Figure> maxLightened = new HashMap<>();

        for (Figure figure : input) {
            if (figure.isLightened()) {
                maxLightened.putIfAbsent(figure.getKey(), figure);

                Figure lightenedFigure = maxLightened.get(figure.getKey());
                if (lightenedFigure.getWeight() < figure.getWeight()) {
                    lightenedFigure.setLightened(false);
                    maxLightened.put(figure.getKey(), figure);
                } else if (lightenedFigure.getWeight() > figure.getWeight()) {
                    figure.setLightened(false);
                }
            }

            result.putIfAbsent(figure.getKey(), new TreeSet<>(Comparator.comparingInt(Figure::getWeight)));
            result.get(figure.getKey()).add(figure);
        }

        System.out.println("Result is: " + result);
    }


    public static List<Figure> buildTestData(int number, List<String> shapes, List<String> colors) {
        List<Figure> result = new ArrayList<>();
        Random random = new Random();
        for (var i = 0; i < number; i++) {
            Figure figure = new Figure();
            figure.setColor(colors.get(Math.abs(random.nextInt() % colors.size())));
            figure.setShape(shapes.get(Math.abs(random.nextInt() % shapes.size())));
            figure.setWeight(random.nextInt(10));
            figure.setLightened(random.nextBoolean());

            result.add(figure);
        }

        Collections.shuffle(result);
        return result;
    }
}