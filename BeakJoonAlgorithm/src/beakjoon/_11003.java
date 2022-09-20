package beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class _11003 {
	public static void main(String[] args) throws IOException {
/*
		
		풀이 방법 1차
		시간 제한 2.4초
		
		최소값은 L만큼 범위 내에서 정렬후 맨 앞에 있는걸 출력하면된다.
		500만번이 최대값으로 들어오기 때문에 nlogn에다가 포문을 돌리면 시간이 초과
		
		슬라이드 모양으로 포문 한번에 최소값을 구하고
		출력을 해야한다.
		
		= 슈도 코드 =
		
		Deque를 이용
		for( N만큼 반복){
			Deque 배열 마지막 인덱스에 추가.
			앞에 있는 숫자와 비교해서 앞 숫자가 크면 제거
			맨앞 인덱스와 자기의 인덱스를 차이가 L과 같거나 크면 앞에 배열 제거
			맨앞 배열 값 출력
*/		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Deque<int[]> dq = new ArrayDeque<>();
		//LinkedList보다
		//ArrayDeque가 속도가 더 빠르다.
		st = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			int v = Integer.parseInt(st.nextToken());
			
			while(!dq.isEmpty()&&dq.peekLast()[1] > v) {
				dq.pollLast();
			}
			
			dq.offer(new int[] {i,v});
			
			if(dq.peek()[0] <= i-L) {
				dq.poll();
			}
			bw.write(dq.peek()[1]+" ");
		}
		
		bw.flush();
		bw.close();
	}
//	
//	static class Node {
//		int index;
//		int value;
//		Node(int index,int value){
//			this.index = index;
//			this.value = value;
//		}
//	}
}

