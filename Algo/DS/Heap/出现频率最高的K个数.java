// lc347
// On+klogn, On，从数组建堆复杂度On，最后选前k个是klogn，但是常数很大，比第二个的Onlogk还慢
class Pair implements Comparable<Pair> {
    int num, count;

    public Pair(int num, int count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Pair o) {
        return -this.count + o.count;
    }
}

public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> occurrences = new HashMap<>();
    for (int num : nums) {
        occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
    }

    List<Pair> values = new ArrayList<>();
    occurrences.forEach((num, count) -> {
        values.add(new Pair(num, count));
    });
    // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
    PriorityQueue<Pair> queue = new PriorityQueue<>(values);
    int[] result = new int[k];
    for (int i = 0; i < k; ++i) {
        result[i] = queue.poll().num;
    }
    return result;
}

// Onlogk，On
public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
    for (int num : nums) {
        occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
    }

    // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
    PriorityQueue<int[]> queue = new PriorityQueue<int[]>((m, n) -> m[1] - n[1]);
    occurrences.forEach((num, count) -> {
        if (queue.size() == k) {
            if (queue.peek()[1] >= count) {
                continue;
            }
            queue.poll();
            queue.offer(new int[]{num, count});
        } else {
            queue.offer(new int[]{num, count});
        }
    });
    int[] result = new int[k];
    for (int i = 0; i < k; ++i) {
        result[i] = queue.poll()[0];
    }
    return result;
}
