class Solution {
    int spColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        spColor = image[sr][sc];
        fill(image, sr, sc, color);
        return image;
    }
    void fill(int[][] filledImage, int sr, int sc, int color) {
        int r = filledImage.length, c = filledImage[0].length;
        if (sr >= r || sr < 0 || sc < 0 || sc >= c || filledImage[sr][sc] == color || filledImage[sr][sc] != spColor) {
            return;
        } else {
            filledImage[sr][sc] = color;
        }
        fill(filledImage, sr + 1, sc, color);
        fill(filledImage, sr - 1, sc, color);
        fill(filledImage, sr, sc + 1, color);
        fill(filledImage, sr, sc - 1, color);
    }
}