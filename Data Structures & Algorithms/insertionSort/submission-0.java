// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        if (pairs.size() == 0) {
            return new ArrayList();
        }
        List<List<Pair>> results = new ArrayList();
        results.add(copyList(pairs));
        for (int i = 1; i < pairs.size(); i++) {
            int j = i - 1;
            while (j >= 0 && pairs.get(j).key > pairs.get(j+1).key) {
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j+1));
                pairs.set(j + 1, temp);
                j--; 
            }
            results.add(copyList(pairs));
        }
        return results;
    }
    List<Pair> copyList(List<Pair> pairs) {
        return new ArrayList(pairs);
    }
}
