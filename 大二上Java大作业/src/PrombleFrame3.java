import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PrombleFrame3 extends JFrame {
    JLabel lbl1=new JLabel("请输入英文或数字：");
    JLabel lbl2=new JLabel("请按确定翻译结果：");
    JTextField tf1=new JTextField();
    JTextField tf2=new JTextField();
    JButton btn1=new JButton("确定");
    JButton btn2=new JButton("退出");
    JPanel pan1=new JPanel();
    JPanel pan2=new JPanel();
    JPanel pan3=new JPanel();

    PrombleFrame3(String sTile){
        super(sTile);


        GridLayout g1=new GridLayout(3,1,5,5);
        setLayout(g1);

        //第一个盘子
        pan1.setLayout(new BorderLayout());
        pan1.add(lbl1,BorderLayout.WEST);
        pan1.add(tf1,BorderLayout.CENTER);
        add(pan1);

        //第二个盘子
        pan2.setLayout(new BorderLayout());
        pan2.add(lbl2,BorderLayout.WEST);
        pan2.add(tf2,BorderLayout.CENTER);
        add(pan2);

        //按钮
        pan3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pan3.add(btn1);
        pan3.add(btn2);
        add(pan3);

        //按钮监听
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text1=tf1.getText();
                translate tr =new translate();
                String ss=tr.panduan(text1);
                tf2.setText(ss);
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();//关闭窗口
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