/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insertinterval;
import java.util.*;
/**Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.
 *Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * @author Xi Yu
 */
public class InsertInterval {
    static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    
    
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){ //添加所有小于newInterval范围的组合
            result.add(intervals.get(i++));
        }                                                                   //此时由于上一个循环完毕，所以intervals.get(i).end >= newInterval.start
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){ //用new.end>intervals.get(i).start 确保new.end在interval内，有重合
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }
        result.add(newInterval);    //当new.end也小于intervals.get(i).start时，表示new会小于所有intervals后的范围，因此加入new，然后循环加入所有后续的intervals
        while(i<intervals.size()){
            result.add(intervals.get(i++));
        }
        return result;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InsertInterval test = new InsertInterval();
        Interval newInterval = new Interval(2,3);
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1,5));
        ArrayList<Interval> result = test.insert(intervals, newInterval);
        System.out.printf("%d%d",result.get(0).start,result.get(0).end);
    }
    
}
