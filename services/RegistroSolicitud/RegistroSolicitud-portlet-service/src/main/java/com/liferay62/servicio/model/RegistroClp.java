package com.liferay62.servicio.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay62.servicio.service.ClpSerializer;
import com.liferay62.servicio.service.RegistroLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class RegistroClp extends BaseModelImpl<Registro> implements Registro {
    private long _registroId;
    private String _nombre;
    private String _apellido;
    private String _email;
    private Date _nacimiento;
    private Date _alta;
    private BaseModel<?> _registroRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay62.servicio.service.ClpSerializer.class;

    public RegistroClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Registro.class;
    }

    @Override
    public String getModelClassName() {
        return Registro.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _registroId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRegistroId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _registroId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("registroId", getRegistroId());
        attributes.put("nombre", getNombre());
        attributes.put("apellido", getApellido());
        attributes.put("email", getEmail());
        attributes.put("nacimiento", getNacimiento());
        attributes.put("alta", getAlta());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long registroId = (Long) attributes.get("registroId");

        if (registroId != null) {
            setRegistroId(registroId);
        }

        String nombre = (String) attributes.get("nombre");

        if (nombre != null) {
            setNombre(nombre);
        }

        String apellido = (String) attributes.get("apellido");

        if (apellido != null) {
            setApellido(apellido);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        Date nacimiento = (Date) attributes.get("nacimiento");

        if (nacimiento != null) {
            setNacimiento(nacimiento);
        }

        Date alta = (Date) attributes.get("alta");

        if (alta != null) {
            setAlta(alta);
        }
    }

    @Override
    public long getRegistroId() {
        return _registroId;
    }

    @Override
    public void setRegistroId(long registroId) {
        _registroId = registroId;

        if (_registroRemoteModel != null) {
            try {
                Class<?> clazz = _registroRemoteModel.getClass();

                Method method = clazz.getMethod("setRegistroId", long.class);

                method.invoke(_registroRemoteModel, registroId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getNombre() {
        return _nombre;
    }

    @Override
    public void setNombre(String nombre) {
        _nombre = nombre;

        if (_registroRemoteModel != null) {
            try {
                Class<?> clazz = _registroRemoteModel.getClass();

                Method method = clazz.getMethod("setNombre", String.class);

                method.invoke(_registroRemoteModel, nombre);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getApellido() {
        return _apellido;
    }

    @Override
    public void setApellido(String apellido) {
        _apellido = apellido;

        if (_registroRemoteModel != null) {
            try {
                Class<?> clazz = _registroRemoteModel.getClass();

                Method method = clazz.getMethod("setApellido", String.class);

                method.invoke(_registroRemoteModel, apellido);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmail() {
        return _email;
    }

    @Override
    public void setEmail(String email) {
        _email = email;

        if (_registroRemoteModel != null) {
            try {
                Class<?> clazz = _registroRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_registroRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getNacimiento() {
        return _nacimiento;
    }

    @Override
    public void setNacimiento(Date nacimiento) {
        _nacimiento = nacimiento;

        if (_registroRemoteModel != null) {
            try {
                Class<?> clazz = _registroRemoteModel.getClass();

                Method method = clazz.getMethod("setNacimiento", Date.class);

                method.invoke(_registroRemoteModel, nacimiento);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getAlta() {
        return _alta;
    }

    @Override
    public void setAlta(Date alta) {
        _alta = alta;

        if (_registroRemoteModel != null) {
            try {
                Class<?> clazz = _registroRemoteModel.getClass();

                Method method = clazz.getMethod("setAlta", Date.class);

                method.invoke(_registroRemoteModel, alta);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getRegistroRemoteModel() {
        return _registroRemoteModel;
    }

    public void setRegistroRemoteModel(BaseModel<?> registroRemoteModel) {
        _registroRemoteModel = registroRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _registroRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_registroRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            RegistroLocalServiceUtil.addRegistro(this);
        } else {
            RegistroLocalServiceUtil.updateRegistro(this);
        }
    }

    @Override
    public Registro toEscapedModel() {
        return (Registro) ProxyUtil.newProxyInstance(Registro.class.getClassLoader(),
            new Class[] { Registro.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RegistroClp clone = new RegistroClp();

        clone.setRegistroId(getRegistroId());
        clone.setNombre(getNombre());
        clone.setApellido(getApellido());
        clone.setEmail(getEmail());
        clone.setNacimiento(getNacimiento());
        clone.setAlta(getAlta());

        return clone;
    }

    @Override
    public int compareTo(Registro registro) {
        int value = 0;

        if (getRegistroId() < registro.getRegistroId()) {
            value = -1;
        } else if (getRegistroId() > registro.getRegistroId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RegistroClp)) {
            return false;
        }

        RegistroClp registro = (RegistroClp) obj;

        long primaryKey = registro.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{registroId=");
        sb.append(getRegistroId());
        sb.append(", nombre=");
        sb.append(getNombre());
        sb.append(", apellido=");
        sb.append(getApellido());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", nacimiento=");
        sb.append(getNacimiento());
        sb.append(", alta=");
        sb.append(getAlta());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.liferay62.servicio.model.Registro");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>registroId</column-name><column-value><![CDATA[");
        sb.append(getRegistroId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>nombre</column-name><column-value><![CDATA[");
        sb.append(getNombre());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>apellido</column-name><column-value><![CDATA[");
        sb.append(getApellido());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>nacimiento</column-name><column-value><![CDATA[");
        sb.append(getNacimiento());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>alta</column-name><column-value><![CDATA[");
        sb.append(getAlta());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
