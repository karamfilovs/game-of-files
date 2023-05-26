import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPSClient;

public class FTPSClientService {
    private static final int MAX_WAIT = 5000;
    private static FTPSClient client;


    public static FTPSClient getClient(String host, int port, String username, String password) throws Exception {
        client = new FTPSClient(true);
        client.setConnectTimeout(MAX_WAIT);
        client.connect(host, port);
        client.login(username, password);
        int reply = client.getReplyCode();
        client.setFileType(FTP.BINARY_FILE_TYPE);

        client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
        client.enterLocalPassiveMode();
        System.out.println("Received Reply from FTP Connection:" + reply);
        return client;
    }
}
