package pe.edu.cibertec.ejercicioclases;

import android.util.Log;

public class Vehicle {
    private int wheels;

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public Vehicle(int wheels) {
        this.wheels = wheels;
    }

    public void printWheels() {
        Log.d("Ejercicio02", "El vehículo tiene " + getWheels());
    }

    public Vehicle() {
    }
}
