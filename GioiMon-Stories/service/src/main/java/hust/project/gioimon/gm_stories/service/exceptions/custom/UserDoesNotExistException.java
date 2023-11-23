package hust.project.gioimon.gm_stories.service.exceptions.custom;

public class UserDoesNotExistException extends ApplicationException{
    public UserDoesNotExistException(String message){
        super(message);
    }
}
