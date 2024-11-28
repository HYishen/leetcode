package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    /**
     * 作者：力扣官方题解
     链接：https://leetcode.cn/problems/merge-intervals/solutions/203562/he-bing-qu-jian-by-leetcode-solution/
     来源：力扣（LeetCode）
     著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int[][] merge2(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        intervalList.sort((a, b) -> a.star < b.star ? -1 : a.star == b.star  ? 0 : 1);

        int star = intervalList.get(0).star;
        int end = intervalList.get(0).end;
        List<Interval> resList = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (end >= intervalList.get(i).star) {
                if (end <= intervalList.get(i).end) {
                    end = intervalList.get(i).end;
                }
            } else {
                resList.add(new Interval(star, end));
                star = intervalList.get(i).star;
                end = intervalList.get(i).end;
            }
        }

        if (resList.size() == 0) {
            resList.add(new Interval(star, end));
        } else if (resList.get(resList.size() - 1).star != star) {
            resList.add(new Interval(star, end));
        }

        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = resList.get(i).star;
            res[i][1] = resList.get(i).end;
        }

        return res;
    }

    class Interval {
        int star;
        int end;

        public Interval(int star, int end) {
            this.star = star;
            this.end = end;
        }

        public String toString() {
            return "["+ star + ", " + end + "]";
        }

    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,3},{8,10},{2,6},{15,18}};

        int[][] res = new MergeIntervals().merge(array);
        for (int i = 0; i < res.length; i++) {
            System.out.println("[" + res[i][0] + "," + res[i][1] + "]");
        }

        System.out.println("---------------------");

        array = new int[][]{{1,4},{4,10}};
        res = new MergeIntervals().merge(array);
        for (int i = 0; i < res.length; i++) {
            System.out.println("[" + res[i][0] + "," + res[i][1] + "]");
        }

    }

}
