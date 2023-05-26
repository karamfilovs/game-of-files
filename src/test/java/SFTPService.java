import net.schmizz.sshj.sftp.SFTPClient;

public class SFTPService {

    private SFTPClient client;


    public SFTPService(SFTPClient client) {
        this.client = client;

    }



    public void createDirectory(String path) throws Exception {
        System.out.println();
        client.mkdirs(path);
        System.out.printf("[createDirectory][%d] Successfully created directory : %s",
                System.currentTimeMillis(), path);
        System.out.println();
    }

    public void uploadFile(String localPath, String remotePath) throws Exception {
        System.out.println();
        client.put(localPath, remotePath);
        System.out.printf("[uploadFile][%d] Successfully uploaded file : %s",
                System.currentTimeMillis(), remotePath);
        System.out.println();
    }

    public void renameFile(String oldPath, String newPath) throws Exception {
        System.out.println();
        client.rename(oldPath, newPath);
        System.out.printf("[renameFile][%d] Successfully renamed file : from %s to %s",
                System.currentTimeMillis(), oldPath, newPath);
        System.out.println();
    }
    public void deleteFile(String path) throws Exception {
        System.out.println();
        client.rm(path);
        System.out.printf("[deleteFile][%d] Successfully deleted file : %s",
                System.currentTimeMillis(), path);
        System.out.println();
    }

    public void deleteDirectory(String path) throws Exception {
        System.out.println();
        client.rmdir(path);
        System.out.printf("[deleteDirectory][%d] Successfully deleted directory : %s",
                System.currentTimeMillis(), path);
        System.out.println();
    }

}
