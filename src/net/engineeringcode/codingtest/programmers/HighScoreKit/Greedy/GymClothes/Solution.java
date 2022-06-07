package net.engineeringcode.codingtest.programmers.HighScoreKit.Greedy.GymClothes;
import java.util.*;

public class Solution {
	/*
	 * 프로그래머스 > 코딩테스트 연습 > 탐욕법(Greedy) > 체육복
	 * https://programmers.co.kr/learn/courses/30/lessons/42862
	 * 작성자: 공학코드(engineeringcode93@gmail.com)
	 * 
	 */
	
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 여벌을 가져온 사람이 도난 당한 경우에 체육복을 못 빌려주도록 수정.
        for(int i=0;i<lost.length;i++) {
        	for(int j=0;j<reserve.length;j++) {
        		if(reserve[j]==lost[i]) {
        			answer++;
        			lost[i] = -1;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
        // 도난 당한 사람이 여벌을 가져온 사람에게 빌린다.
        for(int i=0;i<lost.length;i++) {
        	for(int j=0;j<reserve.length;j++) {
        		if(reserve[j]==lost[i]-1 || reserve[j]==lost[i]+1) {
        			answer++;
        			lost[i] = -1;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
        
        return answer;
    }
           
    public static void main(String[] args) { 
    	Solution solution = new Solution();
    	
    	int n = 5;
    	int[] lost = new int[] {2, 4};
    	int[] reserve = new int[] {1, 3, 5};
    	int answerCorrect = 5;
		int answerReturned = -1;
		
		answerReturned = solution.solution(n, lost, reserve);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 1 PASS");
		}else {
			System.out.println("CASE 1 FAIL");
		}
		
		n = 5;
    	lost = new int[] {2, 4};
    	reserve = new int[] {3};
    	answerCorrect = 4;
		answerReturned = -1;
		
		answerReturned = solution.solution(n, lost, reserve);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 2 PASS");
		}else {
			System.out.println("CASE 2 FAIL");
		}
		
		n = 3;
    	lost = new int[] {3};
    	reserve = new int[] {1};
    	answerCorrect = 2;
		answerReturned = -1;
		
		answerReturned = solution.solution(n, lost, reserve);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
		
		// 내가 추가한 케이스
		n = 7;
    	lost = new int[] {3, 5};
    	reserve = new int[] {3, 6};
    	answerCorrect = 7;
		answerReturned = -1;
		
		answerReturned = solution.solution(n, lost, reserve);
		
		System.out.println("Returned Value == " + answerReturned);
		System.out.println("Expected Value == " + answerCorrect);
		
		if(answerCorrect == answerReturned){
			System.out.println("CASE 3 PASS");
		}else {
			System.out.println("CASE 3 FAIL");
		}
    }
}
