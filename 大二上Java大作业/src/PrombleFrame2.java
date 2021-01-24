import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PrombleFrame2 extends JFrame{
    JLabel lbl1=new JLabel("请输入1-99999之间的整数");
    JTextField tf1=new JTextField();
    JButton btn1=new JButton("判断是否是回文数");

    PrombleFrame2(String sTitle){
        super(sTitle);

        GridLayout g1=new GridLayout(3,1,5,5);
        setLayout(g1);

        add(lbl1);
        add(tf1);
        add(btn1);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ss=tf1.getText();
                Palindrome_number pr=new Palindrome_number();
                if(pr.pandaun1(ss)==0){
                    JOptionPane.showMessageDialog(null, "是回文数","提示框",JOptionPane.INFORMATION_MESSAGE);
                }
                else if(pr.pandaun1(ss)==1){
                    JOptionPane.showMessageDialog(null, "不是回文数","提示框",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(null, "请按要求正确输入","提示框",JOptionPane.INFORMATION_MESSAGE);

            }
        });
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {//这个监听实现内部类完成
            //new 一个WindowAdapter 类 重写windowClosing方法
            // WindowAdapter是个适配器类 具体看jdk的帮助文档
            public void windowClosing(WindowEvent e) {
                //这里写对话框
                dispose();//关闭窗口
            }
        });
        setSize(400,300);
        centerWindow();
    }
    public void centerWindow() {
        //获得显示屏桌面窗口的大小
        Toolkit tk = getToolkit();
        Dimension dm = tk.getScreenSize();
        //让窗口居中显示
        setLocation((int) (dm.getWidth() - getWidth()) / 2, (int) (dm.getHeight() - getHeight()) / 2);
    }
}
