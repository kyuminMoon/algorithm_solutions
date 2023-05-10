package com.tistory.kmmoon;

import java.util.*;

public class 사다리타기 {
    public char[] solution(int n /*학생수*/, int[][] ladder/*사다리의 정보*/){
        char[] answer = new char[n];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            char a = (char) (i + 64);
            map.put(a, i);
        }

        for (int[] index : ladder) {
            map.forEach((character, integer) -> {
                for (int line : index) {
                    if(integer == line){
                        map.put(character, integer+1);
                    }
                    if(integer == line+1){
                        map.put(character, integer-1);
                    }
                }
            });
        }

        System.out.println(map);
        map.forEach((character, integer) -> answer[integer-1] = character);

        return answer;
    }
    /**
    * Map<String, Integer>을 사용해 ladder [][]의 2차원 배열을 순차적으로 돌아가며 value를 검사함.
    * ex) key = A, value = 1인 경우,  [[1, 3], [2, 4], [1, 4]] 이라면 첫 배열 1과 일치하므로 인덱스를 +1 해준다.
    * 두번째 배열인 경우에도 2와 일치하므로 +1 하면 value는 3이 된다.
    * key = B, value = 2의 경우 1,3 어디에도 일치하지 않지만 배열에 +1씩을 더해 일치하는지 확인한다.
    * +1한 값과 일치한다면 value에 -1을 해서 처리.
    * value = 2, 1+1 = 2 , 1+3 = 4 이므로 2가 일치하면 value는 -1하여 1로 이동한다.
    */

    public static void main(String[] args){
        사다리타기 T = new 사다리타기();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }

    //n	ladder	answer
    //5	[[1, 3], [2, 4], [1, 4]]	['D', 'B', 'A', 'C', 'E']
    //7	[[1, 3, 5], [1, 3, 6], [2, 4]]	['A', 'C', 'B', 'F', 'D', 'G', 'E']
    //8	[[1, 5], [2, 4, 7], [1, 5, 7], [2, 5, 7]]	['C', 'A', 'B', 'F', 'D', 'E', 'H', 'G']
    //12 [[1, 5, 8, 10], [2, 4, 7], [1, 5, 7, 9, 11], [2, 5, 7, 10], [3, 6, 8, 11]]	['C', 'A', 'F', 'B', 'D', 'I', 'E', 'K', 'G', 'L', 'J', 'H']
}
