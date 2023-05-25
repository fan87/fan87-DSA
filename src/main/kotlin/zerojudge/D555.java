package zerojudge;

import java.util.*;

public class D555 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = 0;
        while (scanner.hasNext()) {
            testCase++;
            List<int[]> points = new ArrayList<>();
            int pointsLength = scanner.nextInt();
            for (int i = 0; i < pointsLength; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                points.add(new int[] { x, y });
            }

            points = unDominatedPoints(points);
            System.out.println("Case " + testCase + ":");
            System.out.println("Dominate Point: " + points.size());
            for (int[] point : points) {
                System.out.println("(" + point[0] + "," + point[1] + ")");
            }
        }
    }

    public static List<int[]> unDominatedPoints(List<int[]> inputs) {
        List<int[]> out = new ArrayList<>();
        inputs.sort(Comparator.comparing(it -> it[0]));
        int maximumY = -1;
        for (int i = inputs.size() - 1; i >= 0; i--) {
            int x = inputs.get(i)[0];
            int y = inputs.get(i)[1];
            if (!out.isEmpty()) {
                int previousX = out.get(out.size() - 1)[0];
                int previousY = out.get(out.size() - 1)[1];
                if (previousX == x) {
                    if (y > previousY) {
                        maximumY = y;
                        out.remove(out.size() - 1);
                        out.add(new int[] { x, y });
                        continue;
                    }
                }
            }
            if (y > maximumY) {
                maximumY = y;
                out.add(new int[] { x, y });
            }

        }
        Collections.reverse(out);
        return out;
    }

}
