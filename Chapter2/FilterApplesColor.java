import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
색을 파라미터화 한다.
 */
public class FilterApplesColor {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(Color.GREEN) ,
                new Apple(Color.RED)
        );

        List<Apple> greenApples = filterApplesColor(inventory , Color.GREEN);
        System.out.println(greenApples);
    }


    public static List<Apple> filterApplesColor(List<Apple> inventory , Color color) {
        List<Apple> result = new ArrayList<>(); // 사과누적 리스트
        for (Apple apple : inventory) {
            if (apple.getColor() == color) { // 녹색 사과만 선택.
                result.add(apple);
            }
        }

        return result;
    }

    enum Color {
        RED , GREEN
    }

    public static class Apple {
        private Color color;

        public Apple(Color color) {
            this.color = color;
        }
        public Color getColor() {
            return color;
        }
    }
}
