package ex127wordladder;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String beginWord1 = "hit", endWord1 = "dot";
        List<String> wordList1 = List.of("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord2 = "hit", endWord2 = "cog";
        List<String> wordList2 = List.of("hot", "dot", "dog", "lot", "log");
        solution.display(beginWord1, endWord1, wordList1, solution.wordLadder(beginWord1, endWord1, wordList1));
        solution.display(beginWord2, endWord2, wordList2, solution.wordLadder(beginWord2, endWord2, wordList2));
    }

    public int wordLadder(String beginWord, String endWord, List<String> wordList) {
        Word start = new Word(beginWord);
        Word finish = new Word(endWord);
        Word[] vocabulary = new Word[wordList.size()];
        for (int i = 0; i < wordList.size(); i++) {
            vocabulary[i] = new Word(wordList.get(i));
        }
        if (!fallFastCheck(start, finish, vocabulary)) {
            return 0;
        }
        Map<Word, List<Word>> graph = buildGraph(start, vocabulary);
        System.out.println(graph);
        return findShortestPath(start, finish, graph);
    }

    private boolean fallFastCheck(Word start, Word finish, Word[] vocabulary) {
        return vocabularyHasFinishWord(finish, vocabulary) && vocabularyIsAccessibleFromStartWord(start, vocabulary);
    }

    private boolean vocabularyHasFinishWord(Word finish, Word[] vocabulary) {
        for (Word word : vocabulary) {
            if (word.equals(finish)) {
                return true;
            }
        }
        return false;
    }

    private boolean vocabularyIsAccessibleFromStartWord(Word beginWord, Word[] vocabulary) {
        for (Word word : vocabulary) {
            if (beginWord.differByOnlyOneLetter(word)) {
                return true;
            }
        }
        return false;
    }

    private Map<Word, List<Word>> buildGraph(Word beginWord, Word[] vocabulary) {
        Map<Word, List<Word>> graph = new HashMap<>();
        for (int i = 0; i < vocabulary.length; i++) {
            if (beginWord.differByOnlyOneLetter(vocabulary[i])) {
                graph.computeIfAbsent(beginWord, k -> new ArrayList<>());
                graph.get(beginWord).add(vocabulary[i]);
            }
        }
        for (int i = 0; i < vocabulary.length; i++) {
            for (int j = 0; j < vocabulary.length; j++) {
                if (vocabulary[i].differByOnlyOneLetter(vocabulary[j])) {
                    graph.computeIfAbsent(vocabulary[i], k -> new ArrayList<>());
                    graph.get(vocabulary[i]).add(vocabulary[j]);
                }
            }
        }
        return graph;
    }

    private int findShortestPath(Word start, Word finish, Map<Word, List<Word>> graph) {
        Set<Word> notVisited = new HashSet<>(graph.keySet());
        List<Word> lastNodes = new ArrayList<>();
        lastNodes.add(start);
        notVisited.remove(start);
        for (int pathLength = 1; pathLength <= notVisited.size(); pathLength++) {
            List<Word> newLastNodes = new ArrayList<>();
            for (Word lastNode : lastNodes) {
                if (lastNode.equals(finish)) {
                    return pathLength;
                }
            }
            for (Word lastNode : lastNodes) {
                List<Word> nextNodes = graph.get(lastNode);
                if (nextNodes == null) {
                    continue;
                }
                for (Word nextNode : nextNodes) {
                    if (notVisited.contains(nextNode)) {
                        newLastNodes.add(nextNode);
                        notVisited.remove(nextNode);
                    }
                }
            }
            lastNodes = newLastNodes;
        }
        return 0;
    }

    private void display(String beginWord, String endWord, List<String> wordList, int output) {
        System.out.println("beginWord: " + beginWord + "; endWord: " + endWord + "wordList:" + wordList + " -> output: " + output);
    }

    private static class Word implements Comparable<Word> {
        private final String value;
        private final long hash;

        public Word(String value) {
            this.value = value;
            this.hash = hash();
        }

        private long hash() {
            char[] letters = this.value.toCharArray();
            long hash = 0;
            for (char letter : letters) {
                hash = hash * 26 + letter - 'a' + 1;
            }
            return hash * 26;
        }

        public String getValue() {
            return value;
        }

        public long getHash() {
            return hash;
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (!(other instanceof Word)) return false;
            Word word = (Word) other;
            return hash == word.getHash();
        }

        @Override
        public int hashCode() {
            return (int) this.hash;
        }

        @Override
        public String toString() {
            return value;
        }

        @Override
        public int compareTo(Word other) {
            long diff = hash - other.getHash();
            if (diff < 0) return -1;
            if (diff > 0) return 1;
            return 0;
        }

        public boolean differByOnlyOneLetter(Word other) {
            long diff = Math.max(hash, other.getHash()) - Math.min(hash, other.getHash());
            if (diff == 0) {
                return false;
            }
            while (diff % 26 == 0) {
                diff /= 26;
            }
            return diff < 26;
        }
    }
}
