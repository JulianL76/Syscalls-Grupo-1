
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 
 * Daniela Alexandra Patiño Davila 1152136
 * Cristian Julian Lamus 1152139
 */
public class NumeralA {

    SysCall s = new SysCall();

    public String IPfinder(String ip) {
        String result = "La direccion o dominio es invalida";
        if (!isValidDomain(ip) && !isValidIP(ip)) {
            return result;
        }
        String comand[] = {"powershell.exe", "/c", "Resolve-DnsName -Name " + ip + " | Format-Table -Property Name,IPAddress"};
        s.run(comand);
        result = s.getOut();
        return result;
    }
    
    

    public static boolean isValidIP(String ip) {
        String ipPattern
                = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }

    public static boolean isValidDomain(String domain) {
        String domainPattern
                = "^(?!-)[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(domainPattern);
        Matcher matcher = pattern.matcher(domain);
        return matcher.matches();
    }
}
