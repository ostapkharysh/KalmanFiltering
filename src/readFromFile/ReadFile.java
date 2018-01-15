package readFromFile;

import java.io.*;
import java.util.ArrayList;

public class ReadFile {
    public ArrayList<int[]> data;
    public ArrayList<int[]> microcontrollerData = new ArrayList<>();


    public ArrayList<int[]> processLogFile() {
        ArrayList<int[]> readings = new ArrayList();
        System.out.println("process Log File");
        try{
            FileInputStream fstream = new FileInputStream("C:\\Users\\Ostap Kharysh\\Documents\\BambergWS1718\\SME\\KalmanFiltering\\src\\Ostap\\Kharysh\\Capture11-01-18.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

   /* read log line by line */
            while ((strLine= br.readLine()) != null){
     /* parse strLine to obtain what you want */
                String[] ReadingsList = strLine.split(",");
                //System.out.println (strLine);
                if (strLine.equals("")){
                    //System.out.println("Empty");
                }

                else if  (ReadingsList[0].equals("$GPRMC"))  {
                    //System.out.println("$GPRMC");
                }else{
                    ReadingsList[0] = ReadingsList[0].replace("#IMU:","");
                    ReadingsList[ReadingsList.length-1] = ReadingsList[ReadingsList.length-1].replace(").","");
                    int[] output = new int[12];
                    for (int i =0; i< ReadingsList.length; i++) {
                        output[i] = Integer.parseInt(ReadingsList[i]);
                }
                    //System.out.println("BULO");
                    readings.add(output);
                }

            }
            fstream.close();

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return readings;
    }

    public ArrayList<int[]> getMicrocontrollerData() {


        return microcontrollerData;
    }

    public void setMicrocontrollerData(ArrayList<int[]> inputData) {

        for (int i=0; i < inputData.size(); i++){
            int[] lst = new int[7]; // 3 if include z
            lst[0] = inputData.get(i)[0];  //  [1]
            lst[1] = inputData.get(i)[1];  //  [2]
            lst[2] = inputData.get(i)[2]; // [3] If include Z
            lst[3] = inputData.get(i)[3]; // [5]
            lst[4] = inputData.get(i)[4]; //  [6]
            lst[5] = inputData.get(i)[5];  // [7]
            lst[6] = inputData.get(i)[8];  //  compass Z
            this.microcontrollerData.add(i, lst);
        }
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
}
