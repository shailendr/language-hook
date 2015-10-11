/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.hook.slayer.service.impl;

import com.hook.slayer.service.base.BridgeServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * The implementation of the bridge remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.hook.slayer.service.BridgeService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author shail
 * @see com.hook.slayer.service.base.BridgeServiceBaseImpl
 * @see com.hook.slayer.service.BridgeServiceUtil
 */
public class BridgeServiceImpl extends BridgeServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.hook.slayer.service.BridgeServiceUtil} to access the bridge remote service.
	 */
	@AccessControlled(guestAccessEnabled = true)
	public boolean updateLanguage(String languageId, long userId){
		try {
			System.out.println(userId + "  --  " +languageId);
			User user = UserLocalServiceUtil.getUser(userId);
			user.setLanguageId(languageId);
    		user = UserLocalServiceUtil.updateUser(user);
    		
    		System.out.println("  --  " +user.getLanguageId());
			return true;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}