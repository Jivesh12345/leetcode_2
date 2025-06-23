class Solution {
    public String getPermutation(int n, int k) {
        // List of numbers to build the permutation from
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        // Precompute factorials up to (n - 1)!
        int[] fac = new int[n];
        fac[0] = 1;
        for (int i = 1; i < n; i++) {
            fac[i] = i * fac[i - 1];
        }

        // StringBuilder to store the resulting permutation
        StringBuilder sb = new StringBuilder();

        // Convert k to 0-based index
        k = k - 1;

        // Build the permutation one digit at a time
        for (int i = n; i >= 1; i--) {
            int bs = fac[i - 1];       // Number of permutations in each block
            int in = k / bs;           // Index of current digit in the list
            sb.append(nums.get(in));   // Append the digit at the index
            nums.remove(in);           // Remove the used digit from list
            k %= bs;                   // Reduce k for the next iteration
        }

        // Return the final permutation as a string
        return sb.toString();
    }
}