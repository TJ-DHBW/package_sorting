package packageSortingCenter.sortingFacility.sortingLanes;

public class RabinKarp {
    // d is the number of characters in the input alphabet
    public final static int d = 256;
    private static final RabinKarp instance = new RabinKarp();
    public Port port = new Port();

    public static RabinKarp getInstance() {
        return instance;
    }


    //Modified from: https://www.geeksforgeeks.org/java-program-for-rabin-karp-algorithm-for-pattern-searching/

    /* pat -> pattern
        txt -> text
        q -> A prime number
    */
    static int innerSearch(char[] txt, char[] pat, int q) {
        int M = pat.length;
        int N = txt.length;
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat[i]) % q;
            t = (d * t + txt[i]) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt[i + j] != pat[j])
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                    return i;
                //System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt[i] * h) + txt[i + M]) % q;

                // We might get negative value of t, converting it
                // to positive
                if (t < 0)
                    t = (t + q);
            }
        }
        return -1;
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEK";
        int q = 101; // A prime number
        innerSearch(txt.toCharArray(), pat.toCharArray(), q);
    }

    public class Port implements ISearchAlgorithm {

        @Override
        public int search(char[] input, char[] pattern) {
            return innerSearch(input, pattern, 101);
        }
    }
}
