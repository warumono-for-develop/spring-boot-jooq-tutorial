package com.warumono.listeners;

import org.jooq.ExecuteContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultExecuteListener;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;
import org.springframework.util.ObjectUtils;

public class JooqExecuteListener extends DefaultExecuteListener
{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void exception(ExecuteContext ctx)
	{
		SQLDialect dialect = ctx.configuration().dialect();
		SQLExceptionTranslator translator;
		
		if(ObjectUtils.isEmpty(dialect))
		{
			translator = new SQLStateSQLExceptionTranslator();
		}
		else
		{
			translator = new SQLErrorCodeSQLExceptionTranslator(dialect.getName());
		}

		ctx.exception(translator.translate("Access database using Jooq", ctx.sql(), ctx.sqlException()));
	}
}
