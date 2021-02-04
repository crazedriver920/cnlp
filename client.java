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
