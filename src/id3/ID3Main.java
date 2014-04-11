/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id3;
import java.util.*;
/**
 *
 * @author Tejashree
 */
public class ID3Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ReadFile reader = new ReadFile();
        List data =reader.readDataSetFile("E:\\Machine Learning\\Project 1 ID3\\ID3\\src\\id3\\dataset-1.txt");
        for ( int i = 0 ; i < data.size(); i++ ){
            ArrayList dataPartition = (ArrayList) data.get(i);
            for(int j = 0 ; j < dataPartition.size(); j++){
                System.out.print(dataPartition.get(j));
            }
            System.out.println();
        }
        
        List <Partition> partitionList = reader.readPartitionFile("E:\\Machine Learning\\Project 1 ID3\\ID3\\src\\id3\\partition-1.txt");
        for(int i = 0 ; i < partitionList.size(); i++){
            System.out.println(((Partition)partitionList.get(i)).toString());
        }        
        new Entropy().getEntropyOnAttributes(data, partitionList);
        for(int i = 0 ; i < partitionList.size(); i++){
            System.out.println("Gain = " + i + " :" + partitionList.get(i).getMaxGain());
        }
        
    }
    
}
