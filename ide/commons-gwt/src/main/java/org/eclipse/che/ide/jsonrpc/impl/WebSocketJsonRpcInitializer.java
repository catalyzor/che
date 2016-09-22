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
package org.eclipse.che.ide.jsonrpc.impl;

import org.eclipse.che.ide.util.loging.Log;
import org.eclipse.che.ide.websocket.ng.impl.SessionWebSocketInitializer;
import org.eclipse.che.ide.websocket.ng.impl.WebSocketInitializer;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Map;

/**
 * @author Dmitry Kuleshov
 */
public abstract class WebSocketJsonRpcInitializer implements JsonRpcInitializer {
    private final WebSocketInitializer webSocketInitializer;

    public WebSocketJsonRpcInitializer(WebSocketInitializer webSocketInitializer) {
        this.webSocketInitializer = webSocketInitializer;
    }

    @Override
    public void initialize(Map<String, String> properties) {
        Log.debug(getClass(), "Initializing with properties: " + properties);

        webSocketInitializer.initialize(properties);
    }

    @Override
    public void terminate() {
        Log.debug(getClass(), "Terminating");

        webSocketInitializer.terminate();
    }
}
