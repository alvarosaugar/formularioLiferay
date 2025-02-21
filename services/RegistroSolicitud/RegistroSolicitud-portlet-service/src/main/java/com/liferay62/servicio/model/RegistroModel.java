package com.liferay62.servicio.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Registro service. Represents a row in the &quot;RegistroSolicitud_Registro&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay62.servicio.model.impl.RegistroModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay62.servicio.model.impl.RegistroImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Registro
 * @see com.liferay62.servicio.model.impl.RegistroImpl
 * @see com.liferay62.servicio.model.impl.RegistroModelImpl
 * @generated
 */
public interface RegistroModel extends BaseModel<Registro> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a registro model instance should use the {@link Registro} interface instead.
     */

    /**
     * Returns the primary key of this registro.
     *
     * @return the primary key of this registro
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this registro.
     *
     * @param primaryKey the primary key of this registro
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the registro ID of this registro.
     *
     * @return the registro ID of this registro
     */
    public long getRegistroId();

    /**
     * Sets the registro ID of this registro.
     *
     * @param registroId the registro ID of this registro
     */
    public void setRegistroId(long registroId);

    /**
     * Returns the nombre of this registro.
     *
     * @return the nombre of this registro
     */
    @AutoEscape
    public String getNombre();

    /**
     * Sets the nombre of this registro.
     *
     * @param nombre the nombre of this registro
     */
    public void setNombre(String nombre);

    /**
     * Returns the apellido of this registro.
     *
     * @return the apellido of this registro
     */
    @AutoEscape
    public String getApellido();

    /**
     * Sets the apellido of this registro.
     *
     * @param apellido the apellido of this registro
     */
    public void setApellido(String apellido);

    /**
     * Returns the email of this registro.
     *
     * @return the email of this registro
     */
    @AutoEscape
    public String getEmail();

    /**
     * Sets the email of this registro.
     *
     * @param email the email of this registro
     */
    public void setEmail(String email);

    /**
     * Returns the nacimiento of this registro.
     *
     * @return the nacimiento of this registro
     */
    public Date getNacimiento();

    /**
     * Sets the nacimiento of this registro.
     *
     * @param nacimiento the nacimiento of this registro
     */
    public void setNacimiento(Date nacimiento);

    /**
     * Returns the alta of this registro.
     *
     * @return the alta of this registro
     */
    public Date getAlta();

    /**
     * Sets the alta of this registro.
     *
     * @param alta the alta of this registro
     */
    public void setAlta(Date alta);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(com.liferay62.servicio.model.Registro registro);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.liferay62.servicio.model.Registro> toCacheModel();

    @Override
    public com.liferay62.servicio.model.Registro toEscapedModel();

    @Override
    public com.liferay62.servicio.model.Registro toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
