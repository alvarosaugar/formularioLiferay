package com.liferay62.servicio.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Registro}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Registro
 * @generated
 */
public class RegistroWrapper implements Registro, ModelWrapper<Registro> {
    private Registro _registro;

    public RegistroWrapper(Registro registro) {
        _registro = registro;
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

    /**
    * Returns the primary key of this registro.
    *
    * @return the primary key of this registro
    */
    @Override
    public long getPrimaryKey() {
        return _registro.getPrimaryKey();
    }

    /**
    * Sets the primary key of this registro.
    *
    * @param primaryKey the primary key of this registro
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _registro.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the registro ID of this registro.
    *
    * @return the registro ID of this registro
    */
    @Override
    public long getRegistroId() {
        return _registro.getRegistroId();
    }

    /**
    * Sets the registro ID of this registro.
    *
    * @param registroId the registro ID of this registro
    */
    @Override
    public void setRegistroId(long registroId) {
        _registro.setRegistroId(registroId);
    }

    /**
    * Returns the nombre of this registro.
    *
    * @return the nombre of this registro
    */
    @Override
    public java.lang.String getNombre() {
        return _registro.getNombre();
    }

    /**
    * Sets the nombre of this registro.
    *
    * @param nombre the nombre of this registro
    */
    @Override
    public void setNombre(java.lang.String nombre) {
        _registro.setNombre(nombre);
    }

    /**
    * Returns the apellido of this registro.
    *
    * @return the apellido of this registro
    */
    @Override
    public java.lang.String getApellido() {
        return _registro.getApellido();
    }

    /**
    * Sets the apellido of this registro.
    *
    * @param apellido the apellido of this registro
    */
    @Override
    public void setApellido(java.lang.String apellido) {
        _registro.setApellido(apellido);
    }

    /**
    * Returns the email of this registro.
    *
    * @return the email of this registro
    */
    @Override
    public java.lang.String getEmail() {
        return _registro.getEmail();
    }

    /**
    * Sets the email of this registro.
    *
    * @param email the email of this registro
    */
    @Override
    public void setEmail(java.lang.String email) {
        _registro.setEmail(email);
    }

    /**
    * Returns the nacimiento of this registro.
    *
    * @return the nacimiento of this registro
    */
    @Override
    public java.util.Date getNacimiento() {
        return _registro.getNacimiento();
    }

    /**
    * Sets the nacimiento of this registro.
    *
    * @param nacimiento the nacimiento of this registro
    */
    @Override
    public void setNacimiento(java.util.Date nacimiento) {
        _registro.setNacimiento(nacimiento);
    }

    /**
    * Returns the alta of this registro.
    *
    * @return the alta of this registro
    */
    @Override
    public java.util.Date getAlta() {
        return _registro.getAlta();
    }

    /**
    * Sets the alta of this registro.
    *
    * @param alta the alta of this registro
    */
    @Override
    public void setAlta(java.util.Date alta) {
        _registro.setAlta(alta);
    }

    @Override
    public boolean isNew() {
        return _registro.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _registro.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _registro.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _registro.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _registro.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _registro.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _registro.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _registro.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _registro.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _registro.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _registro.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new RegistroWrapper((Registro) _registro.clone());
    }

    @Override
    public int compareTo(com.liferay62.servicio.model.Registro registro) {
        return _registro.compareTo(registro);
    }

    @Override
    public int hashCode() {
        return _registro.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay62.servicio.model.Registro> toCacheModel() {
        return _registro.toCacheModel();
    }

    @Override
    public com.liferay62.servicio.model.Registro toEscapedModel() {
        return new RegistroWrapper(_registro.toEscapedModel());
    }

    @Override
    public com.liferay62.servicio.model.Registro toUnescapedModel() {
        return new RegistroWrapper(_registro.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _registro.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _registro.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _registro.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RegistroWrapper)) {
            return false;
        }

        RegistroWrapper registroWrapper = (RegistroWrapper) obj;

        if (Validator.equals(_registro, registroWrapper._registro)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Registro getWrappedRegistro() {
        return _registro;
    }

    @Override
    public Registro getWrappedModel() {
        return _registro;
    }

    @Override
    public void resetOriginalValues() {
        _registro.resetOriginalValues();
    }
}
