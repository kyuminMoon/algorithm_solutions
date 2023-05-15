package com.tistory.kmmoon;

import java.util.*;

class 잃어버린_강아지 {

    //board 10*10
    //0-빈칸,1-나무, 2-현수,3-강아지
    public int solution(int[][] board){
        int answer = 0;
        int x = 0, y = 0;
        int dogX = 0, dogY = 0;
        int direction = 0;
        int dogDirection = 0;

        for (int x2 = 0; x2 < board.length; x2++) {
            for (int y2 = 0; y2 < board[x2].length; y2++) {
                if (board[x2][y2] == 2) {
                    x = x2;
                    y = y2;
                }
                if (board[x2][y2] == 3) {
                    dogX = x2;
                    dogY = y2;
                }
            }
        }

        for (int i = 0; i < 10000; i++) {
            if(x == dogX && y == dogY) {
                answer = i;
                break;
            }
            if(direction == 0) {
                if(x == 0 || board[x-1][y] == 1) {
                    direction += 90;
                } else {
                    x -= 1;
                }
            } else if(direction == 90) {
                if(board[y].length -1 == y || board[x][y + 1] == 1) {
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

            if (dogDirection == 0) {
                if(dogX == 0 || board[dogX-1][dogY] == 1) {
                    dogDirection += 90;
                } else {
                    dogX -= 1;
                }
            } else if (dogDirection == 90) {
                if(board[dogX].length -1 == dogY || board[dogX][dogY + 1] == 1) {
                    dogDirection += 90;
                } else {
                    dogY += 1;
                }
            } else if (dogDirection == 180) {
                if(board.length -1 == dogX || board[dogX+1][dogY] == 1) {
                    dogDirection += 90;
                } else {
                    dogX += 1;
                }
            } else if (dogDirection == 270) {
                if(dogY == 0 || board[dogX][dogY - 1] == 1) {
                    dogDirection = 0;
                } else {
                    dogY -= 1;
                }
            }





        }
        
        return answer;
    }

    public static void main(String[] args){
        잃어버린_강아지 T = new 잃어버린_강아지();
        int[][] arr1 = {
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}}; // 51
        System.out.println(T.solution(arr1));
        int[][] arr2 = {
                {1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}}; // 17
        System.out.println(T.solution(arr2));
    }
}