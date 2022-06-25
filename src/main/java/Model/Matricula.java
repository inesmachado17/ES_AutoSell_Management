package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matricula {

    private String matricula;

    public Matricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean isMatriculaValida(){

        /*Regex para validação matricula inclusivé por ano*/
        Pattern pattern = Pattern.compile("[0-9]{2}[\\s-]{0,1}[0-9]{2}[\\s-]{0,1}[A-IK-PR-VZ]{2}|[0-9]{2}[\\s-]{0,1}[A-IK-PR-VZ]{2}[\\s-]{0,1}[0-9]{2}|[A-IK-PR-WYZ]{2}[\\s-]{0,1}[0-9]{2}[\\s-]{0,1}[A-IK-PR-WYZ]{2}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.getMatricula());
        return matcher.find();
    }

    public String getMatricula(){
        return matricula;
    }
}
