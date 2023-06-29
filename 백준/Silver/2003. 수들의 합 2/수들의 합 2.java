import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        int count=0;
        int start_index=0;
        int end_index=0;

        long[] A = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        long sum = A[start_index];
        while (end_index < N) {
            if (sum == M) {
                //end_index3일때 +1로 4가됌
                count++; end_index++;
                //A[4]는 bound error가 난다.
                sum += A[end_index];
            } else if (sum>M) {
                sum -= A[start_index];
                start_index++;
            }else {
                end_index++;
                sum += A[end_index];
            }
        }
        System.out.println(count);

    }
}
