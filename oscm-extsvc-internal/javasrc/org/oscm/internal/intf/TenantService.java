/*******************************************************************************
 *
 *  Copyright FUJITSU LIMITED 2016
 *
 *  Creation Date: 30.08.2016
 *
 *******************************************************************************/
package org.oscm.internal.intf;

import java.util.List;

import javax.ejb.Remote;

import org.oscm.internal.types.exception.ConcurrentModificationException;
import org.oscm.internal.types.exception.NonUniqueBusinessKeyException;
import org.oscm.internal.types.exception.ObjectNotFoundException;
import org.oscm.internal.types.exception.TenantDeletionConstraintException;
import org.oscm.internal.vo.VOTenant;
import org.oscm.internal.vo.VOTenantSetting;

@Remote
public interface TenantService {

    List<VOTenant> getTenants();

    VOTenant getTenantByTenantId(String tenantId) throws ObjectNotFoundException;

    void addTenant(VOTenant voTenant) throws NonUniqueBusinessKeyException;

    void updateTenant(VOTenant voTenant)
        throws NonUniqueBusinessKeyException, ObjectNotFoundException, ConcurrentModificationException;

    void removeTenant(VOTenant voTenant) throws ObjectNotFoundException, TenantDeletionConstraintException;

    void addTenantSettings(List<VOTenantSetting> tenantSettings, VOTenant voTenant) throws
        NonUniqueBusinessKeyException, ObjectNotFoundException;

    void removeTenantIdpProperties(long key) throws ObjectNotFoundException;

    List<VOTenantSetting> getSettingsForTenant(long key);

    List<VOTenant> getTenantsByIdPattern(String tenantIdPattern);

    VOTenant findByTkey(String tkey) throws ObjectNotFoundException;
}