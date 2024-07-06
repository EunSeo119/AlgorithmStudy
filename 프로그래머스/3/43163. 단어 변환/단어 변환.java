import java.util.*;

class Solution {
    // 2차원 배열로 변환 할 수 있는 단어들 체크 배열만들어서 bfs로 변환 방법 셈
    public int solution2(String begin, String target, String[] words) {
        int answer = 0;
        int len = words.length;
        int[][] arr = new int[len][len];
        boolean[] visited = new boolean[len];
        
        for(int i = 0; i < len; i++) {
            String word = words[i];
            int check = word.length();
            for(int j = 0; j < len; j++) {
                if(word.equals(words[j])) continue;
                
                for(int k = 0; k < word.length(); k++) {
                    word = words[i];
                    String[] A = word.split("");
                    String checkWord = words[j];
                    String[] B = checkWord.split("");
                    A[k] = B[k];
                    word = String.join("", A);
                    if(word.equals(checkWord)) {
                        arr[i][j] = 1;
                        break;
                    }
                }
                
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        for(int j = 0; j < len; j++) {
            for(int k = 0; k < begin.length(); k++) {
                String word = begin;
                String[] A = word.split("");
                String checkWord = words[j];
                String[] B = checkWord.split("");
                A[k] = B[k];
                word = String.join("", A);
                if(word.equals(checkWord)) {
                    queue.offer(new int[] {j, 0});
                }
            }
        }
        
        int targetIdx = Arrays.asList(words).indexOf(target);
        
        int depth = 0;
        int result = 0;
        boolean isExisted = false;
        while(!queue.isEmpty()) {
            int[] currents = queue.poll();
            int current = currents[0];
            
            if(current == targetIdx) {
                isExisted = true;
                result = currents[1];
                break;
            }
            
            for(int i = 0; i < len; i++) {
                if(arr[current][i] == 1 && !visited[i]) {
                    queue.offer(new int[] {i, currents[1]+1});
                    visited[i] = true;
                }
            }
            
            depth++;
        }
        
        if(!isExisted) return 0;
        
        return result+1;
    }
    
    // 체크 배열 만들지 않고 더 간단한 풀이!!
    static class Node {
        String next;
        int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int n = words.length, ans = 0;

        Queue<Node> q = new LinkedList<>();


        boolean[] visit = new boolean[n];
        q.add(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                ans = cur.edge;
                break;
            }

            for (int i=0; i<n; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return ans;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++ cnt > 1) return false;
            }
        }

        return true;
    }
}