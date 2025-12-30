package org.web.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import org.web.entity.User;

/**
 * @author czq
 * @date 2024/4/25 16:42
 * @Description:
 */

@LocalTCC
public interface TccUserService {

    @TwoPhaseBusinessAction(name = "trxAdd",commitMethod = "confirm",rollbackMethod = "cancel")
    void tryAdd(@BusinessActionContextParameter(paramName = "user")User user);

    boolean confirm(BusinessActionContext context);


    boolean cancel(BusinessActionContext context);




}
