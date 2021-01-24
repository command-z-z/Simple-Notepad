import javax.swing.JProgressBar;//导入相关包
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;
import javax.swing.*;
import java.io.*;
public class text_file {
    static String strLine;//定义一个String类型的变量，每次读取一行
    public static void main(String[] args) {
        try{
            long start=System.currentTimeMillis();//获取当前时间
            FileReader fr=new FileReader("/Users/apple/Desktop/java2/src/05test.txt");//文本文件(test.txt)以参数形式输入，读取字符流
            BufferedReader br=new BufferedReader(fr);//缓冲指定文件输入
            int lineCount=0;//统计文件的行数
            while(br.ready()){
                strLine=br.readLine();//读取一行
                lineCount++;//记录行数
            }
            fr.close();//关闭流
            br.close();//关闭流
            //-----------------------------------------------------------------------------------------------
            JFrame frm=new JFrame("正在读取中");//定义一个JFrame对象
            final JProgressBar aJProgressBar=new JProgressBar(0,lineCount);//设定进度条的范围（0~lineCount）
            aJProgressBar.setStringPainted(true);//显示进度字符串
            aJProgressBar.setBackground(Color.white);//设置背景为白色
            aJProgressBar.setForeground(Color.blue);//设置进度条进度为蓝色

            frm.setSize(480,150);//设置框架大小
            Toolkit tk=Toolkit.getDefaultToolkit();
            Dimension dm=tk.getScreenSize();//获取屏幕大小
            frm.setLocation((int)(dm.getWidth()-frm.getWidth())/2,(int)(dm.getHeight()-frm.getHeight())/2);//框架居中

            frm.add(aJProgressBar,BorderLayout.NORTH);//进度条设置在框架北面
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户发起close时，程序的默认操作，结束窗体所在的应用程序
            frm.setVisible(true);//进度条可视
            //---------------------------------------------------------------------------------------------------
            //当前正在计算变量V2...2/10
            FileReader f=new FileReader("/Users/apple/Desktop/java2/src/05test.txt");//文本文件(test.txt)以参数形式输入，读取字符流
            BufferedReader b=new BufferedReader(f);//缓冲指定文件输入
            int count=0;//记录读取的行数
            double sum=0;//统计变量之和
            JTextField jf=new JTextField();//定义一个文本框
            frm.add(jf,BorderLayout.CENTER);//将文本框添加
            frm.setVisible(true);//框架可视

            while(b.ready()){
                count++;//当前读取所在行数
                strLine=b.readLine();//读取一行
                String s[]=strLine.split("=");//按“=”将每一行分开
                double d=Double.parseDouble(s[1]);//将等号右侧的数据转换为double型
                sum=sum+d;//计算变量的和
                //----------------------------------------------
                long end=System.currentTimeMillis();//每读一行，获取一次时间
                try{
                    Thread.sleep(1);//线程休眠一毫秒
                }
                catch(InterruptedException ignoreException){
                };
                double time=(double)(end-start)/1000;//文本读取已用时间
                double time1=((double)(lineCount-count)/count)*time;//文本读取大约剩余时间
                jf.setText("当前正在计算变量"+s[0]+"..."+count+"/"+lineCount+"  " +//更新文本框内容
                        "        已经使用"+String.format("%.1f",time)+"s"+"      大约还需要"+String.format("%.1f",time1)+"s");
                int value=aJProgressBar.getValue();//获取进度条当前进度
                aJProgressBar.setValue(value+1);//进度加一
            }
            frm.dispose();//全部读取完毕，框架消失
            System.out.print(String.format("%.2f",sum));//输出所有变量值的总和
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

