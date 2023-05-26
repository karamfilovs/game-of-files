import com.hierynomus.msfscc.fileinformation.FileIdBothDirectoryInformation;
import com.hierynomus.smbj.SMBClient;
import com.hierynomus.smbj.auth.AuthenticationContext;
import com.hierynomus.smbj.connection.Connection;
import com.hierynomus.smbj.session.Session;
import com.hierynomus.smbj.share.DiskShare;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class SMBTest {
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String HOST = "";

    @Test
    public void canListFolders() throws IOException {
        SMBClient client = new SMBClient();

        try (Connection connection = client.connect(HOST)) {
            AuthenticationContext ac = new AuthenticationContext(USERNAME, PASSWORD.toCharArray(), HOST);
            Session session = connection.authenticate(ac);

            // Connect to Share
            try (DiskShare share = (DiskShare) session.connectShare("smb1")) {
                for (FileIdBothDirectoryInformation f : share.list("ALEX")) {
                    System.out.println("File : " + f.getFileName());
                }
            }
        }
    }


    @Test
    public void canDeleteFile() throws IOException {
        SMBClient client = new SMBClient();

        try (Connection connection = client.connect(HOST)) {
            AuthenticationContext ac = new AuthenticationContext(USERNAME, PASSWORD.toCharArray(), HOST);
            Session session = connection.authenticate(ac);

            // Connect to Share
            try (DiskShare share = (DiskShare) session.connectShare("smb1")) {
                share.rmdir("ALEX/CUSTOM_LOADER", true);
            }
        }
    }
}