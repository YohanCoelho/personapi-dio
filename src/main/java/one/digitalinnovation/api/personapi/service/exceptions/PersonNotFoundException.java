package one.digitalinnovation.api.personapi.service.exceptions;

public class PersonNotFoundException extends RuntimeException{

    public  PersonNotFoundException(String msg) {
        super(msg);
    }
}
