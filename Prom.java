package xd;

import java.io.*;
import java.util.ArrayList;

public class Prom {
	
	public static final String delimiter = ",";							//El delimitador son las ","
	public static void read(String csvFile) {
		try {
			File file = new File (csvFile);
			 FileReader fr = new FileReader(file);
	         BufferedReader br = new BufferedReader(fr);
	         String line = "";											//Separa por espacios
	         String[] tempArr;
	         ArrayList<Float> PromTE = new ArrayList<Float>();
	         while((line = br.readLine()) != null) {					//Recorre por cada linea
	        	float PromEst=0;
	            tempArr = line.split(delimiter);
	            for(int i = 2 ; i<=5 ; i++) {							//A partir de la segunda columna va sumando el valor
	            	PromEst += Float.parseFloat(tempArr[i]);
	        	            }
	            PromEst /= 4;											
	            PromTE.add(PromEst);									//Guarda PromEst en el Array PromTE
	         System.out.println("Promedio por estudiante :"+ PromEst);  
	         }
	         
	         br.close();
	         float promedioTotal = 0;
	         for (float promedio : PromTE) {							
	        	 promedioTotal = promedioTotal + promedio;
	         }
	         promedioTotal = promedioTotal / PromTE.size();				//usa el tamaño del array para utilizar la cantidad de veces del PromTE dividir a cada promedio
	         System.out.println("Promedio del curso :" + promedioTotal);
	         
	         } catch(IOException ioe) {
	            ioe.printStackTrace();
	         }
	   }
	   public static void main(String[] args) {
	      // csv file to read
	      String csvFile = "C:\\Users\\user\\Desktop\\PromedioCSV.csv";	//Dirreccion
	      
	      Prom.read(csvFile);
	   }
	}

	