package utils;
/**
 *
 * @author Lamus-PC
 */
public class Process {
    
    int PID;
    String name;
    String Cpu_Ussage;

    public Process(int PID, String name, String Cpu_Ussage) {
        this.PID = PID;
        this.name = name;
        this.Cpu_Ussage = Cpu_Ussage;
    }

    public Process(String name, String Cpu_Ussage) {
        this.name = name;
        this.Cpu_Ussage = Cpu_Ussage;
    }

    public Process() {
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpu_Ussage() {
        return Cpu_Ussage;
    }

    public void setCpu_Ussage(String Cpu_Ussage) {
        this.Cpu_Ussage = Cpu_Ussage;
    }

    @Override
    public String toString() {
        return "Process{" + "PID=" + PID + ", name=" + name + ", Cpu_Ussage=" + Cpu_Ussage + '}';
    }

}
