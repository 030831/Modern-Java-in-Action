import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
익명클래스를 사용한다.
 */
public class Anonymous_Class {
    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(180 , Color.GREEN) ,
                new Apple(150 , Color.RED)
        );

        List<Apple> redApples = filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor() == Color.RED;
            }
        });

        System.out.println(redApples);
    }



    enum Color {
        RED , GREEN
    }

    public static List<Apple> filter(List<Apple> inventory , ApplePredicate p) {
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

    public interface ApplePredicate { // 선택조건을 결정하는 인터페이스를 선언한다.
        boolean test (Apple apple);
    }
}


