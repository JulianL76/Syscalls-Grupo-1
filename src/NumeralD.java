
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Daniela Alexandra Patiño Davila 1152136 Cristian Julian Lamus 1152139
 */
public class NumeralD {

    SysCall s = new SysCall();

    public void changeDate(String date) {

        int indiceSeparador = date.indexOf('/');
        String fecha = "";
        String hora = "";

        if (indiceSeparador != -1) {
            fecha = date.substring(0, indiceSeparador);
            hora = date.substring(indiceSeparador + 1);
            hora = hora.replace("-", ":");

            if (validarFecha(fecha)) {
                System.out.println("Fecha: " + fecha);
            } else {
                System.out.println("La fecha no es Válida");
                return;
            }

            if (validarHora(hora)) {
                System.out.println("Hora: " + hora);
            } else {
                System.out.println("La hora no es Válida");
                return;
            }
        }

        String comand[] = {"cmd.exe", "/c", "date " + fecha};
        String comand2[] = {"cmd.exe", "/c", "time " + hora};
        s.run(comand);
        s.run(comand2);
        System.out.println("Fecha o Hora del sistema atualizada");

    }

    private boolean validarFecha(String fecha) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate.parse(fecha, dateFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean validarHora(String hora) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        try {
            LocalTime.parse(hora, timeFormatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}
