import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author dpq
 * @date 2020/12/14
 *    Bio通信的客户端
 */
public class Client {

    public static void main(String[] args) throws IOException {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 10005);
        Socket socket = null;
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            socket = new Socket();
            socket.connect(socketAddress);
            System.out.println("clientA connect....");

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
            Scanner scan = new Scanner(System.in);
            System.out.println("clientA send name:");

            if (scan.hasNext()) {
                String str1 = scan.next();
                outputStream.writeUTF(str1);
                outputStream.flush();
            }

            String read = inputStream.readUTF();
            System.out.println("clientA accept server msg:"+read);

        } finally {
            if (socket != null) {
                socket.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
