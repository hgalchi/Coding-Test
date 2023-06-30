import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int A[] = new int[N];
        int fix=0;
        int min=0;
        //수열 N 배열
        for (int i = 0; i < N; i++) {
            A[i]=i+1;
        }
        //고장난 신호등은 0의 값을 갖는다.
        for (int i = 0; i < B; i++) {
            A[Integer.parseInt(br.readLine())-1]=0;
        }
        //첫 세팅
        for (int i = 0; i < K; i++) {
            if(A[i]==0) min++;
        }

        fix=min;
        for (int i = K; i < N; i++) {
            int j=i-K;
            if(A[j]==0)fix--;
            if(A[i]==0)fix++;
            min=fix < min ? fix : min;
        }

        System.out.println(min);



    }
}
