package tools;

import java.util.Scanner;


public class Tools {

    Scanner scanner = new Scanner(System.in);

    public String scannerString(){
        String input=scanner.nextLine();
        while(input==null || input.equals("")){
            System.out.println("输入不合法，请重新输入");
            input=scanner.nextLine();
        }
        return input;


    }


    public int scannerInt(){
        String input=scanner.nextLine();
        while(input==null || input.equals("")){
            System.out.println("输入不合法，请重新输入");
            input=scanner.nextLine();
        }
        int num=-1;
        while(num==-1){
            try {
                num=Integer.parseInt(input);
            } catch(Exception e){
                System.out.println("输入错误，请输入数字");
                input=scanner.nextLine();
            }
        }
        return num;


    }
}
