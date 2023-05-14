package com.tistory.kmmoon;

import java.util.*;

public class 청소 {

    /**
     * 입출력 예:
     * board = [[0, 0, 0, 0, 0], [0, 1, 1, 0, 0], [0, 0, 0, 0, 0], [1, 0, 1, 0, 1], [0, 0, 0, 0, 0]]
     * k = 10
     * answer = [2, 2]
     * board = [[0, 0, 0, 1, 0, 1], [0, 0, 0, 0, 0, 0], [0, 0, 0, 0, 0, 1], [1, 1, 0, 0, 1, 0], [0, 0, 0, 0, 0, 0],[0, 0, 0, 0, 0, 0]]
     * k = 20
     * answer = [4, 5]
     * board = [[0, 0, 1, 0, 0], [0, 1, 0, 0, 0], [0, 0, 0, 0, 0], [1, 0, 0, 0, 1], [0, 0, 0, 0, 0]]
     * k = 25
     * answer = [0, 1]
     * 제한사항:
     * • board의 크기 (3 <= n <= 100)
     * • board에서 0은 빈 공간이고, 1은 장애물이다.
     * • board에서 로봇의 시작위치는 0행 0열(가장 왼쪽 가장 위)이다. • 변수 k는 1,000이하의 자연수이다.*/
    public int[] solution(int[][] board /*맵 정보*/, int k /*시간*/){
        int[] answer;
        int direction = 90;

        // 현재 위치
        int x = 0, y = 0;

        // 0, 0에서 시작, 무조건 오른쪽으로 이동
        // 시계방향 90도씩 회전
        for (int i = 0; i < k; i++) {
            if(direction == 0) {
                if(x == 0 || board[x-1][y] == 1) {
                    direction += 90;
                } else {
                    x -= 1;
                }
            } else if(direction == 90) {
                if(board[x].length -1 == y || board[x][y + 1] == 1) {
                    direction += 90;
                } else {
                    y += 1;
                }
            } else if (direction == 180) {
                if(board.length -1 == x || board[x+1][y] == 1) {
                    direction += 90;
                } else {
                    x += 1;
                }
            } else if (direction == 270) {
                if(y == 0 || board[x][y - 1] == 1) {
                    direction = 0;
                } else {
                    y -= 1;
                }
            }
        }

        answer = new int[]{x,y};
        return answer;
    }

    public static void main(String[] args){
        청소 T = new 청소();
        int[][] arr1 = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {
                {0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {
                {0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr3, 25)));
    }
}