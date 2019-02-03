package pe.edu.cibertec.ejercicioclases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Moto primeraMoto;

        primeraMoto = new Moto();

        primeraMoto.setWheels(2);

        primeraMoto.printWheels();

        Auto primerAuto;

        primerAuto = new Auto(4);

        primerAuto.printWheels();


        ArrayList<Vehicle> listVehicle;

        listVehicle = new ArrayList<>();

        listVehicle.add(primeraMoto);
        listVehicle.add(primerAuto);



    }
}
