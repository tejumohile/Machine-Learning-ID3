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
public class Partition {
    String partitionName ;
    List <Integer> list;
    float entropyOfPartition;
    List <Float> entropyOfPartitionAndAttribute;
    List <Float> gainOfPartitionAndAttribute;
    float F;
    float probOfInstances;
    public Partition (String partitionName, List<Integer> partitionList){
        
        this.partitionName = partitionName;
        this.list = partitionList;
        
    }

    public List<Integer> getList() {
        return list;
    }

    public float getEntropyOfPartition() {
        return entropyOfPartition;
    }

    public void setEntropyOfPartition(float entropyOfPartition) {
        this.entropyOfPartition = entropyOfPartition;
    }

    public List<Float> getEntropyOfPartitionAndAttribute() {
        return entropyOfPartitionAndAttribute;
    }

    public void setEntropyOfPartitionAndAttribute(List<Float> entropyOfPartitionAndAttribute) {
        this.entropyOfPartitionAndAttribute = entropyOfPartitionAndAttribute;
    }

    public List<Float> getGainOfPartitionAndAttribute() {
        return gainOfPartitionAndAttribute;
    }

    public void setGainOfPartitionAndAttribute(List<Float> gainOfPartitionAndAttribute) {
        this.gainOfPartitionAndAttribute = gainOfPartitionAndAttribute;
    }

    public float getF() {
        return F;
    }

    public void setF(float F) {
        this.F = F;
    }

    public float getProbOfInstances() {
        return probOfInstances;
    }

    public void setProbOfInstances(float probOfInstances) {
        this.probOfInstances = probOfInstances;
    }
    
    
    
    public String toString(){
        String answer = String.valueOf(partitionName) + " ";
        for(int i = 0; i < list.size() ; i++) {
            answer = answer + list.get(i).toString();
            if ( i != (list.size()-1)) {
                answer = answer + " ";
            }
        }
        return answer;
    
    }
    
    public int size(){
        return list.size();    
    }
    
    public float getMaxGain(){
        gainOfPartitionAndAttribute = new ArrayList<Float>();
        float maxGain = 0;
        for(int i = 0 ; i < entropyOfPartitionAndAttribute.size(); i++){
            maxGain = (maxGain < 
                    (entropyOfPartition-(float)entropyOfPartitionAndAttribute.get(i))?
                    (entropyOfPartition-(float)entropyOfPartitionAndAttribute.get(i)) :
                    maxGain);
            
        }
        return maxGain;
    }
}
