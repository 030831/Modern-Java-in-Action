import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
색뿐만 아니라 무게도 파라미터화 한다.
 */
public class FilterApplesWeight {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(180 , Color.GREEN) ,
                new Apple(150 , Color.RED)
        );

        List<Apple> greenApples = filterApplesWeight(inventory , 150);
        System.out.println(greenApples);
    }


    public static List<Apple> filterApplesWeight(List<Apple> inventory , int weight) {
        List<Apple> result = new ArrayList<>(); // 사과누적 리스트
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) { // weight 변수보다 무거운 사과를 선택한다.
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
        private int weight;

        public Apple(int weight , Color color) {
            this.weight = weight;
            this.color = color;
        }
        public Color getColor() {
            return color;
        }
        public int getWeight() {
            return weight;
        }
    }
}
