package niu;

import java.util.Scanner;

public class CaiShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        long ans = 1;
        boolean[] visited = new boolean[len + 1];
        for (int i = 2; i <= len; i++) {
            if (visited[i]){
                continue;
            }
            for (int j = 2 * i; j <= len; j += i){
                visited[j] = true;
            }
            int count = 0;
            //int会溢出
            long k = i;
            while (k <= len) {
                k *= i;
                count++;
            }
            ans = ans * (count + 1) % 1000000007;
        }
        System.out.println(ans);
    }
}