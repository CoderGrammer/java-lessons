package com.lessons.misc;

class Test {
    public static void main(String[] args) {
        System.out.println(Vehicle.BOAT.canCarry(20));
        System.out.println(Vehicle.CAR.canCarry(1));
        System.out.println(Vehicle.AIRPLANE.canCarry(99));
    }
}

interface CanCarryPassengers {
    int getNumberOfPassengers();
    boolean canCarry(int numberOfPassengers);
}

public enum Vehicle implements CanCarryPassengers {
    CAR {
        @Override
        public int getNumberOfPassengers() {
            return 4;
        }
    },
    BOAT {
        @Override
        public int getNumberOfPassengers() {
            return 10;
        }
    },
    AIRPLANE {
        @Override
        public int getNumberOfPassengers() {
            return 100;
        }
    };

    @Override
    public boolean canCarry(int numberOfPassengers) {
        return getNumberOfPassengers() >= numberOfPassengers;
    }

}
