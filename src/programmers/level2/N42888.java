package programmers.level2;

import java.util.*;

public class N42888 { // 오픈 채팅방
    public static void main(String[] args) {
        String[] recode = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        ArrayList<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < recode.length; i++) {
            st = new StringTokenizer(recode[i]);
            String action = st.nextToken();
            String uid = st.nextToken();

            if(action.equals("Leave")) {
                list.add(uid + "님이 나갔습니다.");
                continue;
            }

            String  nickname = st.nextToken();
            if(action.equals("Enter")){
                map.put(uid, nickname);
                list.add(uid + "님이 들어왔습니다.");
            }else if(action.equals("Change")){
                map.put(uid, nickname);
            }
        }

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String log = list.get(i);
            int end = log.indexOf("님");
            String uid = log.substring(0, end);
            String result = log.replace(uid, map.get(uid));
            answer[i] = result;
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
