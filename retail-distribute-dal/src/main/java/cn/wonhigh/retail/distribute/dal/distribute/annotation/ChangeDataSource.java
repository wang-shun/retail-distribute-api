package cn.wonhigh.retail.distribute.dal.distribute.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 多数据源切换
 * 
 * @author liu.ax
 * @date2015-08-12
 * @version 0.1.0 
 * @copyright yougou.com 
 */
@Target({ElementType.PARAMETER,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChangeDataSource{
	String value() default "default";
}
