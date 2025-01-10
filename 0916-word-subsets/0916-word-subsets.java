class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCount = new int[26];
        int[] tmpCount;

        for (String word : words2) {
            tmpCount = countLetters(word);

            for (int i = 0; i < 26; i++) {
                maxCount[i] = Math.max(maxCount[i], tmpCount[i]);
            }
        }

        List<String> universalWords = new ArrayList<>();

        for (String word : words1) {
            tmpCount = countLetters(word);

            boolean isUniversal = true;

            for (int i = 0; i < 26; i++) {
                if (maxCount[i] > tmpCount[i]) {
                    isUniversal = false;
                    break;
                }
            }
            
            if (isUniversal) universalWords.add(word); 
        }

        return universalWords;
    }

    private int[] countLetters(String word) {
        int[] tmpCount = new int[26];

        for (char w : word.toCharArray()) {
            tmpCount[w - 'a']++;
        }

        return tmpCount;
    }
}