

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Use sorting
 */
public class MergeIntervals {

    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<Interval>();

        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        Interval interval = null;
        for (Interval other : intervals) {
            if (interval == null || other.start > interval.end) {
                interval = new Interval(other.start, other.end);
                merged.add(interval);
            } else if (other.end > interval.end) {
                interval.end = other.end;
            }
        }

        return merged;
    }
}

class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}