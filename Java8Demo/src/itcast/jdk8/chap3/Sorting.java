package itcast.jdk8.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Sorting {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<Apple>();
        inventory.addAll(Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red")));
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        inventory.set(1,new Apple(30,"red"));
        System.out.println(inventory);

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        System.out.println(inventory);

        inventory.set(1,new Apple(20,"green"));
        inventory.sort((a1,a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);
        inventory.set(1,new Apple(10,"black"));

        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);

    }

    static public class Apple{
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

        public Apple(String color) {
            this.color = color;
        }

        public Apple(Integer weight) {

            this.weight = weight;
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
    static class AppleComparator implements Comparator<Apple>{

        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }
}
