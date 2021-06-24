import java.util.Objects;

public class Point {
    public int x;
    public int y;
    public Point(int xloc,int yloc){
        x=xloc;
        y=yloc;
    }
//hashmap的key为对象时需要重写对象的equals和hashcode两个方法，因为查找key时先调用hashcode后调用equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
