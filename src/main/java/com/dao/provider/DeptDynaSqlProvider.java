package com.dao.provider;

import com.domain.Dept;
import org.apache.ibatis.jdbc.SQL;

import static com.util.common.Constants.DEPTTABLE;

public class DeptDynaSqlProvider {

    // 动态插入
    public String insertDept(final Dept dept) {

        return new SQL() {
            {
                INSERT_INTO(DEPTTABLE);
                if (dept.getName() != null && !dept.getName().equals("")) {
                    VALUES("name", "#{name}");
                }
                if (dept.getRemark() != null && !dept.getRemark().equals("")) {
                    VALUES("remark", "#{remark}");
                }
            }
        }.toString();
    }

    // 动态更新
    public String updateDept(final Dept dept) {

        return new SQL() {
            {
                UPDATE(DEPTTABLE);
                if (dept.getName() != null) {
                    SET(" name = #{name} ");
                }
                if (dept.getRemark() != null) {
                    SET(" remark = #{remark} ");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }
}
