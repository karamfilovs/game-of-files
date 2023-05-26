import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPSClient;

import java.io.ByteArrayOutputStream;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.util.List;

public class FTPService {
    private FTPSClient client;


    public FTPService(FTPSClient client) {
        this.client = client;
    }


    public void createDirectory(String path) throws Exception {
        System.out.println();
        System.out.printf("[createDirectory][%d] Successfully created directory : %s -> %b",
                System.currentTimeMillis(), path, client.makeDirectory(path));
        System.out.println();
    }

    public void uploadFile(String localPath, String remotePath) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(localPath);
        System.out.println();
        System.out.printf("[uploadFile][%d] Successfully uploaded file : %s -> %b",
                System.currentTimeMillis(), remotePath, client.storeFile(remotePath, fileInputStream));
        System.out.println();
    }

    public void renameFile(String oldPath, String newPath) throws Exception {
        System.out.println();
        System.out.printf("[renameFile][%d] Successfully to renamed file : from %s to %s -> %b",
                System.currentTimeMillis(), oldPath, newPath, client.rename(oldPath, newPath));
        System.out.println();
    }

    public byte[] downloadFile(String path) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.out.println();
        System.out.printf("[downloadFile][%d] Successfully downloaded file : %s -> %b",
                System.currentTimeMillis(), path, client.retrieveFile(path, byteArrayOutputStream));
        System.out.println();
        return byteArrayOutputStream.toByteArray();
    }

    public void deleteFile(String path) throws Exception {
        System.out.println();
        System.out.printf("[deleteFile][%d] Successfully deleted file : %s -> %b",
                System.currentTimeMillis(), path, client.deleteFile(path));
        System.out.println();
    }

    public void deleteDirectory(String path) throws Exception {
        System.out.println();
        System.out.printf("[deleteDirectory][%d] Successfully deleted directory : %s -> %b",
                System.currentTimeMillis(), path, client.removeDirectory(path));
        System.out.println();
    }

    public List<FTPFile> listDirectories(String path) throws Exception {
        System.out.println(client.listFiles(path, FTPFile::isDirectory).length);
        List<FTPFile> files = List.of(client.listDirectories());
        System.out.printf("[deleteDirectory][%d] Successfully listing directory : %s",
                System.currentTimeMillis(), files.size());
        return files;
    }
}
