class Solution {
    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList();
        for (String s: operations) {
            int sz = list.size();
            switch(s) {
                case "+": 
                    list.add(list.get(sz - 1) + list.get(sz - 2));
                    break;
                case "D":
                    list.add(2 * list.get(sz - 1));
                    break;
                case "C":
                    list.remove(sz - 1);
                    break;
                default:
                    list.add(Integer.parseInt(s));
                    break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}