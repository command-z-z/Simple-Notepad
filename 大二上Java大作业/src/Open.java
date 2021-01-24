import java.io.*;
public class Open {
    String name;
    String text="";
    public Open(String s)
    {
        name=s;
    }
    public String open()
    {

        try
        {
            FileReader fr=new FileReader(name);//name 代表文件地址
            BufferedReader br=new BufferedReader(fr);
            String strLine;

            try
            {
                while(br.ready())
                {
                    strLine=br.readLine();//一行一行的读取
                    text=text+strLine+"\n";//添加换行符使得文本正确输出
                }

            }catch(Exception e)
            {

            }
            finally
            {
                br.close();
                fr.close();
            }
        }
        catch(Exception e8)
        {

        }

        return text;
    }


}
