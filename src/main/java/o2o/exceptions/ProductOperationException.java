package o2o.exceptions;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-03 15:55
 */
public class ProductOperationException extends RuntimeException {

    public ProductOperationException(String meg){
        super(meg);
    }
}
