package com.rina.domain;

import com.rina.domain.relation.AbstractRoleRelationType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

/**
 * role_menu表所对应的实体类
 *
 * @author arvin
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleMenu extends AbstractRoleRelationType {

    private static final long serialVersionUID = 1216966007014837211L;

    private Long menuId;

    private Menu menu;

    public RoleMenu(Long roleId,
                    Long menuId,
                    String createBy,
                    Date createTime,
                    String updateBy,
                    Date updateTime,
                    Menu menu) {
        super(roleId, createBy, createTime, updateBy, updateTime);
        this.menuId = menuId;
        this.menu = menu;
    }

}