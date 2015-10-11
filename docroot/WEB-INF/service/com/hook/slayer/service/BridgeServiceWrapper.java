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

package com.hook.slayer.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BridgeService}.
 *
 * @author shail
 * @see BridgeService
 * @generated
 */
public class BridgeServiceWrapper implements BridgeService,
	ServiceWrapper<BridgeService> {
	public BridgeServiceWrapper(BridgeService bridgeService) {
		_bridgeService = bridgeService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _bridgeService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_bridgeService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _bridgeService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public boolean updateLanguage(java.lang.String languageId, long userId) {
		return _bridgeService.updateLanguage(languageId, userId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BridgeService getWrappedBridgeService() {
		return _bridgeService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBridgeService(BridgeService bridgeService) {
		_bridgeService = bridgeService;
	}

	@Override
	public BridgeService getWrappedService() {
		return _bridgeService;
	}

	@Override
	public void setWrappedService(BridgeService bridgeService) {
		_bridgeService = bridgeService;
	}

	private BridgeService _bridgeService;
}