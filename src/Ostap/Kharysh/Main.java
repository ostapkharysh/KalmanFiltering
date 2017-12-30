package Ostap.Kharysh;

import KalmanFilter.Kalman;
import readFromFile.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ReadFile data = new ReadFile();
        data.data =  data.processLogFile();
        //System.out.println(data.data);
//        for (int i=0; i< data.data.size()-1; i++){
//            System.out.println(data.data);
//        }

        data.setAccelerometerData(data.data);
        System.out.println(data.getAccelerometerData().size());
        data.toMySting(data.getAccelerometerData());
        System.out.println(data.getAccelerometerData().get(0)[1]);
        for(int i = 0; i<data.getAccelerometerData().size();i++){
            Kalman Kfilter = new Kalman( data.getAccelerometerData().get(i)[0], data.getAccelerometerData().get(i)[1],
                    data.getAccelerometerData().get(i)[2], data.getAccelerometerData().get(i)[3],
                    data.getAccelerometerData().get(i)[4], data.getAccelerometerData().get(i)[5]);
            System.out.println("DATA");
            //Kfilter.toMySting(Kalman.getACData());
            Kfilter.CalculateMean(Kalman.getACData(), 0);
        }




    }





    }