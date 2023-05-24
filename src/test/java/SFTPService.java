import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

public class SFTPService {

    public SSHClient loginSftp(String host, int port, String username, String password)
            throws Exception {
        SSHClient client = new SSHClient();
        client.addHostKeyVerifier(new PromiscuousVerifier());
        client.connect(host, port);
        client.authPassword(username, password);
        return client;
    }

    public void createDirectory(String path, SFTPClient sftpClient) throws Exception {
        System.out.println();
        sftpClient.mkdirs(path);
        System.out.printf("[createDirectory][%d] Is success to create directory : %s",
                System.currentTimeMillis(), path);
        System.out.println();
    }

    public void uploadFile(String localPath, String remotePath, SFTPClient sftpClient) throws Exception {
        System.out.println();
        sftpClient.put(localPath, remotePath);
        System.out.printf("[uploadFile][%d] Is success to upload file : %s",
                System.currentTimeMillis(), remotePath);
        System.out.println();
    }

    public void renameFile(String oldPath, String newPath, SFTPClient sftpClient) throws Exception {
        System.out.println();
        sftpClient.rename(oldPath, newPath);
        System.out.printf("[renameFile][%d] Is success to rename file : from %s to %s",
                System.currentTimeMillis(), oldPath, newPath);
        System.out.println();
    }
    public void deleteFile(String path, SFTPClient sftpClient) throws Exception {
        System.out.println();
        sftpClient.rm(path);
        System.out.printf("[deleteFile][%d] Is success to delete file : %s",
                System.currentTimeMillis(), path);
        System.out.println();
    }

    public void deleteDirectory(String path, SFTPClient sftpClient) throws Exception {
        System.out.println();
        sftpClient.rmdir(path);
        System.out.printf("[deleteDirectory][%d] Is success to delete directory : %s",
                System.currentTimeMillis(), path);
        System.out.println();
    }

}
