package KalmanFilter;

import java.util.ArrayList;

public class Kalman{

    public static ArrayList<int[]> ACData = new ArrayList<>();
    public static ArrayList<int[]> ACVarianceData = new ArrayList<>();

    public static ArrayList<int[]> GyroData = new ArrayList<>();

   static int Ax = 0;
   static int Ay = 0;
   static int Az =0;

    static int Gx = 0;
    static int Gy = 0;
    static int Gz = 0;

    int Compz=0;


   static int xACCMean = 0; //?
   static int zACCMean = 0; //?

    static int xGYROMean = 0; //?
    static int yGYROMean = 0; //?
    static int zGYROMean = 0; //?

    static int GyroVariance = 0;  // applies for calculating variance from GyroX,GyroY,GyroZ

    static int zGyroVariance = 0; //





    public Kalman(int Accx, int Accy, int Accz, int Gyrox, int Gyroy, int Gyroz, int Cmpz){

        ACData.add(new int[]{Ax, Ay, Az});
        GyroData.add(new int[]{Gx, Gy, Gz});

        Ax = Accx;
        Ay = Accy;
        Az = Accz;
        Gx = Gyrox;
        Gy = Gyroy;
        Gz = Gyroz;
        Compz = Cmpz;
    }

    public int CalculateMean(ArrayList<int[]> numbers, int index){
        int total = 0;
        for(int i =0; i<numbers.size(); i++){
            //System.out.println(":");
           // System.out.println(numbers.get(i)[index]);
            total+= numbers.get(i)[index];
            //System.out.println(total);
        }
        System.out.print("MEAN: ");
        System.out.println(total/ numbers.size());
        return  total/numbers.size();
    }

    public int CalculateVariance(ArrayList<int[]> numbers, int index, int meanValue){
        int total = 0;
        for(int i =0; i<numbers.size(); i++){
            total += Math.pow(numbers.get(i)[index]- meanValue, 2);
        }
        return (int) Math.sqrt(total);
    }

    public int CalculateVariance2(int x, int y, int z, int XMean, int YMean, int ZMean){
        //preconditions: Means of Gyro X, Gyroy, Gyroz are calculated;
        double total= Math.pow(x - XMean, 2) + Math.pow(y - YMean, 2) + Math.pow(z - ZMean, 2);
        return (int) Math.sqrt(total);
    }

    public void toMySting(ArrayList<int[]> A){
        for(int x = 0; x< A.size(); x++){
            for(int y=0; y< A.get(x).length;y++){
                if(y == A.get(x).length-1){
                    System.out.println(A.get(x)[y] + " ");
                }
                else{
                    System.out.print(A.get(x)[y] + " ") ;
                }

            }
        }
    }

    public void Filter(int LocalAngle, int GyroNewAxis, int GyroNewAxisVariance,
                       int AccNewAxis, int AccCalibrateAxis1, int AccCalibrateAxis2,  int deltaT) {
        //100 is an assumption of a default variance of any calculated angle
        //Prediction  Kalman.zGyroVariance


        int Lambda = LocalAngle+deltaT*GyroNewAxis; // predict new angle
        int GyroFilterAxesVariance = 100 + GyroNewAxisVariance*deltaT;      // predict variance

        //Update


        int CurrentMove = (int) Math.atan(GyroNewAxis/Math.sqrt(AccCalibrateAxis1*AccCalibrateAxis1+
                AccCalibrateAxis2*AccCalibrateAxis2));



    }


    public static ArrayList<int[]> getACData() {
        return ACData;
    }

    public static ArrayList<int[]> getGyroData() {
        return GyroData;
    }

    public int getAx() {
        return Ax;
    }

    public int getAy() {
        return Ay;
    }

    public int getAz() {
        return Az;
    }

    public int getGx() {
        return Gx;
    }

    public int getGy() {
        return Gy;
    }

    public int getGz() {
        return Gz;
    }

    public int getCompz() {
        return Compz;
    }

    public static void setACData(ArrayList<int[]> ACData) {
        Kalman.ACData = ACData;
    }

    public static int getxACCMean() {
        return xACCMean;
    }

    public static void setxACCMean(int xACCMean) {
        Kalman.xACCMean = xACCMean;
    }

    public static int getzACCMean() {
        return zACCMean;
    }

    public static void setzACCMean(int zACCMean) {
        Kalman.zACCMean = zACCMean;
    }

    public static int getxGYROMean() {
        return xGYROMean;
    }

    public static void setxGYROMean(int xGYROMean) {
        Kalman.xGYROMean = xGYROMean;
    }

    public static void setyGYROMean(int yGYROMean) {
        Kalman.yGYROMean = yGYROMean;
    }

    public static void setzGyroVariance(int zGyroVariance) {
        Kalman.zGyroVariance = zGyroVariance;
    }

    public static int getyGYROMean() {
        return yGYROMean;
    }

    public static int getzGyroVariance() {
        return zGyroVariance;
    }

    public static int getzGYROMean() {
        return zGYROMean;
    }

    public static void setzGYROMean(int zGYROMean) {
        Kalman.zGYROMean = zGYROMean;
    }


}
