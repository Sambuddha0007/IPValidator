package IPValid;

import java.io.*;
import java.util.*;
import java.util.Scanner;

class IpValidator {
    public static boolean validate (String addr)
    {

        boolean v=false;
        int count=0;
        int a=0;
        String dup="";
        int vcount=0;
        for(int val=0;val<addr.length();val++)
        {
            if(addr.charAt(val)=='.')
            {
                vcount++;
            }
        }

        if(  vcount==3&&  addr.length()>=7 && addr.length()<=15 && addr.charAt(0)!='.' && addr.charAt(addr.length()-1)!='.')
        {
            for(int i=0;i<addr.length();i++)
            {

                if(addr.charAt(i)!='.')
                {
                    dup+=addr.charAt(i);
                }
                if( addr.charAt(i)!='.' && !Character.isDigit(addr.charAt(i)))
                {
                    break;
                }
                if(addr.charAt(i)=='.')
                {

                    a= Integer.parseInt(dup);
                    if(a>255 && count<3)
                    {
                        break;
                    }

                    else{
                        a=0;
                        dup="";
                    }
                    count++;


                }
                if(i==addr.length()-1 &&count==3)
                {
                    a= Integer.parseInt(dup);
                    if(a<=255 &&a>=0)
                    {
                        v=true;
                    }
                }
            }
        }

        return v;

    }

    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        String ipaddr;
        System.out.println("Please enter your IP address...");
        ipaddr=sc.next();
        System.out.println(validate(ipaddr));
    }
}