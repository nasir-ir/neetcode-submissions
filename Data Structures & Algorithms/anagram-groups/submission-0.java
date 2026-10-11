
class Solution {
    //Building key for each string.
    //The key is the frequency of each character in the word in order using "0$0$0$" format from 1-26th position
    //The key is then converted to string and returned.
    public String getHash( String word){
        
        StringBuilder hash = new StringBuilder();

        int[] freq = new int[26];
        for(int i=0; i<word.length(); i++){
            freq[word.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++){
            hash.append(freq[i]);
            hash.append("$");
        }
        return hash.toString();
    }

    // The main logic is to create a key for each word which would look same for anagrams.
    //Meaning: The key will contain the frequency of each character.
    //we can then use the key to create a dictionary for each word with their key and its position in the result list.
    //later, we can match the key and then add the word in the matching posion list.
    //And if the key doesn't match we will create a new position in reult list and save that key for future reference.
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();


        //If there is only one word or charcter in the strs
        // if( strs.length ==1){
        //     List<String> sublist = new ArrayList<>();
        //     sublist.add(strs[0]);
        //     result.add(sublist);
        //     return result;
        // }

        for(int i=0; i< strs.length; i++){
            //creating the key
            String key = getHash(strs[i]);

            //if the key is not present in the dictionary,
            //we will add the key and the next posion for the next list in the result list.
            if(!map.containsKey(key)){
                map.put(key, result.size());
                result.add(new ArrayList<>());

            }
            //adding the word to the inner list
            result.get(map.get(key)).add(strs[i]);
        }
        return result;

        

    }
}
