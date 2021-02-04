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
