/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gasstation;

/**
 *There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * @author Xi Yu
 */
public class GasStation {
     public int canCompleteCircuit(int[] gas, int[] cost) {  //若sum<0，表示当前i之前的所有站点都不能选择，因为无法达到当前位置
        int sum = 0;                                        //所以保存最后一个sum<0的位置，其后第一个肯定是环路起始位置
        int total = 0;
        int j = -1;
        for(int i = 0; i<gas.length; i++){
            
            
            sum = sum+gas[i]-cost[i];
            total = total+gas[i]-cost[i];
            if(sum<0){
                j=i;
                sum = 0;
            }
        }
        if(total<0) return -1;
        else return j+1;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
