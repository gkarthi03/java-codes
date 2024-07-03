package Server.Clients;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;
public class Server {

    public static void main(String[] args)
    {
        try{
            Scanner sc = new Scanner(System.in);
            ServerSocket ss = new ServerSocket(9999);
            Socket s = ss.accept();

            boolean inChat = true;
            DataOutputStream sendMessage = new DataOutputStream(s.getOutputStream());
            DataInputStream inputMessage = new DataInputStream(s.getInputStream());
            
            while (inChat) {
                System.out.println("Choose 1.Send 2.Receive");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Enter The Message:");
                        sc.nextLine();
                        String msg = sc.nextLine();
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
