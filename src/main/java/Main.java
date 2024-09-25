import utils.Utils;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println(Utils.averageValue(Utils.getArrayIntegersFromConsole()));
    }
}
