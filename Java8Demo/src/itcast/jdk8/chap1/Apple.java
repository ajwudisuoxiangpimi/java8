package itcast.jdk8.chap1;

public class Apple {
    private int weight = 0;
    private String colour;

    public int getWeight() {
        return weight;
    }

    

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Apple(int weight) {
        this.weight = weight;
    }

    public Apple(String colour) {
        this.colour = colour;
    }

    public Apple(int weight, String colour) {
        this.weight = weight;
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", colour='" + colour + '\'' +
                '}';
    }
}
