import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

public class SSHService {
    private static SSHClient client;


    public static SSHClient getClient(String host, int port, String username, String password) throws Exception {
        if (client == null) {
            client = new SSHClient();
            client.addHostKeyVerifier(new PromiscuousVerifier());
            client.connect(host, port);
            client.authPassword(username, password);
        }
        return client;
    }
}
