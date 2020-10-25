package dataStructure.array;

public class FirstBadVersion {
    private boolean isBadVersion(int n) {
        //Implementation details not provided. Dummy return to avoid compilation error
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
