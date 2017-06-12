package com.warumono.listeners;

import org.jooq.util.DefaultGeneratorStrategy;
import org.jooq.util.Definition;

public class JooqGeneratorStrategy extends DefaultGeneratorStrategy
{
	@Override
	public String getJavaClassName(Definition definition, Mode mode)
	{
		if(Mode.POJO == mode)
		{
			return super.getJavaClassName(definition, mode).concat("Pojo");
		}
		
		return super.getJavaClassName(definition, mode);
	}
}
