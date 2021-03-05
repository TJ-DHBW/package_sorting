package packageSortingCenter.sortingFacility.sortingLanes;

public class BoyerMoore {
    private static final BoyerMoore instance = new BoyerMoore();
    public Port port = new Port();

    public static BoyerMoore getInstance(){
        return instance;
    }

    public class Port implements ISearchAlgorithm {

        @Override
        public int search(char[] input, char[] pattern) {
            return innerSearch(input, pattern);
        }
    }


    private static int[] makeOffsetTable(char[] pattern) {
        int[] table = new int[pattern.length];
        int lastPrefixPosition = pattern.length;

        for (int i = pattern.length - 1; i >= 0; --i) {
            if (isPrefix(pattern, i + 1)) {
                lastPrefixPosition = i + 1;
            }
            table[pattern.length - 1 - i] = lastPrefixPosition - i + pattern.length - 1;
        }

        for (int i = 0; i < pattern.length - 1; ++i) {
            int suffixLength = suffixLength(pattern, i);
            table[suffixLength] = pattern.length - 1 - i + suffixLength;
        }

        return table;
    }

    private static boolean isPrefix(char[] pattern, int p) {
        for (int i = p, j = 0; i < pattern.length; ++i, ++j) {
            if (pattern[i] != pattern[j]) {
                return false;
            }
        }
        return true;
    }

    private static int suffixLength(char[] pattern, int p) {
        int length = 0;

        for (int i = p, j = pattern.length - 1; i >= 0 && pattern[i] == pattern[j]; --i, --j) {
            length += 1;
        }

        return length;
    }

    public int innerSearch(char[] text, char[] pattern) {
        if (pattern.length == 0) {
            return 0;
        }

        int[] charTable = makeCharTable(pattern);
        int[] offsetTable = makeOffsetTable(pattern);

        for (int i = pattern.length - 1, j; i < text.length; ) {
            for (j = pattern.length - 1; pattern[j] == text[i]; --i, --j) {
                if (j == 0) {
                    return i;
                }
            }
            i += Math.max(offsetTable[pattern.length - 1 - j], charTable[text[i]]);
        }

        return -1;
    }

    private int[] makeCharTable(char[] pattern) {
        final int ALPHABET_SIZE = 256;
        int[] table = new int[ALPHABET_SIZE];

        for (int i = 0; i < table.length; ++i) {
            table[i] = pattern.length;
        }

        for (int i = 0; i < pattern.length - 1; ++i) {
            table[pattern[i]] = pattern.length - 1 - i;
        }

        return table;
    }
}

