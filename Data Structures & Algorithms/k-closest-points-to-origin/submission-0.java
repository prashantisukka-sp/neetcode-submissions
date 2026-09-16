class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Double, String> map = new TreeMap();
        int[][] results = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            int[] arr = points[i];
            double distance = Math.abs(Math.sqrt((arr[0] * arr[0]) + (arr[1] * arr[1])));
            String value;
            if (map.containsKey(distance)) {
                value = map.get(distance) + ":" + String.valueOf(i);
            } else {
                value = String.valueOf(i);
            }
            map.put(distance, value);
        }  
        Iterator<Map.Entry<Double, String>> iterator = map.entrySet().iterator();
        int j = 0;
        for (int i = 0; i < k && iterator.hasNext(); i++) {
            Map.Entry<Double, String> entry = iterator.next();
            String[] values = entry.getValue().split(":");
            for (String s: values) {
                if (j < k) {
                    results[j++] = points[Integer.parseInt(s)];
                }
            }
        }
        return results;
    }
}
