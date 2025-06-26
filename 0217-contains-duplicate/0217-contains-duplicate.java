import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create an empty "bag" (HashSet) for the numbers we've already seen
        Set<Integer> seenNumbers = new HashSet<>();

        // Go through each number in the array
        for (int num : nums) {
            // Ask: "Is this number already in our 'bag'?"
            if (seenNumbers.contains(num)) {
                // \U0001f973 Yay! We found a duplicate! Return true (yes, there's a duplicate)
                return true;
            }

            // If the number wasn't there yet, add it to our "bag"
            seenNumbers.add(num);
        }

        // \U0001f625 Oh no, we went through the whole array and didn't find any duplicates. Return false (no, there are no duplicates)
        return false;
    }
}