package com.xihua.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 继承Model类后默认就可以使用实体类调用方法
 */
@Data
@TableName("user")
//public class User extends Model<User> {
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer age;
    // 插入和更新都填充值
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String email;
    // TableLogic此注解配置逻辑删除
    @TableLogic(value = "0",delval = "1")
    private Integer deleted;

    /*public static void main(String[] args) {
        User haha = User.builder().age(15).email("2331136197@qq.com").name("QQ").id(8).build();
        System.out.println(haha);
    }*/

}

