import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPSClient;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.System.out;

public class FTPSTest {
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final int PORT = 990;
    private static final String HOST = "";


    @Test
    public void canUploadFileToSFTP() throws Exception {
        FTPSClient ftpsClient = FTPSClientService.getClient(HOST, PORT, USERNAME, PASSWORD);
        FTPService ftpService = new FTPService(ftpsClient);
        ftpService.createDirectory("Test");
        ftpsClient.changeToParentDirectory();
        out.println(ftpsClient.listHelp());
        boolean resp = ftpsClient.changeWorkingDirectory("/");
        out.println("Changed directory:" + resp);
        ftpsClient.initiateListParsing();
        out.println(ftpsClient.listFiles("/").length);
        ftpService.uploadFile("src/test/resources/file.txt", "Test/file.txt");
        ftpService.deleteDirectory("Test");
        ftpService.deleteDirectory("Naasssssssss");
        ftpService.createDirectory("/24032023/ALEX");
        ftpService.listDirectories("ALEX");
        FTPListParseEngine engine = ftpsClient.initiateListParsing();
        while (engine.hasNext()) {
            FTPFile[] files = engine.getNext(25);

            List.of(files).forEach(ftpFile -> out.println(ftpFile.getName()));
        }
    }
}
