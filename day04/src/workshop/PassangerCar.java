package workshop;

import workshop.exception.FuelException;
import workshop.exception.ZeroException;

public class PassangerCar {
    public void addFuel(double size) throws FuelException, ZeroException {
        if (size <= 0){
            throw new ZeroException("1L 이상부터 주유 가능합니다..!");
        }
        if (this.fuelSize < (this.currFuel + size)) {
            throw new FuelException("주유 가능량을 초과했습니다..!");
        }
        this.currFuel += size;
    }

}
