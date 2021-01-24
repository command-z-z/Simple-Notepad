public class Prime {
    public static void main(String[] args) {
        int j, s = 0;
        for (int i = 100; i <= 200; i++) {//找到100～200中的所有素数
            j = 2;
            while (i % j != 0) {
                j++;
                if (j == i) {
                        System.out.print(i + " ");
                        s++;
                    if(s%10==0){
                        System.out.println("");
                    }
                }
            }
        }
    }
}
