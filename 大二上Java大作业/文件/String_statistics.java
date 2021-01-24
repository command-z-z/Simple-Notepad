import java.io.*;//导入io包
public class String_statistics{//定义一个统计（Statistics）类
    static String strLine;//读取文本的每一行
    static char letter[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','G','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};//含52个字符的数组
    static int total[]=new int[26];//动态申请数组，用于统计26个字母每个字母开头的单词数
    public static void main(String args[]){
        try{
            FileReader fr=new FileReader("/Users/apple/Desktop/java2/src/story.txt");//创建FileReader对象，用来读取字符流
            BufferedReader br=new BufferedReader(fr); //缓存指定文件的输入
            StringBuffer str=new StringBuffer();//将读入的每一行拼接在一起  StringBuffer为可变字符串类型
            while(br.ready()){
                strLine=br.readLine();	//读入一行数据
                strLine=strLine.replace(',',' ');//将逗号替换成空格
                strLine=strLine.replace('.',' ');//将句号替换成空格
                strLine=strLine.replace('?',' ');//将问号替换成空格
                strLine=strLine.replace('!',' ');//将感叹号替换成空格
                strLine=strLine.replace(':',' ');//将封号替换成空格
                strLine=strLine.replace('(',' ');//将左括号替换成空格
                strLine=strLine.replace(')',' ');//将右括号替换成空格
                strLine=strLine.replace(" – "," ");//将连接符替换成空格
                //注意：此时还未处理单引号
                str.append(strLine);//将每一行数据进行拼接
            }
            br.close();//关闭缓存流
            fr.close();//关闭字符流
            //-------------------------------------------------------------------------
            String a= str.toString();//类型转换 将StringBuffer转化为不可变的String
            String split[] = a.split(" ");//按空格进行拆分a,将每个单词存在split数组中
            int len=split.length;//len为单词总数
            for(int i=0;i<len;i++){
                if(split[i].length()>0&&split[i].charAt(0)=='\'')//判断每个单词首部字母是否是单引号
                    split[i]=split[i].replace("'"," ");	//如果是，就用空格将其替代replace为全部替代'
            }//比如'history'首先要去掉前面和后面的'
            //---------------------------------------------------------------------------------
            //---------------------------------单词总数------------------------------------------
            System.out.println();
            int num=0;
            for(int i=0;i<len;i++){//统计单词数
                if(split[i].length()>0)//判断单词长度是否大于0
                    num++;//若是，则加1
            }
            System.out.println("The total number of words is "+num);//输出结果
            //---------------------------------首字母--------------------------------------------
            for(int i=0;i<len;i++){//检验所有单词
                for(int j=0;j<52;j++)//52个字母（大小写），每一个字母都进行一次匹配
                    if(split[i].length()>0&&split[i].charAt(0)==letter[j])//单词长度大于0且首字母等于某个字母
                        total[j%26]++;//该字母数量加一，注意：a与A是同一个字母
            }
            System.out.println();
            for(int i=0;i<26;i++){//输出所有字母的数量
                System.out.println("The number of words at the beginning of "+letter[i]+" letter is "+total[i]);
            }
            //---------------------------------长度为3的单词数--------------------------------------
            int count1=0;
            for(int i=0;i<len;i++){
                if(split[i].length()==3)//判断单词长度是否为3
                    count1++;//计数器加1
            }
            System.out.println();//输出结果
            System.out.println("The total number of words with length 3 is "+count1);
            //-----------------------------------or的数量----------------------------------------------
            int length=str.length();//用未拆分前的的str的长度，方便使用
            int count=0;
            for(int i=0;i<length-1;i++)//对所有字母进行判断
            {
                if(str.charAt(i)=='o'&&str.charAt(i+1)=='r')//前一个字母为'o'且后一个字母为'r'
                    count++;	  //计数器加1
            }
            System.out.println("The total number of 'or' is "+count);//输出结果
        }
        catch(IOException e){//输入输出流出现问题，则抛出异常
            e.printStackTrace();
        }
    }
}

