package q21_30;

import java.util.*;

public class Q30_Java {

    // Done in Java because I have a Java exam a few days later
    public static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            /////// METHOD 1 ///////
            int wordLength = words[0].length();

            Map<String, Integer> wordsCount = new HashMap<>();
            for (String word : words) {
                wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
            }
            List<Integer> out = new ArrayList<>();

            for (int i = 0; i + wordLength * words.length <= s.length(); i++) {
                Map<String, Integer> currentCount = new HashMap<>();
                int wordIndex;
                for (wordIndex = 1; wordIndex <= words.length; wordIndex++) {
                    String currentWord = s.substring(i + (wordIndex - 1) * wordLength, i + wordIndex * wordLength);
                    currentCount.put(currentWord, currentCount.getOrDefault(currentWord, 0) + 1);
                    if (currentCount.get(currentWord) > wordsCount.getOrDefault(currentWord, 0)) {
                        break;
                    }
                }
                if (wordIndex == words.length + 1) {
                    out.add(i);
                }
            }
            return out;

            /////// METHOD 2 ///////
//            int wordLength = words[0].length();
//            int left = 0;
//            int right = words.length * wordLength;
//            List<String> wordsList = Arrays.asList(words);
//            List<Integer> out = new ArrayList<>();
//            outer: while (right <= s.length()) {
//                String currentSubstring = s.substring(left, right);
//
//                List<String> mutableWords = new ArrayList<>(wordsList);
//
//                boolean contains = true;
//                for (int i = 0; i < currentSubstring.length(); i += wordLength) {
//                    String word = currentSubstring.substring(i, i + wordLength);
//                    if (!mutableWords.contains(word)) {
//                        contains = false;
//                        break;
//                    }
//                    mutableWords.remove(word);
//                }
//                if (contains) {
//                    out.add(left);
//                }
//
//                left++;
//                right++;
//            }
//            return out;

            /////// METHOD 3 ///////
//            int wordLength = words[0].length();
//            List<Integer> out = new ArrayList<>();
//            Set<String> originWords = new HashSet<>(Arrays.asList(words));
//            for (int i = 0; i < wordLength; i++) {
//                String slicedString = s.substring(i);
//                slicedString = slicedString.substring(0, slicedString.length() / wordLength * wordLength);
//                List<String> mutableWords = new ArrayList<>(Arrays.asList(words));
//
//                String[] wordLocation = new String[slicedString.length()]; // Key: index of word in string, value: the word
//                int start = 0;
//                int end = start;
//
//                while (end < slicedString.length()) {
//                    end += wordLength;
//                    String currentSubstring = slicedString.substring(end - wordLength, end);
//                    if (mutableWords.contains(currentSubstring)) {
//                        mutableWords.remove(currentSubstring);
//                        if (mutableWords.isEmpty()) {
//                            mutableWords.add(wordLocation[start]);
//                            out.add(start + i);
//                            start += wordLength;
//                        }
//                        wordLocation[end - wordLength] = currentSubstring;
//                    } else {
//                        start = end;
//                        mutableWords.clear();
//                        mutableWords.addAll(originWords);
//
//                        String currentWord;
//                        while (true) {
//                            if (start < wordLength) {
//                                break;
//                            }
//                            currentWord = slicedString.substring(start - wordLength, start);
//                            if (!mutableWords.contains(currentWord)) {
//                                break;
//                            }
//                            start = start - wordLength;
//
//                            wordLocation[start] = currentWord;
//                            mutableWords.remove(currentWord);
//                        }
//                    }
//                }
//            }
//
//
//            return out;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        long averageTime = 0;
        for (int i = 0; i < 100; i++) {
            long time = System.currentTimeMillis();
            for (int inner = 0; inner < 1000; inner++) {
                solution.findSubstring("barfoothefoobarman", new String[] { "bar", "foo"});
                solution.findSubstring("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" });
                solution.findSubstring("wordgoodgoodgoodbestword", new String[] { "word","good","best","good" });
                solution.findSubstring("bcabbcaabbccacacbabccacaababcbb", new String[] { "c","b","a","c","a","a","a","b","c" });
            }
            long timeTaken = System.currentTimeMillis() - time;
            averageTime += timeTaken;
        }
        System.out.println("Totally took " + averageTime);
        System.out.println("Average: " + averageTime/100);

        System.out.println(solution.findSubstring("barfoothefoobarman", new String[] { "bar", "foo"}));
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[] { "bar", "foo", "the" }));
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[] { "word","good","best","good" }));
        System.out.println(solution.findSubstring("bcabbcaabbccacacbabccacaababcbb", new String[] { "c","b","a","c","a","a","a","b","c" }));
    }
}
