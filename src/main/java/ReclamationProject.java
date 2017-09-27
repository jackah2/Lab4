/**
 * The following code needs a lot of TLC. So give it some!
 *
 * 1. Fix all checkstyle errors
 * 2. Determine what it does (it's going to be tough before you finish #1)
 * 3. Improve the name of the methods and variables
 * 4. Add comments and Javadoc comments where needed
 * 5. Remove unnecessary comments as appropriate
 */
public class ReclamationProject {

    /**
     * @param unused unused
     */
    public static void main(final String[] unused) {
        String str1 = "asdf";
        String str2 = "asdf";
        String matchingSection = getFirstMatchingSection(str1, str2);
        System.out.println(matchingSection);
    }

    /**
     * @param a A string
     * @param b A second string
     * @return The first instance of a matching section of two strings
     */
    private static String getFirstMatchingSection(final String a, final String b) {

        if (a.equals(b)) {
            return a;
        }

        String shortStr = a, longStr = b;

        if (shortStr.length() > longStr.length()) {
            String temp = shortStr;
            shortStr = longStr;
            longStr = temp;
        }

        String matching = "";

        for (int mainInd = 0; mainInd < shortStr.length(); mainInd++) {

            for (int endInd = shortStr.length() - mainInd; endInd > 0; endInd--) {

                for (int startInd = 0; startInd < longStr.length() - endInd; startInd++) {

                    if (shortStr.regionMatches(mainInd, longStr, startInd, endInd)
                            && matching.length() < endInd) {
                        matching = shortStr.substring(mainInd, mainInd + endInd);
                    }
                }
            }
        }
        return matching;
    }
}
