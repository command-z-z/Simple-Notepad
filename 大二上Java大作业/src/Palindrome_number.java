import javax.swing.*;

public class Palindrome_number {

    public int pandaun1(String ss){
        int flag=0;//0为回文数,2为输入错误
        if (CheckType(ss) == 1) {
            int t = Integer.parseInt(ss);
            if (t>99 && t == reverse(t)){
                    flag=0;
                }
            else
                    flag=1;
            }
        else if (CheckType(ss) == 0)
            flag=2;
        return flag;
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
