package o2o.exceptions;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-02 9:46
 */
public class ProductCategoryOperationException extends RuntimeException {

    public ProductCategoryOperationException(String meg){
        super(meg);
    }
}
