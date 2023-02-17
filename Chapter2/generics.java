import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
지네릭스와 람다를 통해서 리스트 형식으로 추상화한다.
 */
public class generics {
    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple(180 , Color.GREEN) ,
                new Apple(150 , Color.RED)
        );

        List<Number> numbers = Arrays.asList(
                new Number(10) ,
                new Number(12)
        );

        List<Integer> interger_numbers = Arrays.asList(10,11,12);


        List<Apple> redapple = filter(inventory , (Apple a) -> Color.RED.equals(a.getColor()));
        // 타입을 Apple 로 선언하고 빨간색 사과를 람다식을 통해 가져온다.
        System.out.println(redapple);

        List<Number> evenNumbers = filter(numbers , (Number i) -> i.getNumber()% 2==0);
        // 타입을 Number 로 선언하고 클래스를 정의한뒤 짝수인 값을 람다식을 통해 가져온다
        System.out.println(evenNumbers);

        List<Integer> oddNumbers = filter(interger_numbers , (Integer i) -> i%2==1);
        // 타입을 정수로 선언하고 홀수인 값을 람다식을 통해 가져온다.
        System.out.println(oddNumbers);


    }

    enum Color { RED , GREEN };

    public static <T> List<T> filter(List<T> list , Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e:list) {
            if (p.test(e)) {
                result.add(e);
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

    public static class Number {
        private int integer = 0;

        private Number(int integer) {
            this.integer = integer;
        }

        public int getNumber() {
            return integer;
        }
    }

    public interface Predicate<T> { // 지네릭스 사용
        boolean test(T t);
    }
}
