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
public class Entropy {

    public float getEntropy(float num1, float num2) {
        if(num1 == 0 || num2 == 0)
            return 0;
        float sum = (num1 + num2);

        float entropy = num1 * (float) Math.log((sum / num1))
                + num2 * (float) Math.log((sum / num2));
        entropy = entropy / ((float) Math.log(2) * sum);
        return entropy;

    }

    public void getEntropyOnAttributes(List<ArrayList> dataList,
            List<Partition> partition) {
        for (int i = 0; i < partition.size(); i++) {
            Partition p = partition.get(i);
            p.setProbOfInstances((float) p.size() / (float) dataList.size());
            //getting target entropy value of the partition
            System.out.println("partition.size() " + partition.size());
            System.out.println("Probability of Instances = " + p.getProbOfInstances());
            //for each column
            List<Float> entropyOfAttributePartition = new ArrayList<Float>();
            int zeroTargetCounter , oneTargetCounter , zeroAttributeTargetOne ;
                int zeroAttributeTargetZero = 0;
                int oneAttributeTargetOne = 0;
                int oneAttributeTargetZero = 0;
                int twoAttributeTargetOne = 0;
                int twoAttributeTargetZero = 0;
                int zeroAttributeCounter = 0;
                int oneAttributeCounter = 0;
                int twoAttributeCounter = 0;
            for (int k = 0; k < dataList.get(0).size() - 1; k++) {
                // for each column
                zeroTargetCounter = 0;
                oneTargetCounter = 0;
                zeroAttributeTargetOne = 0;
                zeroAttributeTargetZero = 0;
                oneAttributeTargetOne = 0;
                oneAttributeTargetZero = 0;
                twoAttributeTargetOne = 0;
                twoAttributeTargetZero = 0;
                zeroAttributeCounter = 0;
                oneAttributeCounter = 0;
                twoAttributeCounter = 0;
                for (int j = 0; j < p.size(); j++) {
                    int position = (p.getList().get(j) - 1);
                    //each element in the partition
//                    System.out.println("position of data in dataset = " + position);

                    int targetPosition = dataList.get(0).size() - 1;
//                    System.out.println("dataList.get(0).size() - 1 =" + targetPosition);
                    int target = (int) dataList.get(position).get(targetPosition);
//                    System.out.println("target " + target);
                    int attribute = (int) dataList.get(position).get(k);
//                    System.out.println("attribute = " + attribute);
                    if (target == 0) {
                        zeroTargetCounter++;
                        if (attribute == 0) {
                            zeroAttributeTargetZero++;
                            zeroAttributeCounter++;
                        } else if (attribute == 1) {
                            oneAttributeTargetZero++;
                            oneAttributeCounter++;
                        } else if (attribute == 2) {
                            twoAttributeTargetZero++;
                            twoAttributeCounter++;
                        }
                    } else if (target == 1) {
                        oneTargetCounter++;
                        if (attribute == 0) {
                            zeroAttributeTargetOne++;
                            zeroAttributeCounter++;
                        } else if (attribute == 1) {
                            oneAttributeTargetOne++;
                            oneAttributeCounter++;
                        } else if (attribute == 2) {
                            twoAttributeTargetOne++;
                            twoAttributeCounter++;
                        }

                    }
                }// end of for each elements in partition.

                p.setEntropyOfPartition(
                        new Entropy().getEntropy(zeroTargetCounter,
                                oneTargetCounter));
                //add the partion entropys conditional.
//                System.out.println("zeroTargetCounter =" + zeroTargetCounter
//                        + "oneTargetCounter =" + oneTargetCounter
//                        + "zeroAttributeTargetOne =" + zeroAttributeTargetOne
//                        + "zeroAttributeTargetZero =" + zeroAttributeTargetZero
//                        + "oneAttributeTargetOne =" + oneAttributeTargetOne
//                        + "oneAttributeTargetZero =" + oneAttributeTargetZero
//                        + "twoAttributeTargetOne =" + twoAttributeTargetOne
//                        + "twoAttributeTargetZero =" + twoAttributeTargetZero
//                        + "zeroAttributeCounter =" + zeroAttributeCounter
//                        + "oneAttributeCounter =" + oneAttributeCounter
//                        + "twoAttributeCounter =" + twoAttributeCounter);
                float entropyZeroAttribute = new Entropy().getEntropy(zeroAttributeTargetZero, zeroAttributeTargetOne);
                float entropyOneAttribute = new Entropy().getEntropy(oneAttributeTargetZero, oneAttributeTargetOne);
                float entropyTwoAttribute = new Entropy().getEntropy(twoAttributeTargetZero, twoAttributeTargetOne);
//                System.out.println("entropyZeroAttribute = " + entropyZeroAttribute);
//                System.out.println("entropyOneAttribute = " + entropyOneAttribute);
//                System.out.println("entropyTwoAttribute = " + entropyTwoAttribute);
                float answer = ((float) zeroAttributeCounter * entropyZeroAttribute)
                        + ((float) oneAttributeCounter * entropyOneAttribute)
                        + (((float) twoAttributeCounter) * entropyTwoAttribute);
                answer = answer / (float)partition.size();
                System.out.println("Answer is " + k + " " + answer);
                entropyOfAttributePartition.add(k, answer);

            }//end of for each column
            p.setEntropyOfPartitionAndAttribute(entropyOfAttributePartition);
        }
    }

    public void main(String[] args) {
        System.out.println(getEntropy(6, 3));
    }

}
