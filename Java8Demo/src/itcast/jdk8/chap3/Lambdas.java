package itcast.jdk8.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambdas {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("hello");
        r.run();

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));
        List<Apple> greenApples = filter(inventory,(Apple apple) -> "green".equals(apple.getColor()));
        System.out.println(greenApples);

        Comparator<Apple> c = (Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        inventory.sort(c);
        System.out.println(inventory);
    }

    public static List<Apple> filter(List<Apple> inventory,ApplePredicate p){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple:inventory) {
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple{
        private Integer weight = 0;
        private String color;

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Apple(Integer weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }

    interface ApplePredicate{
        public boolean test(Apple apple);
    }


}
