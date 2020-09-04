package acm;

/**
 * @Author: Jeremy
 * @Date: 2018/10/5 21:38
 */

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    private static int n;
    private static int m;
    private static List<Integer> seq = new Vector<Integer>();
    private static class Operation{
        int type;
        int l;
        int r;
        int x;
    }
    static List<Operation> operationList = new ArrayList<Operation>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int line = 0;  // 记录行数
        while(str != null){
            if(line != 0 && line == 2 + m){
                break;
            }
            String[] arr = str.trim().split(" ");
            int col = 0;
            for (String s : arr){
                int num = Integer.parseInt(s);
                if(line == 0){
                    if(col == 0){
                        n = num;
                    } else{
                        m = num;
                    }
                }

                if(line == 1){
                    seq.add(num);
                }

                if(line > 1){
                    if(col == 0){
                        Operation operation = new Operation();
                        operation.type = num;
                        operationList.add(operation);
                    }
                    if(col == 1){
                        operationList.get(line-2).l = num;
                    }
                    if(col == 2){
                        operationList.get(line-2).r = num;
                    }
                    if(col == 3){
                        operationList.get(line-2).x = num;
                    }
                }
                col++;
            }

            str = br.readLine();
            line++;
        }


        for (Operation operation : operationList){

            int type = operation.type;
            int l = operation.l-1;
            int r = operation.r-1;
            int x = operation.x;

            if(type == 1){
                int sum = 0;
                for(int i=l; i<=r; i++){
                    int num = seq.get(i);
                    sum += num;
                }
                System.out.println(sum);
            }

            if(type == 2){
                int sum = 0;
                for(int i=l; i<=r; i++){
                    int num = seq.get(i);
                    sum += num * num;
                }
                System.out.println(sum);
            }

            if(type == 3){
                for(int i=l; i<=r; i++){
                    int num = seq.get(i);
                    seq.set(i, num*x);
                }
            }

            if(type == 4){
                for(int i=l; i<=r; i++){
                    int num = seq.get(i);
                    seq.set(i, num+x);
                }
            }
        }
    }

}