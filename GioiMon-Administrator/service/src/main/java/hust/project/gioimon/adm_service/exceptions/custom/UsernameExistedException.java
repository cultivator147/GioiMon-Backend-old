package hust.project.gioimon.adm_service.exceptions.custom;


public class UsernameExistedException extends ApplicationException{
    public UsernameExistedException(String message){
        super(message);
    }
}
