package az.edu.turing.bookauthor.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(){
        super("Resouce not found!");
    }
    public ResourceNotFoundException(String message){
        super(message);
    }
}
