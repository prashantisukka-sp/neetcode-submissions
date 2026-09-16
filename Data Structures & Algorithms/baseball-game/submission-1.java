class Solution {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList();
        int finalScore = 0;
        for (String s: operations) {
            int sz = list.size();
            Integer i;
            switch(s) {
                case "+": 
                    i = list.get(sz - 1) + list.get(sz - 2);
                    list.add(i);
                    break;
                case "D":
                    i = 2 * list.get(sz - 1);
                    list.add(i);
                    break;
                case "C":
                    i = -list.get(sz - 1);
                    list.remove(sz - 1);
                    break;
                default:
                    i = Integer.parseInt(s);
                    list.add(i);
                    break;
            }
            finalScore += i;
        }
        return finalScore;
    }
}