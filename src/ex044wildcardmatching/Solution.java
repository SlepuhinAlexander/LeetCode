package ex044wildcardmatching;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = {"", "", "", "a", "aa", "aa", "cb", "abc", "c", "c", "c", "abc", "abc",
                "abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb"};
        String[] patterns = {"", "*", "?", "", "a", "*", "?a", "?b?", "*c", "*c*", "**", "*c", "*c*",
                "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**"};
        for (int i = 0; i < strings.length; i++) {
            System.out.println("string: '" + strings[i] + "', pattern: '" + patterns[i] +
                               "' -> is match: " + solution.isMatch(strings[i], patterns[i]));
        }
    }

    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), 0, squash(p.toCharArray()), 0);
    }

    private char[] squash(char[] pattern) {
        char[] chars = new char[pattern.length];
        int j = 0, star = -100;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] != '*') {
                chars[j++] = pattern[i];
                continue;
            }
            if (i != star + 1) {
                chars[j++] = pattern[i];
            }
            star = i;
        }
        int k = chars.length - 1;
        while (k >= 0 && chars[k] == 0) {
            k--;
        }
        char[] squashed = new char[k + 1];
        System.arraycopy(chars, 0, squashed, 0, k + 1);
        int stars = 0;
        for (char c : squashed) {
            if (c == '*') {
                stars++;
            }
        }

        return squashed;
    }

    private boolean isMatch(char[] string, int stringFrom, char[] pattern, int patternFrom) {
        if (stringFrom >= string.length && patternFrom >= pattern.length) {
            return true;
        }
        while (stringFrom < string.length && patternFrom < pattern.length) {
            if (pattern[patternFrom] == '*') {
                break;
            }
            if (pattern[patternFrom] == '?' || string[stringFrom] == pattern[patternFrom]) {
                stringFrom++;
                patternFrom++;
                continue;
            }
            if (pattern[patternFrom] != '*' && string[stringFrom] != pattern[patternFrom]) {
                return false;
            }
        }
        if (patternFrom < pattern.length && pattern[patternFrom] == '*') {
            if (patternFrom == pattern.length - 1) {
                return true;
            }
            for (int i = stringFrom; i < string.length; i++) {
                if (isMatch(string, i, pattern, patternFrom + 1)) {
                    return true;
                }
            }
            return false;
        }
        return stringFrom == string.length && patternFrom == pattern.length;
    }
}
