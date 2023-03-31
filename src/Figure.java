import java.util.Objects;

public class Figure {
    private String shape;
    private String color;
    private int weight;
    private boolean isLightened;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isLightened() {
        return isLightened;
    }

    public void setLightened(boolean lightened) {
        isLightened = lightened;
    }

    public String getKey() {
        return shape + "_" + color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return weight == figure.weight && isLightened == figure.isLightened && shape.equals(figure.shape) && color.equals(figure.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shape, color, weight, isLightened);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "shape='" + shape + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", isLightened=" + isLightened +
                '}';
    }
}
