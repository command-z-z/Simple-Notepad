import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.security.PublicKey;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
public class MyFont extends JFrame{

    //两个按钮
    JButton btnOk =new JButton("确定");
    JButton btnCancel=new JButton("取消");
    JButton btnColor=new JButton("字体颜色");
    JPanel panButtons =new JPanel();

    //字体名称
    String fontName=".AppleSystemFont";
    JLabel lblFont=new JLabel("字体名称：",JLabel.LEFT);
    JPanel panFont=new JPanel();
    JComboBox cbFontFamily=new JComboBox();

    //字体大小
    int fontSize=20;
    JLabel lblFontSize=new JLabel("字体大小：",JLabel.LEFT);
    JComboBox cbFontSize=new JComboBox();
    JPanel panFontSize=new JPanel();

    //字体颜色
    Color c=Color.red;
    JPanel panColor=new JPanel();

    //字体预览
    JLabel lblFontPreview=new JLabel("字体预览：",JLabel.LEFT);
    JLabel lblTextPreview=new JLabel("Java字体预览区",JLabel.CENTER);
    JPanel panFontPreview=new JPanel();

    //返回值
    static  final int RETURN_OK=1,RETURN_CANCEL=2;
    private int miReturnValue=RETURN_CANCEL;
    //构造方法
    MyFont(String sTitle){
        super(sTitle);

        GridLayout gl=new GridLayout(5,1,5,5);
        setLayout(gl);

        //初始化字体框
        InitFonts();

        //字体名称
        panFont.setLayout(new BorderLayout());
        panFont.add(lblFont,BorderLayout.WEST);
        panFont.add(cbFontFamily,BorderLayout.CENTER);

        cbFontFamily.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fontNameItemStateChanged(e);
            }
        });
        add(panFont);

        //字体大小
        panFontSize.setLayout(new BorderLayout());
        panFontSize.add(lblFontSize,BorderLayout.WEST);
        panFontSize.add(cbFontSize,BorderLayout.CENTER);

        cbFontSize.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                fontSizeItemStateChange(e);
            }
        });
        add(panFontSize);

        //字体颜色
        panColor.setLayout(new BorderLayout());
        panColor.add(btnColor, BorderLayout.CENTER);
        add(panColor);

        //字体预览
        panFontPreview.setLayout(new BorderLayout());
        panFontPreview.add(lblFontPreview,BorderLayout.WEST);
        panFontPreview.add(lblTextPreview,BorderLayout.CENTER);
        lblTextPreview.setBorder(BorderFactory.createEtchedBorder());
        lblTextPreview.setOpaque(true);
        add(panFontPreview);

        //按钮设置
        panButtons.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panButtons.add(btnOk);
        panButtons.add(btnCancel);
        add(panButtons);

        //初始化下拉框
        cbFontFamily.setSelectedItem(fontName);
        cbFontSize.setSelectedItem(new Integer(fontSize).toString());

        //注册事件
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnActionPerformed(e);
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnActionPerformed(e);
            }
        });
        btnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnActionPerformed(e);
            }
        });

        //初始化字体预览
        lblTextPreview.setFont(new Font(fontName,Font.PLAIN,fontSize));

        //点击关闭时，仅关闭此小窗口
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

        centerWindow();//窗口居中
    }
    public void btnActionPerformed(ActionEvent e){
        if(e.getSource()==btnOk){
            miReturnValue=RETURN_OK;
            dispose();//关闭窗口
        }
        if(e.getSource()==btnCancel){
            miReturnValue=RETURN_CANCEL;
            dispose();//关闭窗口
        }
        if(e.getSource()==btnColor){
            MyColor c1=new MyColor();
            c=c1.ColorWay();
            if (c != null)
                lblTextPreview.setForeground(c);
        }
    }
    //选择字体名称
    public void fontNameItemStateChanged(ItemEvent e){
        fontName=cbFontFamily.getSelectedItem().toString();
        lblTextPreview.setFont(new Font(fontName,Font.PLAIN,fontSize));
    }
    //选择字体大小
    public void fontSizeItemStateChange(ItemEvent e){
        fontSize=Integer.parseInt(cbFontSize.getSelectedItem().toString());
        lblTextPreview.setFont(new Font(fontName,Font.PLAIN,fontSize));
    }
    //获取全部系统字体并填充至下框
    public void InitFonts(){
        GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontList=ge.getAvailableFontFamilyNames();
        for(int i=0;i< fontList.length;i++){
            cbFontFamily.addItem(fontList[i]);
        }
        for(int i=9;i<=72;i++){
            cbFontSize.addItem(new Integer(i).toString());
        }
    }
    //窗口居中
    public void centerWindow() {
        //获得显示屏桌面窗口的大小
        Toolkit tk = getToolkit();
        Dimension dm = tk.getScreenSize();
        //让窗口居中显示
        setLocation((int) (dm.getWidth() - getWidth()) / 2, (int) (dm.getHeight() - getHeight()) / 2);
    }
    //返回字体颜色
    public Color getColor(){ return c; }
    public String getFontNameWay(){return fontName;}
    public int  getFontSizeWay(){return fontSize;}
}
