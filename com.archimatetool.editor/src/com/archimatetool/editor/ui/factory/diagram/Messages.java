/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.ui.factory.diagram;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

    private static final String BUNDLE_NAME = "com.archimatetool.editor.ui.factory.diagram.messages"; //$NON-NLS-1$

    public static String ArchimateDiagramModelUIProvider_0;

    public static String DiagramImageUIProvider_0;

    public static String DiagramModelReferenceUIProvider_0;

    public static String GroupUIProvider_0;

    public static String LineConnectionUIProvider_0;

    public static String NoteUIProvider_0;
    static {
        // initialize resource bundle
        NLS.initializeMessages(BUNDLE_NAME, Messages.class);
    }

    private Messages() {
    }
}
