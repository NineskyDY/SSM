package o2o.exceptions;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-18 19:16
 */
public class WechatAuthOperationException extends RuntimeException{
    public WechatAuthOperationException(String Meg){
        super(Meg);
    }
}
