import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dpq
 * @date 2020/12/14
 *    Bio通信的服务端
 */
public class ServerPool {


    private static ExecutorService executorService = Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors() * 2);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        //监听的端口
        serverSocket.bind(new InetSocketAddress(10005));

        System.out.println("server start...");

        try {
            while (true) {
               executorService.execute(new ServerTask(serverSocket.accept()));
            }
        } finally {
            serverSocket.close();
        }
    }


    /**
     * 每个和客户端的通信都会打包成一个任务，交个一个线程来执行
     */
    private static class ServerTask implements Runnable {
        private Socket socket = null;

        public ServerTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            //实例化与客户端通信的输入输出流
            try (ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

                //接收客户端的输出，也就是服务器的输入
                String msg = inputStream.readUTF();
                System.out.println("accept client msg:" + msg);

                //服务器的输出，也就是客户端的输入
                outputStream.writeUTF("Hello I accept " + msg);
                outputStream.flush();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
