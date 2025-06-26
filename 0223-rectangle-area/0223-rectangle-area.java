class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2,
                           int bx1, int by1, int bx2, int by2) {
        
        int blueArea = (ax2 - ax1) * (ay2 - ay1);
        int redArea =  (bx2 - bx1) * (by2 - by1);

        int topRightY = Math.min(ay2, by2);
        int topRightX = Math.min(ax2, bx2);
        int bottomLeftX = Math.max(ax1, bx1);
        int bottomLeftY = Math.max(ay1, by1);

        int overlappingWidth = Math.max(0, topRightX - bottomLeftX);
        int overlappingHeight = Math.max(0, topRightY - bottomLeftY);
        int overlappingArea = overlappingWidth * overlappingHeight;
        
        int totalArea = blueArea + redArea - overlappingArea;

        return totalArea;
    }
}