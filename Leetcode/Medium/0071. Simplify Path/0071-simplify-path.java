import java.util.StringTokenizer;
class Solution {
    public String simplifyPath(String path) {
        Map<String, String> map = new HashMap<>();
        path = path.replaceAll("//", "/");
        path = path.replaceAll("///", "/");

        StringTokenizer st = new StringTokenizer(path, "/");
        ArrayDeque<String> ad = new ArrayDeque<>();
        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (temp.equals("..")) {
                if (!ad.isEmpty())
                    ad.pollLast();
                continue;
            } else if (temp.equals(".")) {
                continue;
            }

            ad.addLast(temp);
        }

        StringBuilder sb = new StringBuilder();
        while (!ad.isEmpty()) {
            sb.append("/").append(ad.pollFirst());
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}