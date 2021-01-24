import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PhoneFrame extends JFrame {
    //12行6列的表格
    JTable table1=new JTable(100,6);

    //滚动条
    JScrollPane pane1=new JScrollPane(table1);

    //五个按钮
    JButton btn1=new JButton("添加");
    JButton btn2=new JButton("删除");
    JButton btn3=new JButton("修改");
    JButton btn4=new JButton("查询");
    JButton btn5=new JButton("关闭");

    //四个盘
    JPanel pan1=new JPanel(new GridLayout(0,1));

    JPanel pan2=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel pan3=new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JPanel pan4=new JPanel(new FlowLayout());

    PhoneFrame(String sTitle){
        super(sTitle);

        //对表格线进行设置
        table1.setGridColor(Color.BLACK);

        BorderLayout g1=new BorderLayout();
        setLayout(g1);
        //第一个盘子
        pan1.setPreferredSize(new Dimension(600,250));
        pan1.add(pane1);
        add(pan1,"Center");

        //第二个盘子
        pan2.add(btn1);
        pan2.add(btn2);
        pan2.add(btn3);
        pan2.add(btn4);

        //第三个盘子
        pan3.add(btn5);

        //第四个盘子
        pan4.add(pan2);
        pan4.add(pan3);
        add(pan4,"South");

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {//这个监听实现内部类完成
            //new 一个WindowAdapter 类 重写windowClosing方法
            // WindowAdapter是个适配器类 具体看jdk的帮助文档
            public void windowClosing(WindowEvent e) {
                //这里写对话框
                dispose();//关闭窗口
            }
        });
        setSize(500,400);
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
