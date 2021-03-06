/**
 *    Copyright 2012 Pedro Ribeiro
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.hashes.config;

import java.util.Locale;

import com.google.common.base.Preconditions;

/**
 * Supported protocols.
 * 
 * @author ribeirux
 * @version $Revision$
 */
public enum Protocol {

    /**
     * Lower case Http protocol.
     */
    HTTP("http", 80),
    /**
     * Lower case Https protocol.
     */
    HTTPS("https", 443);

    private final String schemeName;

    private final int defaultPort;

    private Protocol(final String schemeName, final int defaultPort) {
        this.schemeName = schemeName;
        this.defaultPort = defaultPort;
    }

    /**
     * Gets the schemeName property.
     * 
     * @return the schemeName property
     */
    public String getSchemeName() {
        return this.schemeName;
    }

    /**
     * Gets the defaultPort property.
     * 
     * @return the defaultPort property
     */
    public int getDefaultPort() {
        return this.defaultPort;
    }

    /**
     * Load protocol from scheme name.
     * 
     * @param schemeName the scheme name
     * @return the protocol
     * @throws IllegalArgumentException if the scheme name is nome supported
     */
    public static Protocol fromSchemeName(final String schemeName) {
        final String lowerCaseScheme = Preconditions.checkNotNull(schemeName, "schemeName").toLowerCase(Locale.ENGLISH);

        Protocol result = null;

        for (final Protocol protocol : Protocol.values()) {
            if (protocol.getSchemeName().equals(lowerCaseScheme)) {
                result = protocol;
                break;
            }
        }

        if (result == null) {
            throw new IllegalArgumentException("Unsupported protocol: " + schemeName);
        }

        return result;
    }
}
