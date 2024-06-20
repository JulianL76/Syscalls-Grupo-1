
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author madarme
 */
public class SysCall {

    private Process p = null;

    public SysCall() {
    }

    public String run(String []command) {

        try {
            p = Runtime.getRuntime().exec(command);
            try {
                int codigo=p.waitFor();
                System.out.println("CODIGO:"+codigo);
            } catch (InterruptedException ex) {
                Logger.getLogger(SysCall.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return "nada";
    }

    public String getOut() {

        BufferedReader is
                = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        String msg="";
        try {
            // reading the output
            while ((line = is.readLine()) != null) {
                msg+=line+"\n";
                
            }
        } catch (IOException ex) {
            Logger.getLogger(SysCall.class.getName()).log(Level.SEVERE, null, ex);
        }
        return msg;
    }
    
 public void printer()
 {
     System.out.println(this.getOut());
 }
    
    
}

