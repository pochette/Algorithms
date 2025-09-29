package HashMapsExercises;

import java.util.*;

public class AutoStore {
    public static void main(String[] args) {
        Map<Car, Integer> cars = new TreeMap<>(new CarComparator());

        cars.put(new Car("Audi A6", 3700000), 2);
        cars.put(new Car("Bonds GAP", 1500000), 3);
        cars.put(new Car("KIA Cerato", 1300000), 0);
        cars.put(new Car("Volkswagen Tiguan", 1375000), 5);

        for (Car car : cars.keySet()) {
            System.out.println(car);
        }

    }

    static class Car {
        String model;
        Integer priceInRubles;

        public Car(String model, Integer priceInRubles) {
            this.model = model;
            this.priceInRubles = priceInRubles;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Car car = (Car) o;
            return model.equals(car.model);
        }

        @Override
        public int hashCode() {
            return model.hashCode();
        }

        @Override
        public String toString() {
            return "Car{" +
                    "model='" + model + '\'' +
                    ", priceInRubles=" + priceInRubles +
                    '}';
        }


    }
    private static class CarComparator implements Comparator<Car> {

        @Override
        public int compare(Car o1, Car o2) {
            return Integer.compare(o1.priceInRubles, o2.priceInRubles);
        }
    }

}
