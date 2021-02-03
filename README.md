# cnlp
1
import java.util.*;
public class crc{
    void div(int[] a, int k)
    {
        int[] gp ={1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
        for(int i=0;i<k;i++)
        {
            int count=0;
            if(a[i]==1)
            {
                for(int j=i;j<17+i;j++)
                {
                    a[j]=a[j]^gp[count++];
                }
            }
        }
    }
    public static void main(String[] args)
    {
        int[] a =new int[100];
        int[] b =new int[100];
        int len,k;
        crc ob=new crc();
        System.out.println("Enter the length of Data Frame:");
        Scanner sc=new Scanner(System.in);
        len=sc.nextInt();
        int flag=0;
        System.out.println("Enter the Message:");
        for(int i=0;i<len;i++)
        {
            a[i]=sc.nextInt();
        }
        for(int i=0;i<16;i++)
        { a[len++]=0;
        }
        k=len-16;
        for(int i=0;i<len;i++)
        { b[i]=a[i];
        }
        ob.div(a,k);
        for(int i=0;i<len;i++)
            a[i]=a[i]^b[i];
        System.out.println("Data to be transmitted: ");
        for(int i=0;i<len;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        System.out.println("Enter the Reveived Data: ");
        for(int i=0;i<len;i++)
        {
            a[i]=sc.nextInt();
        }
        ob.div(a, k);
        for(int i=0;i<len;i++)
        {
            if(a[i]!=0)
            {
                flag=1; break;
            }
        }
        if(flag==1)
            System.out.println("error in data");
        else
            System.out.println("no error");
    }

}



2

import java.io.*;
import java.util.Scanner;
public class bell
{
    public static void main(String args[])
    {
        int dist[]=new int[10];
        int n,i,j,k,flag=0;
        int cost[][]=new int[10][10];
        System.out.println("enter the no. of vertices");
        Scanner in= new Scanner(System.in);
        n=in.nextInt();
        System.out.println("enter the cost adjacency matrix");
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
            {
                cost[i][j]=in.nextInt();
                if(cost[i][j]==0)
                    cost[i][j]=999;
            }
        dist[1]=0;
        for(i=2;i<=n;i++)
        {
            dist[i]=999;
        }
        for(k=1;k<n;k++)
        {
            for(i=1;i<=n;i++)
            {
                for(j=1;j<=n;j++)
                {
                    if(cost[i][j]!=999)
                    {
                        if(dist[i]+cost[i][j]<dist[j])
                            dist[j]=dist[i]+cost[i][j];
                    }
                }
            }
        }
        System.out.println("the distance between source vertex and the other vertices");
        for(i=1;i<=n;i++)
            System.out.println("edge 1-->"+ i +"=" +dist[i]);
        for(i=1;i<=n;i++)
        {
            for(j=1;j<=n;j++)
            {
                if(cost[i][j]!=999)
                {
                    if(dist[i]+cost[i][j]<dist[j])
                        flag=1;
                    break;
                }
            }
        }
        if(flag==1)
            System.out.println("negative cycle is present");
        else
            System.out.println("there is no negative cycle");
    }
}



5
import java.util.*;
import java.math.*;
public class RSA
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int p,q,n,z,d=0,e,i;
        System.out.println("Enter the number to be encrypted and decrypted");
        int msg=sc.nextInt();
        double c;
        BigInteger msgback;
        System.out.println("Enter 1st prime number p");
        p=sc.nextInt();
        System.out.println("Enter 2nd prime number q");
        q=sc.nextInt();
        n=p*q;
        z=(p-1)*(q-1);
        System.out.println("the value of z = "+z);
        for(e=2;e<z;e++)
        {
            if(gcd(e,z)==1) // e is for public key exponent
            {
                break;
            }
        }
        System.out.println("the value of e = "+e);
        for(int k=e+1;k<n;k++)
            if((k *e)%z==1 )
            { d=k;
                break;
            }
        System.out.println("the value of d = "+d);
        c=(Math.pow(msg,e))%n;
        System.out.println("Encrypted message is : -");
        System.out.println(c);
//converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf (n);
//converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Derypted message is : -");
        System.out.println(msgback);
    }
    static int gcd(int e, int z)
    { if(e==0)
        return z;
    else
        return gcd(z % e, e);
    }
}



6
import java.util.Random;
import java.io.*;
import java.util.Scanner;
public class LB
{
    public static void main(String args[])
    {
        int bs,or,ip,cbs=0,w;
        System.out.println("\nEnter Bucket Size:");
        Scanner in=new Scanner(System.in);
        bs=in.nextInt();
        System.out.println("Enter Output Rate:");
//Scanner input=new Scanner(System.in);
        or=in.nextInt();
        System.out.println("InPut CurBuc Output Discarded");
        System.out.println("Size contains rate Bytes");
        for(int i=0;i<5;i++)
        {
            Random r = new Random();
            ip = r.nextInt(100);
            cbs+=ip;
            if(cbs>(bs+or))
            {
                w=cbs-(bs+or);
                System.out.println(ip +"\t "+ bs +"\t " + or+"\t " + w);
                cbs=bs;
            }
            else
            {
                if(cbs<or)
                    System.out.println(ip +"\t "+ cbs +"\t " + 0 +"\t " + 0);
                else
                {
                    cbs-=or;
                    System.out.println(ip +"\t "+ cbs +"\t " + or +"\t " + 0);
                }
            }
        }
    }}


4 
server

package udp;
import java.io.*;
import java.net.*;
public class server
{
    public static void main(String[] args)
    {
        DatagramSocket skt=null;
        try
        {
            skt=new DatagramSocket(6888);
            byte[] buffer = new byte[1000];
            while(true)
            {
                DatagramPacket request = new DatagramPacket(buffer,buffer.length);
                skt.receive(request);
                String[] message = (new String(request.getData())).split("");
                System.out.print(request.getData());
                byte[] sendMsg= (message[0]+ " server processed").getBytes();
                DatagramPacket reply = new DatagramPacket(sendMsg,sendMsg.length,request.getAddress(),request.getPort());
                skt.send(reply);
            }
        }
        catch(Exception ex)
        {
//            System.out.println("Hello");
        }
    }
}

4 
client
package udp;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class client
{
    public static void main(String[] args)
    {
        DatagramSocket skt;
        while (true)
            try
            {
                skt=new DatagramSocket();
                Scanner sc = new Scanner(System.in);
                System.out.print("Send msg to Server: ");
                String msg = sc.nextLine();
//String msg= "text message ";
                byte[] b = msg.getBytes();
                InetAddress host=InetAddress.getByName("127.0.0.1");
                int serverSocket=6888;
                DatagramPacket request =new DatagramPacket(b,b.length,host,serverSocket);
                skt.send(request);
                byte[] buffer =new byte[1000];
                DatagramPacket reply= new
                        DatagramPacket(buffer,buffer.length);
                skt.receive(reply);
                System.out.println("client received:" +new String(reply.getData()));
                skt.close();
            }
            catch(Exception ex)
            {
            }
    }
}
