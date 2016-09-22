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
package org.eclipse.che.ide.jsonrpc.external;

import org.eclipse.che.ide.jsonrpc.impl.JsonRpcRequestRegistry;
import org.eclipse.che.ide.jsonrpc.impl.WebSocketJsonRpcRequestTransmitter;
import org.eclipse.che.ide.jsonrpc.impl.WebSocketJsonRpcTransmitter;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;


/**
 * Transmits JSON RPC requests through to {@link WebSocketJsonRpcTransmitter}
 *
 * @author Dmitry Kuleshov
 */
@Singleton
public class ExternalWebSocketJsonRpcRequestTransmitter extends WebSocketJsonRpcRequestTransmitter {

    @Inject
    public ExternalWebSocketJsonRpcRequestTransmitter(@Named("external") WebSocketJsonRpcTransmitter transmitter,
                                                      JsonRpcRequestRegistry requestRegistry) {
        super(transmitter, requestRegistry);
    }
}
