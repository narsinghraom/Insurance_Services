package com.insurance.main.logics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.insurance.main.bean.ZipBean;


public class BusinessLogics 
{
	public static ZipBean getBeanObject(List list,int value)
	{
		Iterator<ZipBean> iterator=list.iterator();
		ZipBean zipBean=null;
		while(iterator.hasNext())
		{
			zipBean=(ZipBean)iterator.next();
		if(zipBean.getZipCode()==value)
		{
			return zipBean;
		}
		}
		return zipBean;
	}
	
	public static List<ZipBean> simulateSearchResult(List list,int tagName) {

		List<ZipBean> result = new ArrayList<ZipBean>();
		Iterator<ZipBean> iterator=list.iterator();
		ZipBean zipBean=null;
		while(iterator.hasNext())
		{
			zipBean=(ZipBean)iterator.next();
		if(zipBean.getZipCode()==tagName)
		{
			result.add(zipBean);
		}
		}

		return result;
	}

}
