import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
색뿐만 아니라 무게도 파라미터화 한다.
 */
public class filter {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(180 , Color.GREEN) ,
                new Apple(150 , Color.RED)
        );

        List<Apple> greenApples = filter(inventory , new AppleGreenColor() ); // 초록색을 판별해주는 오버라이딩 메서드 객체를 호출한다.
        System.out.println(greenApples);

        List<Apple> heavyApples = filter(inventory , new AppleWeightPredicate() ); // 무게가 큰지 판별해주는 오버라이딩 메서드 객체를 호출한다.
        System.out.println(heavyApples);
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

    public interface ApplePredicate { // 선택조건을 결정하는 인터페이스를 선언한다.
        boolean test (Apple apple);
    }

    public static class AppleWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) { // 인터페이스의 test 메서드를 오버라이딩 한다.
            return apple.getWeight()>150; // 무게가 150g 이상일때 True 를 반환한다.
        }
    }

    public static class AppleGreenColor implements ApplePredicate {
        @Override
        public boolean test(Apple apple) { // 인터페이스의 test 메서드를 오버라이딩 한다.
            return apple.getColor() == Color.GREEN; // 색깔이 초록색일때 True 를 반환한다.
        }
    }
}


