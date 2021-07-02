/* Prepared By : Pai Najranabanu */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;
public class FileHandling {
    static Scanner s=new Scanner(System.in);
    static Scanner s1=new Scanner(System.in);
    static File f=null;
    static FileWriter fw;
    static FileReader fr;
    static String fname=new String();
    static String fco=new String();
    static char c;
 public static void main(String[] args) throws Exception {
    int choice ;
	do
	{
		System.out.println("\t1: Create File");
		System.out.println("\t2: Read File");
		System.out.println("\t3: Append Text in to File..");
		
		System.out.print("\n Select Your Choice : " );
		choice=s.nextInt();
     switch(choice)
         {
             case 1: createfile();break;
             case 2: readfile();break;
             case 3: appendfile();break;
         }
        System.out.print("\n\t Do you want to continue ?  :  " );
     		c=s.next().charAt(0);
         fname=null;
	}while(c=='Y' || c=='y');
}

private static void filename() {
     System.out.print("\n Without any extension:");
     System.out.print(" Enter File Name:");
     fname=s.next();
     fname=fname + ".txt";
}

private static void appendfile() {
    filename();
    f=new File(fname);
    if(f.exists())
    {
      System.out.print("\n Enter Content :");
      fco=s1.nextLine();
      try {
        
         fw=new FileWriter(fname,true);
         fw.write(fco);
         fw.close();
        
       }
      catch (IOException e)
      {  
         e.printStackTrace();
      }
    }
    else
     {
      System.out.print("\n File does not exist..: ");
      System.out.print("Do you want to create a File : Y/N?  ");
      c=s.next().charAt(0);
      if(c=='Y' || c=='y') createfile();
     }
}
private static void readfile() {
     filename();
     f=new File(fname);
     if(f.exists())
     {
     System.out.print("\n File contains :  ");
     try {
      fr=new FileReader(fname);
      int i;
      while((i=fr.read())!=-1)
        {
          System.out.print((char)i);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    else
    {
      System.out.print("\n File does not exist..: ");
      System.out.print("Do you want to create a File : Y/N?  ");
      c=s.next().charAt(0);
      if(c=='Y' || c=='y') createfile();

    }
  } 

private static void createfile() {
	if(f==null)
	{
     filename();
	}
     f=new File(fname);
     //fname=f.getAbsolutePath()+fname;
    // System.out.println(fname);
     try {
        if(f.createNewFile())
          {
            System.out.print("\n Enter File Content:");
            fco=s1.nextLine();
            fw=new FileWriter(fname, Charset.forName("UTF8"));
            fw.write(fco);
            fw.close();
          }
          else if(f.exists())
          {
            System.out.print("\n File Already exist..");
           // System.out.print((char)27 + "[30;0m");
            System.out.print("Do You want to Delete existing File:Y/N?  ");
            c=s.next().charAt(0);
             
            if(c=='Y' || c=='y')
            {
              if(f.delete())
              {
                 System.out.print("\n File Deleted.., Create Again Y/N? : ");
                 c=s.next().charAt(0);
                 if(c=='Y' || c=='y')
                 {

                  f.createNewFile();
                  System.out.print("\n Enter File Content:");
                  fco=s1.nextLine();
                  fw=new FileWriter(fname, Charset.forName("UTF8"));
                  fw.write(fco);
                  fw.close();
                 }
              }
            }

          }
    } catch (IOException e) {
         
        e.printStackTrace();
    }
  }
}