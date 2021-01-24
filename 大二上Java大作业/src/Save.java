import java.io.*;
public class Save {
    public String name,text,add;
    public Save(String s,String s1,String s2)
    {
        name=s;
        text=s1;
        add=s2;
    }
    public  void save()
    {

        File f=new File(add,name);//指定地址，以及文件名
        if(!f.exists())//如果文件名不存在则创建一个，若文件存在则覆盖
        {
            try
            {
                f.createNewFile();
            }catch(IOException e1)
            {

            }
        }
        try
        {
            //FileWriter fw=new FileWriter(f,true);//从文件末尾加入数据
            FileWriter fw=new FileWriter(f);//直接覆盖数据
            try
            {
                fw.write(text);


            }catch(Exception e5)
            {

            }
            finally
            {
                fw.close();
            }
        }catch(Exception e6)
        {

        }
    }
}
