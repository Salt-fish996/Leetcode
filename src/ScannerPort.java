import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author hyy
 * @date 2019/12/5 10:50
 */
//端口扫描
public class ScannerPort {

    public List<String> scanner() throws IOException, InterruptedException {
//        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
//        while (networkInterfaces.hasMoreElements()){
//            NetworkInterface networkInterface = networkInterfaces.nextElement();
//            System.out.println(networkInterface.getName());
//            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
//            while (inetAddresses.hasMoreElements()){
//                System.out.print(inetAddresses.nextElement() +"     ");
//            }
//            System.out.println();
//        }
        NetworkInterface interfaces = NetworkInterface.getByName("wlan2");
        List<String> list = new Vector<>();
        InetAddress address = interfaces.getInetAddresses().nextElement();
        System.out.println("localIP:" + address);
        int lastPoint = address.toString().lastIndexOf(".");
        int tiltLane = address.toString().lastIndexOf("/");
        String prefix = address.toString().substring(tiltLane + 1,lastPoint);
        System.out.println(prefix);
        Thread[] threads = new Thread[254];
        for (int i = 1; i < 255; i++) {
            int finalI = i;
            threads[i - 1] = new Thread(() -> {
                BufferedReader reader;
                Process exec = null;
                try {
                    exec = Runtime.getRuntime().exec("ping " + prefix +"." + finalI);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                reader = new BufferedReader(new InputStreamReader(exec.getInputStream(), Charset.forName("GBK")));
                String s = null;
                while (true){
                    try {
                        if ((s = reader.readLine()) == null) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (!s.equals("请求超时。"))
                    {
                        System.out.println(s);
                        if (s.equals(prefix +"." + finalI + " 的 Ping 统计信息:")){
                            synchronized (ScannerPort.class){
                                list.add(prefix +"." + finalI);
                            }
                        }
                    }else {
                        System.out.println(s);
                        break;
                    }
                }
            });
            threads[i - 1].start();
        }

        for (int i = 1; i < 255; i++) {
            threads[i - 1].join();
        }
        return list;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ScannerPort scannerPort = new ScannerPort();
        List<String> scanner = scannerPort.scanner();
        System.out.println(Arrays.toString(scanner.toArray()));
        System.out.println(scanner.size());
    }
}
