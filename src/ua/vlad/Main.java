package ua.vlad;

public class Main {

    public static void main(String[] args) {
//        Power power = new Power();
//        power.on();
//
//        DVDRom dvd = new DVDRom();
//        dvd.load();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvd);

        Facad computer = new Facad();
        computer.copy();
    }
}

class Facad {
    // В отличии от делеагата здесь несколько класов (екземпляров)
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    // Также можем определить последовательность вызовов
    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() {
        System.out.println("ON Power!");
    }

    void off() {
        System.out.println("OFF Power!");
    }
}

class DVDRom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }
    void load() {
        data = true;
    }
    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if(dvd.hasData()) {
            System.out.println("Copy data...");
        } else {
            System.out.println("Input disk with data!");
        }
    }
}