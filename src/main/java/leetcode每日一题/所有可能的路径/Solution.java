package leetcode每日一题.所有可能的路径;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *
 * @author chenjiehao
 * @create 2021-08-25
 */
public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<List<Integer>> deque = new LinkedList<>();
        List<Integer> init = new ArrayList<>();
        init.add(0);
        deque.offerLast(init);
        int n = graph.length - 1;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                List<Integer> list = deque.pollFirst();
                Integer k = list.get(list.size() - 1);
                int[] nexts = graph[k];
                for (int j = 0; j < nexts.length; j++) {
                    int next = nexts[j];
                    List<Integer> nextProcess = new ArrayList<>();
                    nextProcess.addAll(list);
                    nextProcess.add(next);
                    if (next == n){
                        res.add(nextProcess);
                    }else {
                        deque.offerLast(nextProcess);
                    }
                }
            }
        }
        return res;
    }
}
