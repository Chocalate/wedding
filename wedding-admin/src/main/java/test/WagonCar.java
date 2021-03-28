package test;

import java.math.BigDecimal;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-25 16:19
 **/

public class WagonCar extends Car{
    public WagonCar() {
    }

    @Override
    public Double depreciation() {
        double price =  super.getPrice();
        return 0.1*price;
    }




    @Override
    public int compare(Object o1, Object o2) {
            Double n1 = (Double) o1;
            Double n2 = (Double) o2;
            int lastCmp = n1.compareTo(n2);
            return lastCmp != 0 ? lastCmp :
                    n1.compareTo(n2);
        }

}
