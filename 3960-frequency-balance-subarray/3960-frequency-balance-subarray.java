class Solution {
    public int getLength(int[] nums) {
      int n = nums.length;
        int ans = 1;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> count = new HashMap<>();
            Map<Integer, Integer> freqCount = new HashMap<>();

            for (int j = i; j < n; j++) {
                int x = nums[j];

                int oldFreq = count.getOrDefault(x, 0);
                if (oldFreq > 0) {
                    int c = freqCount.get(oldFreq);
                    if (c == 1) {
                        freqCount.remove(oldFreq);
                    } else {
                        freqCount.put(oldFreq, c - 1);
                    }
                }

                int newFreq = oldFreq + 1;
                count.put(x, newFreq);
                freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);

                int distinct = count.size();

                boolean valid = false;

                if (distinct == 1) {
                    valid = true;
                } else if (freqCount.size() == 2) {
                    Iterator<Integer> it = freqCount.keySet().iterator();
                    int a = it.next();
                    int b = it.next();

                    int minFreq = Math.min(a, b);
                    int maxFreq = Math.max(a, b);

                    if (maxFreq == 2 * minFreq) {
                        valid = true;
                    }
                }

                if (valid) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}
