package o2o.util;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-02-19 11:31
 */
public class PageCalculator {
    public static int calculateRowIndex(int pageIndex,int pageSize){
        return (pageIndex>0)?(pageIndex-1)*pageSize:0;
    }
}
