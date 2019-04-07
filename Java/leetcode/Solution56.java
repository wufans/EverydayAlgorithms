/**
 * @Author: WuFan
 * @Date: 2019/4/7 10:02
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.*/
public class Solution56 {
    public static void main(String[] args) {

    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals,(Interval i1,Interval i2)->i1.start-i2.start);
        List<Interval> res = new ArrayList<>();
        Interval temp = new Interval(Integer.MIN_VALUE,-1);
        for(Interval i:intervals){
            if(temp.start == Integer.MIN_VALUE){
                temp = i;
            }else if(i.start<=temp.end){
                temp.end = Math.max(i.end,temp.end);
            }else{
                res.add(temp);
                temp = i;
            }
        }
        if(temp.start!=Integer.MIN_VALUE)
            res.add(temp);
        return res;
    }

    private class Interval{
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    //best solutions
    public List<Interval> merge2(List<Interval> intervals) {

        if(intervals.size() == 0){
            return intervals;
        }
        List<Interval>newList = new ArrayList<>();
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        for(int i = 0; i < intervals.size(); i++){
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        for(int i = 0, j = 0; i < intervals.size(); i++) { // j is start of interval.
            if (i == intervals.size()-1 || start[i + 1] > end[i]) {
                newList.add(new Interval(start[j], end[i]));
                j = i + 1;
            }
        }
        return newList;
    }
}
