import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][] white = new int[102][102];	// 흰색 천 배열(둘레를 사방탐색으로 찾기 위해 x축, y축 양옆으로 +1을 해주었다.
		int N = Integer.parseInt(st.nextToken());	// 검은색 스카프의 수를 입력 받는다
		for(int n = 0; n < N; n++) {	
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());	// 검은색 스카프의 왼쪽 변과 흰색 천의 왼쪽 변 사이의 거리
			int x = Integer.parseInt(st.nextToken());	// 검은색 스카프의 위쪽 변과 흰색 천의 위쪽 변 사이의 거리(배열을 사용하여서 문제에서 사용한 그림과는 조금 다르게 위 아래가 바뀌었다)
			
			for(int i = x+1; i <= x+10; i++) {
				for(int j = y+1; j <= y+10; j++) {
					white[i][j] = 1;	// 검정색 스카프가 있는 위치를 1로 표시한다.
				}
			}
		}
		
		int[] dx = {-1, 1, 0, 0};	// 인덱스 별로 : 0->상, 1->하, 2->좌, 3->우
		int[] dy = {0, 0, -1, 1};
		int count = 0;
		for(int i = 1; i <= 100; i++) {
			for(int j = 1; j <= 100; j++) {
				if(white[i][j]==1) {	// 검정색 스카프가 있는 배열일 시
					for(int d = 0; d < 4; d++) {	// 사방탐색을 진행하여
						int nx = i+dx[d];
						int ny = j+dy[d];	
						if(white[nx][ny]==0) {
							count++;
						}
					}	// 흰색부분(0인부분)과 맞닿아 있는 부분이 있을 시 count를 ++ 해준다.
				}	
			}
		}
		
		System.out.println(count);
	}
}
