import javafx.util.converter.ByteStringConverter;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hyy
 * @date 2019/12/23 12:49
 */
public class SocketClient {
    private Socket socket;
    private int port;
    private Scanner in;

    public SocketClient(int port) throws IOException {
        this.port = port;
        socket = new Socket("127.0.0.1",port);
        in = new Scanner(System.in);
    }

    public void send() throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        String s = null;
        while (!(s = in.nextLine()).equals("e")){
            byte[] bytes = new byte[1024];
            byte[] bytes1 = s.getBytes();
            System.arraycopy(bytes1,0,bytes,0,bytes1.length);
            outputStream.write(bytes);
            outputStream.flush();
        }
        socket.close();
        outputStream.close();

    }


}
