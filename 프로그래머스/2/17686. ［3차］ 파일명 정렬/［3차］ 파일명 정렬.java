import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            String fileName = files[i];
            
            StringBuilder head = new StringBuilder();
            StringBuilder number = new StringBuilder();
            StringBuilder tail = new StringBuilder();
            
            int idx = 0;
            
            while (idx < fileName.length() && !Character.isDigit(fileName.charAt(idx))) {
                head.append(fileName.charAt(idx));
                idx++;
            }
            
            while (idx < fileName.length() && Character.isDigit(fileName.charAt(idx)) && number.length() < 5) {
                number.append(fileName.charAt(idx));
                idx++;
            }
            
            if (idx < fileName.length()) {
                tail.append(fileName.substring(idx));
            }
            
            fileList.add(new File(head.toString(), number.toString(), tail.toString(), i));
        }
        
        Collections.sort(fileList);
        
        String[] answer = new String[files.length];
        for (int i = 0; i < fileList.size(); i++) {
            answer[i] = fileList.get(i).getOriginal();
        }
        
        return answer;
    }
    
    static class File implements Comparable<File> {
        String head;
        String number;
        String tail;
        int originalIndex;

        public File(String head, String number, String tail, int originalIndex) {
            this.head = head;
            this.number = number;
            this.tail = tail;
            this.originalIndex = originalIndex;
        }
        
        public String getOriginal() {
            return head + number + tail;
        }

        @Override
        public int compareTo(File o) {
            String thisHead = this.head.toLowerCase();
            String otherHead = o.head.toLowerCase();
            int headCompare = thisHead.compareTo(otherHead);
            
            if (headCompare != 0) {
                return headCompare;
            }
            
            int thisNum = Integer.parseInt(this.number);
            int otherNum = Integer.parseInt(o.number);
            
            if (thisNum != otherNum) {
                return thisNum - otherNum;
            }
            
            return this.originalIndex - o.originalIndex;
        }
    }
}