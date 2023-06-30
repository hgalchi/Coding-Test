import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MyArr[];
    static int CheckArr[];

    static int CheckSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result=0;

        CheckArr = new int[4];
        MyArr = new int[4];
        CheckSecret=0;
        char A[] = new char[S];
        //입력 문자열
        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        //부분문자열 조건
        for (int i = 0; i < 4; i++) {
            CheckArr[i] = Integer.parseInt(st.nextToken());
            // 조건중 충족하지 않아도 되는 문자는 check하지 않아도 된다.
            if (CheckArr[i] == 0) {
                CheckSecret++;
            }
        }
        //부분문자열 처음 받을 때 세팅
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }

        if(CheckSecret==4) Result++;

        //슬라이딩윈도우
        for (int i = P; i < S; i++) {
            int j=i-P;
            Add(A[i]);
            Remove(A[j]);
            if(CheckSecret==4) Result++;
        }

        System.out.println(Result);

    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if(MyArr[0]==CheckArr[0]) CheckSecret--;
                MyArr[0]--;
                break;
            case 'C':
                if(MyArr[1]==CheckArr[1]) CheckSecret--;
                MyArr[1]--;
                break;
            case 'G':
                if(MyArr[2]==CheckArr[2]) CheckSecret--;
                MyArr[2]--;
                break;
            case 'T':
                if(MyArr[3]==CheckArr[3]) CheckSecret--;
                MyArr[3]--;
                break;

        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                MyArr[0]++;
                if(MyArr[0]==CheckArr[0]) CheckSecret++;
                break;
            case 'C':
                MyArr[1]++;
                if(MyArr[1]==CheckArr[1]) CheckSecret++;
                break;
            case 'G':
                MyArr[2]++;
                if(MyArr[2]==CheckArr[2]) CheckSecret++;
                break;
            case 'T':
                MyArr[3]++;
                if(MyArr[3]==CheckArr[3]) CheckSecret++;
                break;

        }


    }
}
