// Problem Link: https://www.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
class Solution {
    public String firstNonRepeating(String s) {
        
        Deque<Character> dq = new ArrayDeque<>();
        
        int freq[] = new int[26];
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hset = new HashSet<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            dq.offer(ch);
            freq[ch-'a']++;
            if(freq[ch-'a'] > 1) {
                hset.add(ch);
            }
            while(!dq.isEmpty() && hset.contains(dq.peekFirst())) {
                dq.removeFirst();
            }
            if(!dq.isEmpty()) {
                sb.append(dq.peekFirst());
            } else sb.append('#');
        }
        return sb.toString();
        
    }
}
