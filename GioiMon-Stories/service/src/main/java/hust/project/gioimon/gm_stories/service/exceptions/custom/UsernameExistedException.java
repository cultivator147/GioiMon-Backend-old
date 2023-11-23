package hust.project.gioimon.gm_stories.service.exceptions.custom;


public class UsernameExistedException extends ApplicationException{
    public UsernameExistedException(String message){
        super(message);
    }
}
