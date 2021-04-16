
import lombok.val;

import java.util.Optional;
import java.util.PriorityQueue;

class ParkingSystem {
    private final PriorityQueue<CarStore> carStoreList = new PriorityQueue<>(new CarStoreComparator());

    public ParkingSystem(int big, int medium, int small) {
        carStoreList.add(new CarStore(CarType.BIG, big));
        carStoreList.add(new CarStore(CarType.MEDIUM, medium));
        carStoreList.add(new CarStore(CarType.SMALL, small));
    }

    public boolean addCar(int carType) throws Exception {
        val carStore = carStoreList.stream()
                .filter(cs -> cs.getCarType().getId() == carType)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Cannot find given car type"));

        if (carStore.isParkingSlotAvailable()) {
            carStore.addCar();
            return true;
        } else {
            Optional<CarStore> availableCarSlot = getNextAvailable(carStore);
            if (availableCarSlot.isPresent()) {
                availableCarSlot.get().addCar();
                return true;
            }
        }
        return false;
    }

    private Optional<CarStore> getNextAvailable(CarStore carStore) {
        return carStoreList.stream()
                .filter(cs -> cs.getCarType().getSize() >= carStore.getCarType().getSize() && cs.isParkingSlotAvailable())
                .findFirst();
    }
}

