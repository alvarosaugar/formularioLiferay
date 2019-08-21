package com.liferay62.servicio.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.liferay62.servicio.service.ClpSerializer;
import com.liferay62.servicio.service.RegistroLocalServiceUtil;
import com.liferay62.servicio.service.RegistroServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            RegistroLocalServiceUtil.clearService();

            RegistroServiceUtil.clearService();
        }
    }
}
