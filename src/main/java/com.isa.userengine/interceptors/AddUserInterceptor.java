package com.isa.userengine.interceptors;

import com.isa.userengine.dao.UsersRepositoryDao;
import com.isa.userengine.domain.Gender;
import com.isa.userengine.domain.User;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class AddUserInterceptor {

    Logger logger = Logger.getLogger(AddUserInterceptor.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {

        Object[] parameters = context.getParameters();

        for (Object parameter : parameters) {
            User user = (User) parameter;

            if (user.getGender() == null) {
                if (user.getName().endsWith("a")) {
                    user.setGender(Gender.WOMAN);
                } else {
                    user.setGender(Gender.MAN);
                }
            }
        }

        context.setParameters(parameters);
        logger.info("Add user has been invoked!");
        return context.proceed();
    }
}
