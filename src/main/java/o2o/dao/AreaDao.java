package o2o.dao;

import o2o.entity.Area;

import java.util.List;

public interface AreaDao {
        /**
         * 列出地域列表
         *
         * @return
         */
        public List<Area> queryArea();

}
