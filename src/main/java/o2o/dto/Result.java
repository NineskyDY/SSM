package o2o.dto;

/**
 * @description:
 * @author: 九霄环佩
 * @date: 2019-03-01 21:22
 */
public class Result<T> {
    //标志是否成功
    private Boolean success;

    //成功时返回的数据
    private T data;

    //错误信息
    private String errMsg;

    private int errCode;

    public Result(){
    }

    //成功时使用的构造器
    public Result(Boolean success,T data){
        this.success = success;
        this.data = data;
    }

    //失败时使用的构造器
    public Result(Boolean success,int errCode,String errMsg){
        this.success = success;
        this.errMsg = errMsg;
        this.errCode = errCode;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }
}
