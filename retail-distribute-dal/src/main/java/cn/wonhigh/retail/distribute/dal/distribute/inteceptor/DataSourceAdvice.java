package cn.wonhigh.retail.distribute.dal.distribute.inteceptor;

import java.lang.annotation.Annotation;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import cn.wonhigh.retail.distribute.common.enums.DataSource;
import cn.wonhigh.retail.distribute.dal.distribute.annotation.ChangeDataSource;

import com.yougou.logistics.base.common.utils.DataSourceSwitch;


public class DataSourceAdvice implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		ChangeDataSource ds = null;
		Annotation[][] dsss = invocation.getMethod().getParameterAnnotations();
		if(dsss != null){
			boolean back = false;
			int indexPa = -1;
			for(Annotation[] dss :dsss){
				indexPa++;
				for(Annotation an :dss){
					if(an instanceof ChangeDataSource){
						ds = (ChangeDataSource)an;
						back = true;
						break;
					}
				}
				if(back)break;
			}
			if(ds != null){
				Object obj = invocation.getArguments()[indexPa];
				DataSource dataSource = (DataSource)obj;
				DataSourceSwitch.setCurrentDataSource(dataSource.getDataSource());
			}
		}
		if(ds == null){
			//从DataSourceHolder中获取数据源
			DataSource dataSource = DataSourceHolder.getDataSource();
			if(null != dataSource){
				DataSourceSwitch.setCurrentDataSource(dataSource.getDataSource());
			} else {
				ds = invocation.getMethod().getAnnotation(ChangeDataSource.class);
				ds = ds == null ? invocation.getClass().getAnnotation(ChangeDataSource.class) : ds;
				if (ds != null)
					DataSourceSwitch.setCurrentDataSource(ds.value());
			}
		}
		
		try {
			return invocation.proceed();
		} finally {
			if (ds != null)
				DataSourceSwitch.setCurrentDataSource(null);
		}
	}

}
