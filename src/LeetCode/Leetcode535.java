package src.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode535 {
    public class Codec {
        Map<Integer,String> map = new HashMap<>();
        int count=0;
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            count++;
            map.put(count,longUrl);
             return "http://tinyurl.com/"+count;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            int t = Integer.parseInt(shortUrl.replace("http://tinyurl.com/",""));
            return map.get(t);
        }
    }
}
