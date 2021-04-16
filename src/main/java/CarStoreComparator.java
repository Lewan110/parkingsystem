import java.util.Comparator;

public class CarStoreComparator implements Comparator<CarStore> {

    @Override
    public int compare(CarStore o1, CarStore o2) {
        return Integer.compare(o1.getCarType().getSize(), o2.getCarType().getSize());
    }
}
