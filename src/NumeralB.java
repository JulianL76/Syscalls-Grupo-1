
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.Process;
/**
 *
 * @author 
 * Daniela Alexandra Patiño Davila 1152136
 * Cristian Julian Lamus 1152139
 */
public class NumeralB {

    Process proc = new Process();
    SysCall s = new SysCall();

    public String maxCPUProcess() {
        String result = "";
        String comand[] = {"powershell.exe", "/c", "Get-Process | Where-Object {$_.CPU -ge 0} | Sort-Object CPU -Descending | Format-Table -Property CPU,Name"};
        s.run(comand);
        result = s.getOut();
        System.out.println(result);
//        parseOutput(result);
        return result;
    }
    
    public String parseOutput(String output){
        String[] lines = output.split("\n");
        
//        for (int i = 1; i < lines.length; i++) {
//            String line = lines[i];
//        }
            
        System.out.println(lines[5]);
    
    return null;
    }
}