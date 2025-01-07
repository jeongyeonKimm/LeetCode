class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;

        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (words[j].contains(words[i])) {
                    answer.add(words[i]);
                    break;
                }
            }
        }

        return answer;
    }
}