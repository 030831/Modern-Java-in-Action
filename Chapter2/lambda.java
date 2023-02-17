import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate; // 람다를 사용하기 위해 Predicate 를 import 를 한다.
/*
람다를 사용한다.
 */
public class lambda {
    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple( 100 , Color.GREEN) ,
                new Apple( 180, Color.RED)
        );

        List<Apple> greenApples = filter(inventory, (Apple a) -> Color.GREEN.equals(a.getColor()));
        // 람다 표현식을 사용한다. 초록색인 사과를 한줄로 골라낸다.
        System.out.println(greenApples);

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return Integer.compare(a1.getWeight() , a2.getWeight());
            }
        });

        inventory.sort((Apple a1 , Apple a2) -> Integer.compare(a1.getWeight() , a2.getWeight()));

    }

    enum Color { RED , GREEN };

    public static List<Apple> filter(List<Apple> inventory , Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>(); // 사과누적 리스트
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
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
