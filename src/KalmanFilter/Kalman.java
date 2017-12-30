package KalmanFilter;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Kalman{

    public static ArrayList<int[]> ACData = new ArrayList<>();
    public static ArrayList<int[]> ACVarianceData = new ArrayList<>();

    public static ArrayList<int[]> GyroData = new ArrayList<>();

   static int Ax = 0;
   static int Ay = 0;
   static int Az =0;

   static int AxMean = 0; //?
   static int AyMean = 0; //?
   static int AzMean = 0; //?

    int Gx = 0;
    int Gy = 0;
    int Gz = 0;


    public Kalman(int Accx, int Accy, int Accz, int Gyrox, int Gyroy, int Gyroz){

        ACData.add(new int[]{Ax, Ay, Az});
        GyroData.add(new int[]{Gx, Gy, Gz});

        Ax = Accx;
        Ay = Accy;
        Az = Accz;
        Gx = Gyrox;
        Gy = Gyroy;
        Gz = Gyroz;
    }

    public int CalculateMean(ArrayList<int[]> numbers, int index){
        //System.out.println(IntStream.of(numbers).sum()/numbers.length);
        int total = 0;
        for(int i =0; i<numbers.size(); i++){
            //System.out.println(numbers.get(i)[index]);
            total+= numbers.get(i)[index];
            //System.out.println(total);
        }
        System.out.print("MEAN X: ");
        System.out.println(total/ numbers.size());
        return  total/numbers.size();
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
}
