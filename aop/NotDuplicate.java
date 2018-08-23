package com.bookdao.oasis.utils;

import java.lang.annotation.*;

/**
 * 避免重复提交
 * <b>类名称：</b>NotDuplicate <br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lisk<br/>
 * <b>修改人：</b><br/>
 * <b>修改备注：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotDuplicate {
	
}
