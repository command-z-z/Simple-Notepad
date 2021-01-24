import javax.swing.*;    // 引入类库
import java.awt.*;
import java.awt.event.*;
public class MyColor{
    JFrame jfrm = new JFrame("颜色选择器");
    Container ct = jfrm.getContentPane();
    JColorChooser jcc = new JColorChooser();

    public Color ColorWay(){
        Color mycolor = jcc.showDialog(jfrm, "Swing Color Chooser", Color.yellow);
        return mycolor;
    }
}