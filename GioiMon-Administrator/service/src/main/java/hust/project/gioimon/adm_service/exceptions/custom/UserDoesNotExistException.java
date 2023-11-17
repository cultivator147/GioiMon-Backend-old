package hust.project.gioimon.adm_service.exceptions.custom;

public class UserDoesNotExistException extends ApplicationException{
    public UserDoesNotExistException(String message){
        super(message);
    }
}
