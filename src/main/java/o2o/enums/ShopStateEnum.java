package o2o.enums;

public enum  ShopStateEnum {
    CHECK(0, "审核中"), OFFLINE(-1, "非法商铺"), SUCCESS(1, "操作成功"), PASS(2, "通过认证"), INNER_ERROR(
            -1001, "操作失败"), NULL_SHOPID(-1002, "ShopId为空"), NULL_SHOP(-1003, "传入了空的信息");

    private int State;
    private String StateInfo;



    private ShopStateEnum(int state, String stateInfo ) {
        this.State = state;
        this.StateInfo = stateInfo;
    }

    public String getStateInfo() {
        return StateInfo;
    }

    public int getState() {
        return State;
    }

    /*
     *依据传入的state返回相应的enum值
     */
    public static ShopStateEnum stateOf(int index){
        for (ShopStateEnum state : values()){
            if(state.getState() == index)
                return state;
        }
        return null;
    }


}
