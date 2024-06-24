package Server.Clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Clients {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try
        {
            Socket s = new Socket("localhost",9999);
            boolean inChat = true;
            DataOutputStream sendMessage = new DataOutputStream(s.getOutputStream());
            DataInputStream inputMessage = new DataInputStream(s.getInputStream());

            while (inChat) {
                System.out.println("Choose 1.Send 2.Receive");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Enter The Message:");
                        String msg = sc.next();
                        sendMessage.writeUTF(msg);
                        break;
                        
                    case 2:
                        String revmsg = inputMessage.readUTF();
                        System.out.println("Receiver Msg:"+revmsg);
                        break;
                    case 3:
                        s.close();
                        inChat = false;
                        break;
                
                    default:
                        break;
                }
            }
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
