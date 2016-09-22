/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.websocket.ng.internal;

import org.eclipse.che.api.core.websocket.shared.WebSocketTransmission;
import org.eclipse.che.ide.dto.DtoFactory;
import org.eclipse.che.ide.util.loging.Log;
import org.eclipse.che.ide.websocket.ng.WebSocketMessageReceiver;
import org.eclipse.che.ide.websocket.ng.impl.WebSocketTransmissionDispatcher;
import org.eclipse.che.ide.websocket.ng.impl.WebSocketTransmissionValidator;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * Dispatches a {@link WebSocketTransmission} messages among registered receivers
 * ({@link WebSocketMessageReceiver}) according to WEB SOCKET transmission protocol
 * field value.
 *
 * @author Dmitry Kuleshov
 */
@Singleton
public class InternalWebSocketTransmissionDispatcher extends WebSocketTransmissionDispatcher {
    @Inject
    public InternalWebSocketTransmissionDispatcher(@Named("internal") Map<String, WebSocketMessageReceiver> receivers,
                                                   @Named("internal") WebSocketTransmissionValidator validator,
                                                   DtoFactory dtoFactory) {
        super(receivers, validator, dtoFactory);
    }
}
