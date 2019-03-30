package o2o.exceptions;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-23 20:13
 */
public class LocalAuthOperationException extends RuntimeException{
    public LocalAuthOperationException(String meg){
        super(meg);
    }
}
