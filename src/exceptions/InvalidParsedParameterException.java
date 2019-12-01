package exceptions;

public class InvalidParsedParameterException extends Exception {

    String msg;

    public InvalidParsedParameterException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Erreur de lecture du fichier, paramètre " + msg;
    }
}
