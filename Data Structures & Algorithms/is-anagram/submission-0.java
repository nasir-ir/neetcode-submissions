class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length()) return false;

        Hashtable< Character, Integer> track = new Hashtable<>();

        for(char ch: s.toCharArray())
            track.put(ch, track.getOrDefault(ch, 0)+1);

        for(char ch: t.toCharArray())
            track.put(ch, track.getOrDefault(ch, 0)-1);
            
        for(var pair : track.entrySet()){
            if(pair.getValue() != 0)
            return false;
        }
        return true;
    }
}
