class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
        return false;
        }

        return canMap(s, t) && canMap(t, s);
    }

    public boolean canMap(String s, String t) {

        int len = s.length();

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                return false;
                }
            } else {
                map.put(c1, c2);
            }
        }

        return true;
    }    
}