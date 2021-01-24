import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JColorChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyFrame extends JFrame implements ActionListener {
    //**********************************************
    //以下为成员变量（对象）的定义;
    //定义菜单
    boolean modified =false;//用来判断文本框内容是否修改
    JMenuBar mb = new JMenuBar();   //菜单栏
    FgMenu mFile = new FgMenu("文件(F)", KeyEvent.VK_F),
            mJavaProblem = new FgMenu("Java上机题目"),
            mMailList = new FgMenu("通讯录(C)", KeyEvent.VK_C);
    JMenuItem miNew = new JMenuItem("新建(N)", KeyEvent.VK_N),
            miOpen = new JMenuItem("打开(O)", KeyEvent.VK_O),
            miSave = new JMenuItem("保存(S)", KeyEvent.VK_S),
            miFont = new JMenuItem("字体(F)", KeyEvent.VK_F),
            miColour = new JMenuItem("背景颜色（B）", KeyEvent.VK_B),
            miQuit = new JMenuItem("退出(X)", KeyEvent.VK_X),
            miPrime = new JMenuItem("素数判断"),
            miPalindrome_number = new JMenuItem("回文数"),
            miTranslate = new JMenuItem("数字与英文互译"),
            miString_statistics = new JMenuItem("统计英文数据"),
            miText_file = new JMenuItem("文本文件求和"),
            miMaintenance = new JMenuItem("通讯录维护");
    //文本框
    JTextArea ta = new JTextArea();
    //构造方法
    MyFrame(String sTitle) {
        super(sTitle);

        //添加组件。本例中直接添加菜单与JTextArea
        addMenus();
        //添加滚动条（JScrollPane）的文本编辑框JTextArea
        JScrollPane sp = new JScrollPane(ta);
        add(sp);

        //设置窗口大小
        setSize(800, 600);
        //设置close按钮的操作，本例中设置为
        //单击close按钮时退出程序,会显示是否退出窗口
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        //对窗口内容进行监听
        addWindowListener(new WindowAdapter() {//这个监听实现内部类完成
            //new 一个WindowAdapter 类 重写windowClosing方法
            // WindowAdapter是个适配器类 具体看jdk的帮助文档
            public void windowClosing(WindowEvent e) {
                //这里写对话框
                int flag=0;
                if(modified){
                    if(modified){
                        int value0 = JOptionPane.showConfirmDialog(null, "文本框中有文本是否先保存", "提示框",JOptionPane.YES_NO_CANCEL_OPTION);
                        if(value0==0){//是，则保存文件
                            Save();
                            ta.setText("");//清空文本
                            modified=false;
                        }
                        if(value0==1){//否，则清空文本框
                            ta.setText("");
                            modified=false;
                        }
                        if(value0==2){//取消,则什么也不操作
                            flag=1;
                        }
                    }
                }
                if(flag==0){
                    int value = JOptionPane.showConfirmDialog(null, "确定要退出系统吗？", "Java程序设计综合实验", JOptionPane.WARNING_MESSAGE);
                    if (value == 0) {//即按确定按钮程序会退出
                        System.exit(0);
                    }
                }
            }
        });
        //使窗口在显示屏居中显示
        centerWindow();
    }

    //添加菜单
    private void addMenus() {
        setJMenuBar(mb);
        //文件菜单
        mFile.add(miNew);
        mFile.add(miOpen);
        mFile.add(miSave);
        mFile.addSeparator();//显示一条分割条
        mFile.add(miFont);
        mFile.add(miColour);
        mFile.addSeparator();//显示一条分割条
        mFile.add(miQuit);
        //Java上机题目菜单
        mJavaProblem.add(miPrime);
        mJavaProblem.add(miPalindrome_number);
        mJavaProblem.add(miTranslate);
        mJavaProblem.add(miString_statistics);
        mJavaProblem.add(miText_file);
        //通讯录菜单
        mMailList.add(miMaintenance);
        //主菜单栏
        mb.add(mFile);
        mb.add(mJavaProblem);
        mb.add(mMailList);
        //对文本框进行监听
        ta.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void changedUpdate(DocumentEvent event) {
                modified=true;//内容发生改变
            }

            @Override
            public void insertUpdate(DocumentEvent event) {
                modified=true;//内容发生了插入
            }

            @Override
            public void removeUpdate(DocumentEvent event) {
                modified=true;//内容发生移除
            }

        });

        //对所有按钮进行监听
        miNew.addActionListener(this);
        miOpen.addActionListener(this);
        miSave.addActionListener(this);
        miFont.addActionListener(this);
        miColour.addActionListener(this);
        miQuit.addActionListener(this);
        miPrime.addActionListener(this);
        miPalindrome_number.addActionListener(this);
        miText_file.addActionListener(this);
        miTranslate.addActionListener(this);
        miString_statistics.addActionListener(this);
        miMaintenance.addActionListener(this);
    }

    //窗口居中
    public void centerWindow() {
        //获得显示屏桌面窗口的大小
        Toolkit tk = getToolkit();
        Dimension dm = tk.getScreenSize();
        //让窗口居中显示
        setLocation((int) (dm.getWidth() - getWidth()) / 2, (int) (dm.getHeight() - getHeight()) / 2);
    }

    //保存，实现文件夹选择
    public void Save(){
        try {
            JFileChooser c = new JFileChooser();
            int result = c.showSaveDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                File fi = c.getSelectedFile();
                String s=c.getName(fi);
                String s2=fi.getAbsolutePath();
                String s3="/"+s;
                String s4=s2.replace(s3,"");
                String s1=ta.getText();//s1为文本框中所有内容
                System.out.println(s+" "+s1+" "+s2);
                Save save1=new Save(s+".java",s1,s4);
                save1.save();
            }
        } catch (HeadlessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int flag=0;
        if (e.getSource() == miQuit) {//退出按钮监听
            if(modified){
                int value0 = JOptionPane.showConfirmDialog(null, "文本框中有文本是否先保存", "提示框",JOptionPane.YES_NO_CANCEL_OPTION);
                if(value0==0){//是，则保存文件
                    Save();
                    ta.setText("");//清空文本
                    modified=false;
                }
                if(value0==1){//否，则清空文本框
                    ta.setText("");
                    modified=false;
                }
                if(value0==2){//取消,则什么也不操作
                    flag=1;
                }
            }
            if(flag==0) {
                int value = JOptionPane.showConfirmDialog(null, "确定要退出系统吗？", "Java程序设计综合实验", JOptionPane.WARNING_MESSAGE);
                if (value == 0) {//即按确定按钮程序会退出
                    System.exit(0);
                }
            }
        }
        if(e.getSource()==miNew){
            if(modified){//判断当文本框是否被修改
                int value2 = JOptionPane.showConfirmDialog(null, "文本框中有文本是否先保存", "提示框",JOptionPane.YES_NO_CANCEL_OPTION);
                if(value2==0){//是，则保存文件
                    Save();
                    ta.setText("");//清空文本
                    modified=false;
                }
                if(value2==1){//否，则清空文本框
                    ta.setText("");
                    modified=false;
                }
                if(value2==2){//取消,则什么也不操作
                }
            }
        }
        if(e.getSource()==miSave){
            // 获得容器
            int i=JOptionPane.showConfirmDialog(null, "确定保存？","这是一个确认对话框",JOptionPane.YES_NO_OPTION);
            if(i==0)
            {
                Save();

                JOptionPane.showMessageDialog(null,"保存成功","",JOptionPane.INFORMATION_MESSAGE);

            }
            if(i==1)// 取消保存则什么也不做
            {
            }
        }
        if(e.getSource()==miOpen){//打开按钮的监听
            int flag1=1;//用来判断在保存和不保存之后执行打开文件
            if(modified){//判断当文本框不为空的时候
                int value3 = JOptionPane.showConfirmDialog(null, "文本框中有文本是否先保存", "提示框",JOptionPane.YES_NO_CANCEL_OPTION);
                if(value3==0){//是，则保存文件
                    Save();
                    JOptionPane.showMessageDialog(null,"文件已保存成功","",JOptionPane.INFORMATION_MESSAGE);
                    ta.setText("");//先清空
                    modified=false;
                }
                if(value3==1){//否，则清空文本框
                    ta.setText("");
                    modified=false;
                }
                if(value3==2){//取消,则什么也不操作
                    flag1=0;//使其不进行打开操作
                    modified=false;
                }
            }
            if(flag1==1){
                JFileChooser jfc=new JFileChooser();//文件选择器
                jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
                jfc.showDialog(new JLabel(), "选择");
                File file=jfc.getSelectedFile();//得到选择的文件
                String s=file.getAbsolutePath();//得到文件的名字
                Open open1=new Open(s);         //通过文件地址打开
                String text=open1.open();

                ta.setText(text);//将文本显示在文本框中
                setTitle(jfc.getSelectedFile().getName()+"---"+file.getAbsolutePath());//更改主窗口标题
                JOptionPane.showMessageDialog(null,"打开成功","",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(e.getSource()==miColour){//背景颜色按钮
            MyColor c1=new MyColor();
            Color c=c1.ColorWay();
            ta.setBackground(c);
        }
        if(e.getSource()==miFont){//字体按钮
            MyFont frm1=new MyFont("系统字体实例");
            //设置文本框中字体颜色,有bug
           frm1.setVisible(true);
            ta.setForeground(frm1.getColor());
            ta.setFont(new Font(frm1.getName(),Font.PLAIN,frm1.getFontSizeWay()));
        }
        if(e.getSource()==miPrime){
            PrombleFrame1 frm=new PrombleFrame1("素数判断");
            frm.setVisible(true);
        }
        if(e.getSource()==miPalindrome_number){
            PrombleFrame2 frm=new PrombleFrame2("回文数判断");
            frm.setVisible(true);
        }
        if(e.getSource()==miTranslate){
            PrombleFrame3 frm=new PrombleFrame3("数字与英文互译");
            frm.setVisible(true);
        }
        if(e.getSource()==miString_statistics){
            PrombleFrame4 frm=new PrombleFrame4("统计英文数据");
            frm.setVisible(true);
        }
        if(e.getSource()==miText_file){
            PrombleFrame5 frm=new PrombleFrame5("文本文件求和");
            frm.setVisible(true);
        }
        if(e.getSource()==miMaintenance){
            PhoneFrame frm=new PhoneFrame("通讯录");
            frm.setVisible(true);
        }
    }
}
//自定义菜单,从JMenu下继承
class FgMenu extends JMenu{
    public FgMenu(String label){
        super(label);
    }
    public FgMenu(String label,int nAccelerator){
        super(label);
        setMnemonic(nAccelerator);
    }
}
