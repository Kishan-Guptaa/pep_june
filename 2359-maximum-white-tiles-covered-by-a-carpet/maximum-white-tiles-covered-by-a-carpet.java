import java.util.*;

class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {

        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);

        int left = 0;
        int right = 0;

        int covered = 0;
        int ans = 0;

        while (left < tiles.length) {

            int carpetEnd = tiles[left][0] + carpetLen - 1;
            while (right < tiles.length &&
                   tiles[right][1] <= carpetEnd) {

                covered += tiles[right][1] - tiles[right][0] + 1;
                right++;
            }
            int partial = 0;

            if (right < tiles.length &&
                tiles[right][0] <= carpetEnd) {

                partial = carpetEnd - tiles[right][0] + 1;
            }

            ans = Math.max(ans, covered + partial);
            covered -= tiles[left][1] - tiles[left][0] + 1;
            left++;
            if (right < left) {
                right = left;
            }
        }

        return ans;
    }
}