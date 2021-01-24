import javax.swing.JOptionPane;
public class Palindrome_number {
    public static void main(String[] args) {
        System.out.println("输入quit退出程序");
        while (true) {
            String ss = JOptionPane.showInputDialog("请输入大于99的任意一个正整数", "");
            if (ss.equals("quit")) {
                System.out.print("see you again");
                break;
            }
            else if (CheckType(ss) == 1) {
                int t = Integer.parseInt(ss);
                if (t>99 && t == reverse(t)){
                    System.out.println("输入的数是回文数");
                }
                else
                    System.out.println("输入的数不是回文数");
            }
            else if (CheckType(ss) == 0)
                System.out.println("error,please input again");
        }
    }
    public static int CheckType(String ss)//数字判断
    {
        int flag=0;
        int i;
        //进行简单的数字判断，非纯数字会返回0报错
        for(i=0;i<ss.length();i++)
        {
            if(ss.charAt(i)>='0'&&ss.charAt(i)<='9')
            {
                if(ss.length()!=(i+1)) continue;
                else
                {
                    return flag=1;
                }
            }
            break;
        }
        return flag;
    }
    public static int reverse(int input){//对是否是回文数进行判断
        int output=0;
        while (input>0)
        {
            output=output*10+input%10;
            input/=10;
        }
        return output;
    }
}
