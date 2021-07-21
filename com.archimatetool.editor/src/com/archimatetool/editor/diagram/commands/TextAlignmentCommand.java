/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package com.archimatetool.editor.diagram.commands;

import com.archimatetool.editor.model.commands.EObjectFeatureCommand;
import com.archimatetool.model.IArchimatePackage;
import com.archimatetool.model.ITextAlignment;



/**
 * Text Alignment Command
 *
 * @author Phillip Beauvoir
 */
public class TextAlignmentCommand extends EObjectFeatureCommand {
    
    public TextAlignmentCommand(ITextAlignment object, int value) {
        super(Messages.TextAlignmentCommand_0, object, IArchimatePackage.Literals.TEXT_ALIGNMENT__TEXT_ALIGNMENT, value);
    }
}