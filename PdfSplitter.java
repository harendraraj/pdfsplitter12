import java.io.*;
public class PdfSplitter {
    public static void main(String[]args){
        try{
            byte b[]= new byte[1000000];
            int x=1, j=0;
            InputStreamReader ins=new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(ins);

            System.out.println("Enter path of source or original file :");
            String path = br.readLine();

            FileInputStream fis = new FileInputStream(path);
            int read_bytes;
            while(fis.available()!=0){
                j = 0;
                String s = "";
                if(x<=9){
                    s = path+".00"+x;
                }
                else{
                    s = path+".0"+x;
                }
                FileOutputStream fos = new FileOutputStream(s);

                while(j<=50000000 && fis.available()!=0){
                    read_bytes = fis.read(b,0,1000000);
                    j =j+read_bytes;
                    fos.write(b,0,read_bytes);
                }
                System.out.println("part "+x+"created");
                        x++;
            }
            System.out.println("file splitted successfully....!!!");
            fis.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}