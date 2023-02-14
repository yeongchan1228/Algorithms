package programmers.level2;

import java.util.Arrays;

public class N17686 { // 파일명 정렬
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};

        System.out.println(new Solution().solution(files));
    }

    static class Solution {
        public String[] solution(String[] files) {
            FileInfo[] fileInfos = new FileInfo[files.length];
            for (int i = 0; i < files.length; i++) {
                String file = files[i];
                char[] chars = file.toCharArray();
                int start = 0;
                int end = 0;
                while (end < chars.length && !(chars[end] <= '9' && chars[end] >= '0')) {
                    end++;
                }
                String head = file.substring(start, end);

                start = end;
                int cnt = 0;
                while (end < chars.length && (chars[end] <= '9' && chars[end] >= '0') && cnt < 5) {
                    end++;
                    cnt++;
                }
                int number = Integer.parseInt(file.substring(start, end));

                fileInfos[i] = new FileInfo(i, head.toUpperCase(), number, file);
            }

            Arrays.sort(fileInfos);

            String[] answer = new String[fileInfos.length];
            for (int i = 0; i < fileInfos.length; i++) {
                answer[i] = fileInfos[i].filename;
            }

            return answer;
        }

        public class FileInfo implements Comparable<FileInfo> {
            int idx;
            String head;
            int number;
            String filename;

            public FileInfo(int idx, String head, int number, String filename) {
                this.idx = idx;
                this.head = head;
                this.number = number;
                this.filename = filename;
            }

            @Override
            public int compareTo(FileInfo o) {
                if (this.head.equals(o.head)) {
                    if (this.number == o.number) {
                        return this.idx - o.idx;
                    }
                    return this.number - o.number;
                }

                return this.head.compareTo(o.head);
            }
        }
    }
}
