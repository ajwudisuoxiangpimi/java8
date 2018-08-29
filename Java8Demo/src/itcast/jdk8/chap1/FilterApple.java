package itcast.jdk8.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilterApple {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> appleList = filterApples(inventory,FilterApple::isGreenApple);
        System.out.println(appleList);

        List<Apple> appleList1 = filterApples(inventory,FilterApple::isHeavyApple);
        System.out.println(appleList1);

        List<Apple> appleList2 = filterApples(inventory,(Apple apple) -> "green".equals(apple.getColour()));
        System.out.println(appleList2);

        List<Apple> appleList3 = filterApples(inventory,(Apple apple) -> apple.getWeight() > 150);
        System.out.println(appleList3);

        List<Apple> appleList4 = filterApples(inventory,(Apple apple) -> apple.getWeight() > 80 || "brown".equals(apple.getColour()));
        System.out.println(appleList4);

        List<Apple> appleList5 = filter(inventory,new ApplePredicate(){

            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColour());
            }
        });

        System.out.println(appleList5);
    }

    public static List<Apple> filterGreenApple(List<Apple> inventory){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple:inventory) {
            if("green".equals(apple.getColour())){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApple(List<Apple> inventory){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple:inventory) {
            if(apple.getWeight() > 150){
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColour());
    }

    public  static  boolean isHeavyApple(Apple apple){
       return apple.getWeight() > 150;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public interface ApplePredicate{
        boolean test(Apple apple);
    }

    static  class AppleWeightPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    public static  class AppleColourPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColour());
        }
    }

    public static class AppleColourAndWeightPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColour()) || apple.getWeight() > 150;
        }
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
}
