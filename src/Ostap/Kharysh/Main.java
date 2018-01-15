package Ostap.Kharysh;

import KalmanFilter.Kalman;
import readFromFile.ReadFile;

public class Main {

    public static void main(String[] args) {
        ReadFile data = new ReadFile();
        data.data = data.processLogFile();
        //System.out.println(data.data);
        //for (int i=0; i< data.data.size()-1; i++){
            //System.out.println(data.data); }

        int deltaT = 1;
        int XGyroVariance = 100;
        data.setMicrocontrollerData(data.data);
        System.out.println(data.getMicrocontrollerData().size());
        data.toMySting(data.getMicrocontrollerData());
        System.out.println("HERE");
        //System.out.println(data.getMicrocontrollerData().get(0)[1]);
        for(int i = 0; i<data.getMicrocontrollerData().size();i++){
            Kalman Kfilter = new Kalman( data.getMicrocontrollerData().get(i)[0], data.getMicrocontrollerData().get(i)[1],
                    data.getMicrocontrollerData().get(i)[2], (int) (data.getMicrocontrollerData().get(i)[3]/14.375),
                    (int) (data.getMicrocontrollerData().get(i)[4]/14.375), (int)(data.getMicrocontrollerData().get(i)[5]/14.375),  data.getMicrocontrollerData().get(i)[6]);
            System.out.println("DATA");
            //Kfilter.toMySting(Kalman.getACData());;
            //System.out.println(" Acc X");
           //Kalman.setxACCMean(Kfilter.CalculateMean(Kalman.getACData(), 0)); //X
            //System.out.println(" Acc Z");
           //Kalman.setzACCMean(Kfilter.CalculateMean(Kalman.getACData(), 2)); // Z
            System.out.println(" Gyro X");
           Kalman.setxGYROMean(Kfilter.CalculateMean(Kalman.getGyroData(), 0)) ; // X
            System.out.println(" Gyro Y");
            Kalman.setyGYROMean(Kfilter.CalculateMean(Kalman.getGyroData(), 1)) ; // Y
            System.out.println(" Gyro Z");
            System.out.println(Kfilter.getGz());
            Kalman.setzGYROMean(Kfilter.CalculateMean(Kalman.getGyroData(), 2)) ; //Z

            System.out.println("GYRO Z:");
           // System.out.println(Kfilter.getAz());
           // System.out.println(Kalman.getzACCMean());
            System.out.println(Kfilter.CalculateVariance(Kalman.getGyroData(), 2, Kalman.getzGYROMean()));
            System.out.println(Kfilter.getGz());
            System.out.println(Kalman.getzGYROMean());
            System.out.println("INSHE");
            System.out.println(Kfilter.CalculateVariance2(Kfilter.getGx(), Kfilter.getGy(), Kfilter.getGz(),
                    Kalman.getxGYROMean(), Kalman.getyGYROMean(), Kalman.getzGYROMean()));
            System.out.println("COMP Z");
            System.out.println(Kfilter.getCompz());





           //Kfilter.CalculateMean(Kalman.getACData(), 1);
        }
        //intenzsense



    }





    }