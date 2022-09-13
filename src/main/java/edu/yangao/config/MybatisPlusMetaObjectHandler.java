package edu.yangao.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import edu.yangao.entity.enums.CleanStateEnum;
import edu.yangao.entity.enums.DeletedEnum;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * mybatis plus 自动填充配置
 * @author YangAo
 */
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {
    /**
     * 配置插入时, (创建时间, 逻辑删除位)的填充
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 创建时间 当前时间
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
        // 逻辑删除位 未删除
        this.strictInsertFill(metaObject, "deleted", DeletedEnum.class, DeletedEnum.NOT_DELETED);
        // 零件清理状态 未清理
        this.strictInsertFill(metaObject, "status", CleanStateEnum.class, CleanStateEnum.NOT_STARTED);
    }

    /**
     * 配置更新时, 更新时间的填充
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新时间
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }
}
