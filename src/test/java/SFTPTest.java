import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import org.junit.jupiter.api.Test;

public class SFTPTest {
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final int PORT = 22;
    private static final String HOST = "";


    @Test
    public void canUploadFileToSFTP() throws Exception {
        SSHClient sshClient = SSHService.getClient(HOST, PORT, USERNAME, PASSWORD);
        SFTPClient sftpClient = sshClient.newSFTPClient();
        SFTPService sftpService = new SFTPService(sftpClient);
        sftpService.createDirectory("/sftp/automated");
        sftpService.uploadFile("src/test/resources/file.txt", "/sftp/automated/alex.txt");
        sftpClient.close();
        sshClient.close();
    }
}
