import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
녹색 사과를 필터링 하는 메서드를 정의한다.
 */
public class FilterGreenApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(Color.GREEN) ,
                new Apple(Color.RED)
        );

        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);
    }


    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>(); // 사과누적 리스트
        for (Apple apple : inventory) {
            if (apple.getColor() == Color.GREEN) { // 녹색 사과만 선택.
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
