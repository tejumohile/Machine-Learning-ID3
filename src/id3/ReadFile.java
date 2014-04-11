/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id3;

import java.io.*;
import java.util.*;
/**
 *
 * @author Tejashree
 */
public class ReadFile {
    
    public List<ArrayList> readDataSetFile(String fileName) {
    
        try {           
            
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = null;
            String firstLine[] = br.readLine().split(" ");
            int rows = Integer.parseInt(firstLine[0]);
            int columns = Integer.parseInt(firstLine[1]);
            List <ArrayList> dataset = new ArrayList<ArrayList>();
            for(int i =0 ; i < rows ; i++) {
                // for rest of the lines
                line = br.readLine();
                String lineSplit[] = line.split(" ");
                ArrayList<Integer> split = new ArrayList<Integer>();
                for(int j =0; j < columns ; j++) {
                     split.add(Integer.parseInt(lineSplit[j]));
                }                
                dataset.add(split);
            }
            return dataset;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<Partition> readPartitionFile(String fileName) {
    
        List<Partition> partitionList = new ArrayList<Partition>();
        try {           
            
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = null;            
            while ( (line = br.readLine() )!= null ){
                String partition[] = line.split(" ");
                String partitionName = partition[0];
                List<Integer> list = new ArrayList<Integer>();
                for(int i = 1 ; i < partition.length; i++){
                    list.add(Integer.parseInt(partition[i]));
                }
                partitionList.add(new Partition(partitionName, list));
            }            
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
        finally {
            return partitionList;
        }
        
    }
    
    
    
    
}
