import javax.swing.JOptionPane;
public class Prime {
    public  int panduan(String ss) {
        int flag = 0;
        if (CheckType(ss) == 1) {
            int t=Integer.parseInt(ss);
            for (int i = 2; i <= Math.sqrt(t); i++) {
                if (t % i == 0) {flag++;break;}
            }
        }
        else if (CheckType(ss) == 0)
            flag=-1;

        return flag;//flag==0说明是素数
    }
        public int CheckType(String ss)//数字判断
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

}