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
        String str1 = "asdThis is a string";
        String str2 = "This is also a string";
        String matchingSection = getFirstMatchingSection(str1, str2);
        System.out.println(matchingSection);
    }

    /**
     * @param a A string
     * @param b A second string
     * @return The first instance of a matching section of two strings
     */
    private static String getFirstMatchingSection(final String a, final String b) {

        if (a.contentEquals(b)) {
            return a;
        }

        String str1 = a, str2 = b;

        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        String matching = "";

        for (int mainInd = 0; mainInd < str1.length(); mainInd++) {

            for (int subEndInd = str1.length() - mainInd; subEndInd > 0; subEndInd--) {

                for (int subStartInd = 0; subStartInd < str2.length() - subEndInd; subStartInd++) {

                    if (str1.regionMatches(mainInd, str2, subStartInd, subEndInd)
                            && matching.length() < subEndInd) {
                        matching = str1.substring(mainInd, mainInd + subEndInd);
                    }
                }
            }
        }
        return matching;
    }
}
