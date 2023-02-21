import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char[][] map = new char[H][W];
			int x=0;
			int y=0;
			int dir = 0;	// 상1, 하2, 좌3, 우4
			for(int i = 0; i < H; i++) {
				String str = sc.next();
				for(int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='v'||map[i][j]=='^'||map[i][j]=='<'||map[i][j]=='>') {
						x = i;
						y = j;
					}
					switch(map[i][j]) {
					case('^'):
						dir = 1;
						break;
					case('v'):
						dir = 2;
						break;
					case('<'):
						dir = 3;
						break;
					case('>'):
						dir = 4;
						break;
					}
				}
			}
			int N = sc.nextInt();
			String str = sc.next();
			for(int i = 0; i < N; i++) {
				int idx = 0;
				char input = str.charAt(i);
				switch(input) {
				case('U'):
					map[x][y]='^';
					if(x>0 && map[x-1][y]=='.') {
						map[x-1][y] = map[x][y];
						map[x][y] = '.';
						x-=1;
					}
					dir=1;
					break;
				case('D'):
					map[x][y]='v';
					if(x<H-1 && map[x+1][y]=='.') {
						map[x+1][y] = map[x][y];
						map[x][y] = '.';
						x+=1;
					}
					dir=2;
					break;
				case('L'):
					map[x][y]='<';
					if(y>0 && map[x][y-1]=='.') {
						map[x][y-1] = map[x][y];
						map[x][y] = '.';
						y-=1;
					}
					dir=3;
					break;
				case('R'):
					map[x][y]='>';
					if(y<W-1 && map[x][y+1]=='.') {
						map[x][y+1] = map[x][y];
						map[x][y] = '.';
						y+=1;
					}
					dir=4;
					break;
				case('S'):
					switch(dir) {
					case(1):
						idx=x;
						while(true) {
							if(idx-1<0||map[idx-1][y]=='#') 
								break;
							if(map[idx-1][y]=='*') {
								map[idx-1][y] = '.';
								break;
							}
							idx--;
						}
						break;
					case(2):
						idx=x;
						while(true) {
							if(idx+1>=H||map[idx+1][y]=='#') 
								break;
							if(map[idx+1][y]=='*') {
								map[idx+1][y] = '.';
								break;
							}
							idx++;
						}
						break;
					case(3):
						idx=y;
						while(true) {
							if(idx-1<0||map[x][idx-1]=='#') 
								break;
							if(map[x][idx-1]=='*') {
								map[x][idx-1] = '.';
								break;
							}
							idx--;
						}
						break;
					case(4):
						idx=y;
						while(true) {
							if(idx+1>=W||map[x][idx+1]=='#') 
								break;
							if(map[x][idx+1]=='*') {
								map[x][idx+1] = '.';
								break;
							}
							idx++;
						}
						break;
					}
				}
			}
			
			System.out.print("#"+t+" ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
