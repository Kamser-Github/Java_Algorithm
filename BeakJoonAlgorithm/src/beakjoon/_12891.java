package beakjoon;

import java.util.Scanner;

public class _12891 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[2];
		
		for(int i=0 ; i<arr.length ; i++) {
			arr[i] = Integer.parseInt(sc.next());
		}
		String str = sc.next();
		int same = 0;
		int[] min = new int[4];
		for(int i=0 ; i<min.length ; i++) {
			min[i] = Integer.parseInt(sc.next());
		}
		/*
		 * 알고리즘 순서.
		 * 
		 * 먼저 이중포문 안됨 . 배열의 길이가 100만이라서 N^2이면 2초를 벗어남
		 * 
		 * 1.먼저 최소 배열의 길이를 고정한다,
		 * 2.검사가 끝나면 처음 위치에 있는 값을 제거. 
		 * 3.맨 앞인덱스 ++ 맨뒤 인덱스++
		 * 4.검사가 끝나면 마지막위치+1 있는 값을 추가. 
		 * 
		 * 이때 검사하기전에 마지막 인덱스를 더하기 때문에 인덱스가 벗어나는 오류가 생긴다.
		 * 따라서 이때에는 그전에 break를 걸어 함수를 마무리한다.
		 * 
		 * 슈도코드 작성
		 * 
		 * int[] 검사할 배열 
		 * for( 0 ~ arr[1]-1 )
		 * 	배열에 값을 저장,
		 * 
		 * for( i = 0 ~ 3)
		 * 	검사배열[i]<=현재배열[i]
		 * 		카운트 ++;
		 *  카운트==4
		 *  	비밀번호 일치 ++;
		 *  i가 3이면
		 *  	맨앞에 있는 값 제거
		 *  	맨뒤 인덱스++
		 *  	이때 맨뒤 인덱스가 arr[0]과 같으면 종료
		 *  	맨뒤에 인덱스 값 추가
		 *  	카운트 초기화
		 */
		int[] sample = new int[4];
		for(int i=0 ; i<arr[1] ; i++) {
			if(str.charAt(i)=='A')
				sample[0]++;
			else if(str.charAt(i)=='C')
				sample[1]++;
			else if(str.charAt(i)=='G')
				sample[2]++;
			else if(str.charAt(i)=='T')
				sample[3]++;
		}
		int x = 0;
		int y = arr[1]-1;
		int result = 0;
		int cnt = 0;
		for(int i=0 ; i<4 ; i++) {
			if(sample[i]>=min[i])
				cnt++;
			if(cnt==4) {
				result++;
			}
			if(i==3) {
				if(str.charAt(x)=='A')
					sample[0]--;
				else if(str.charAt(x)=='C')
					sample[1]--;
				else if(str.charAt(x)=='G')
					sample[2]--;
				else if(str.charAt(x)=='T')
					sample[3]--;
				y++;
				if(y==arr[0])
					break;
				if(str.charAt(y)=='A')
					sample[0]++;
				else if(str.charAt(y)=='C')
					sample[1]++;
				else if(str.charAt(y)=='G')
					sample[2]++;
				else if(str.charAt(y)=='T')
					sample[3]++;
				x++;
				i=-1;
				cnt=0;
			}
		}
		System.out.println(result);
	}
}