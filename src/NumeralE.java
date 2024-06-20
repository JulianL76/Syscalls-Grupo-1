
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Daniela Alexandra Patiño Davila 1152136 Cristian Julian Lamus 1152139
 */
public class NumeralE {

    SysCall s = new SysCall();

    public void treeDirectory(String dir) {

        String comand[] = {"powershell.exe", "/c", "Test-Path -Path '" + dir + "' -PathType Container"};

        s.run(comand);
        String msg = s.getOut().trim();  
        boolean contentEquals = msg.contentEquals("True");

        boolean existe = msg.contains("True");

        if (existe || contentEquals) {     
            String comand2[] = {"cmd.exe", "/c", "tree \"" + dir + "\""};
            s.run(comand2);
            String msg2 = s.getOut();
            System.out.println(msg2);
           
        } else {
            System.out.println("No existe el directorio");
        }

    }

}
