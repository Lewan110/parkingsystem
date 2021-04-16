import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSystemTest {

    @Test
    public void test() throws Exception {
        //given
        ParkingSystem ps = new ParkingSystem(1, 2, 3);

        //when
        boolean result1 = ps.addCar(2);
        boolean result2 = ps.addCar(2);
        boolean result3 = ps.addCar(2);
        boolean result4 = ps.addCar(1);

        //then
        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
        assertFalse(result4);
    }

    @Test
    public void returns_false_when_empty_parking() throws Exception {
        //given
        ParkingSystem ps = new ParkingSystem(0, 0, 0);

        //when
        boolean result = ps.addCar(2);

        //then
        assertFalse(result);
    }

    @Test
    public void returns_false_when_no_available_parking_slot() throws Exception {
        //given
        ParkingSystem ps = new ParkingSystem(0, 5, 5);

        //when
        boolean result = ps.addCar(1);

        //then
        assertFalse(result);
    }

    @Test
    public void returns_true_when_only_bigger_parking_slots_are_available() throws Exception {
        //given
        ParkingSystem ps = new ParkingSystem(5, 0, 0);

        //when
        boolean result = ps.addCar(1);

        //then
        assertTrue(result);
    }
}