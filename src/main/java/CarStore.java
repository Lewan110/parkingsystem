import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
class CarStore {
    private final CarType carType;
    private final int maxNumberOfCars;
    private int currentNumberOfCars;

    boolean isParkingSlotAvailable() {
        return currentNumberOfCars < maxNumberOfCars;
    }

    void addCar() throws Exception {
        if (currentNumberOfCars >= maxNumberOfCars) {
            throw new Exception("Cannot add another car");
        }
        currentNumberOfCars++;
    }

    void releaseCar() throws Exception {
        if (currentNumberOfCars == 0) {
            throw new Exception("There is no car to release");
        }
        currentNumberOfCars--;
    }
}
