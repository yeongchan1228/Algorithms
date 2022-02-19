package basicStep;

import java.util.Scanner;

public class Problem6987 { // 월드컵

    static int[][] map;
    static int[][] matchResult = new int[6][3];
    static int country = 6;
    static int inputCount = 4;
    static int totalNum = 0;
    static int[] team1 = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
    static int[] team2 = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
    static boolean[] fin = new boolean[inputCount];
    static void playGame(int num, int gameCount){
       
        if(gameCount == 15){  // 모든 경기 진행
            if(totalNum != 30)
                return;
            if(fin[num])
                return;
            else {
                boolean check = false;
                for(int i = 0; i < country; i++){
                    for(int j = 0; j < 3; j++){
                        if(map[i][j] != matchResult[i][j]) {
                            check = true;
                            break;
                        }
                    }
                    if(check)
                        break;
                }
                if(!check) {
                    fin[num] = true;
                    return;
                }
            }
            return;
        }
        
        
        int matchTeam1 = team1[gameCount];
        int matchTeam2 = team2[gameCount];

        //matchTeam1 승, matchTeam2 패
        matchResult[matchTeam1][0] += 1;
        matchResult[matchTeam2][2] += 1;
        totalNum += 2;
        playGame(num,gameCount + 1);
        matchResult[matchTeam1][0] -= 1;
        matchResult[matchTeam2][2] -= 1;
        totalNum -= 2;

        //matchTeam1, matchTeam2 무승부
        matchResult[matchTeam1][1] += 1;
        matchResult[matchTeam2][1] += 1;
        totalNum += 2;
        playGame(num,gameCount + 1);
        matchResult[matchTeam1][1] -= 1;
        matchResult[matchTeam2][1] -= 1;
        totalNum -= 2;

        //matchTeam1 패, matchTeam2 승
        matchResult[matchTeam1][2] += 1;
        matchResult[matchTeam2][0] += 1;
        totalNum += 2;
        playGame(num,gameCount + 1);
        matchResult[matchTeam1][2] -= 1;
        matchResult[matchTeam2][0] -= 1;
        totalNum -= 2;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        map = new int[6][3]; // 0 -> A팀, 1 -> B팀
                            // 0-> 승리, 1-> 무승부, 2 -> 패배
        for(int i = 0; i < inputCount; i++) {
            for (int j = 0; j < country; j++) {
                map[j][0] = in.nextInt(); // 승리
                map[j][1] = in.nextInt(); // 무승부
                map[j][2] = in.nextInt(); // 패배
            }


            playGame(i, 0);
            matchResult = new int[6][3];
        }

        for(int i = 0; i < inputCount; i++) {
            if(fin[i])
                System.out.print("1 ");
            else
                System.out.print("0 ");
        }
    }
}
