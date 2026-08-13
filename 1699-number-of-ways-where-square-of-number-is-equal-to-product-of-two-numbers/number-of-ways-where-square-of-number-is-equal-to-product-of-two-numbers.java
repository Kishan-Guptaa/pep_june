class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        return count(nums1, nums2) + count(nums2, nums1);
    }

    private int count(int[] nums1, int[] nums2) {

        int ans = 0;

        HashMap<Long, Integer> map = new HashMap<>();

        for (int num : nums2) {
            map.put((long) num,
                    map.getOrDefault((long) num, 0) + 1);
        }

        for (int num : nums1) {

            long target = (long) num * num;

            for (long x : map.keySet()) {

                if (target % x != 0) {
                    continue;
                }

                long y = target / x;

                if (!map.containsKey(y)) {
                    continue;
                }

                if (x > y) {
                    continue;
                }

                if (x == y) {
                    int freq = map.get(x);
                    ans += freq * (freq - 1) / 2;

                } else {
                    ans += map.get(x) * map.get(y);
                }
            }
        }

        return ans;
    }
}