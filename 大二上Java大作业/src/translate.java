import javax.swing.JOptionPane;
public class translate {
    /*
    输入数据类型说明：数字flag=2，英文flag=1，错误flag=0
     */
    public String panduan(String ss)
    {
        if (CheckType(ss) == 1)
        {
            return StringToNum(ss);
        }
        else if (CheckType(ss) == 2)
        {
            return NumToString(ss);
        }
        else
            return "输入错误，请按要求输入";
    }
    public static int CheckType(String ss)
    {
        int flag=0;
        int i,j;
        //进行简单的英文判断，非英文字符返回0报错
        for(j=0;j<ss.length();j++)
        {
            if((ss.charAt(j)==' ')||(ss.charAt(j)>='a'&&ss.charAt(j)<='z'))
            {
                if(ss.length()!=(j+1)) continue;
                else
                {
                    return flag=1;
                }
            }
            break;
        }
        //进行简单的数字判断，非纯数字会返回0报错
        for(i=0;i<ss.length();i++)
        {
            if(ss.charAt(i)>='0'&&ss.charAt(i)<='9')
            {
                if(ss.length()!=(i+1)) continue;
                else
                {
                    return flag=2;
                }
            }
            break;
        }
        return flag;
    }
    public static String  NumToString(String ss) {
        String x[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String y[] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String z[] = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String s="";
        int t = Integer.parseInt(ss);
        if (t >= 0 && t < 10) {
            s=x[t];
        } else if (t >= 10 && t < 20) {
            s=y[t - 10];
        } else if (t >= 20 && t < 100) {
            s=z[t / 10 - 2]+" "+x[t % 10];
        }
        else{
            s="输入错误，请按要求输入";
        }
        return s;
    }
    public static String StringToNum(String ss) {
        String x[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String y[] = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String z[] = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        /*对于英文首先要判断它是否有空格进行分类flag=0没有空格，flag=1有空格
         */
        String s1="",s2="";
        String s="";
        int i;
        int flag=2;//对于空格的判断,默认为2
        //先判断是否有空格，有则置flag=1，没有flag=0;
        for( i=0;i<ss.length();i++)
        {
            if(ss.charAt(i)==' ')
            {
                flag=1;
                break;
            }
            else flag=0;
        }
        if(flag==0)//没有空格
        {
            boolean p=true;
            int l;//判断从0～19
            for(l=0;l<10;l++)
            {
                if(ss.equals(x[l]))
                {
                    s=Integer.toString(l);
                    p=false;
                    break;
                }
                else if(ss.equals(y[l]))
                {
                    s=Integer.toString(l+10);
                    p=false;
                    break;
                }
            }
            int k;//判断是10的倍数时
            for(k=0;k<8;k++)
            {
                if(ss.equals(z[k]))
                {
                    s=Integer.toString(10*(k+2));
                    p=false;
                    break;
                }
            }
            if(p)
                s="输入错误，请按要求输入";
        }
        if(flag==1)//有空格
        {
            int input=0;
            int st=0;//判断步数
            s1=ss.substring(0, i);
            s2=ss.substring(i+1, ss.length());
            for(int j=0;j<8;j++)
            {
                if(s1.equals(z[j]))//匹配十位数
                {
                    input=10*(j+2);
                    st++;
                    break;
                }
            }
            for(int k=0;k<10;k++)
            {
                if(s2.equals(x[k]))
                {
                    input+=k;
                    st++;
                    break;
                }
            }
            if(input!=0 && st==2)//s表示两步都执行了，避免sss one这种输入出现时的错误
                s=Integer.toString(input);
            else
                s="输入错误，请按要求输入";
        }
        return s;
    }
}