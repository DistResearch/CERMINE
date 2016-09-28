/**
 * This file is part of CERMINE project.
 * Copyright (c) 2011-2016 ICM-UW
 *
 * CERMINE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CERMINE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with CERMINE. If not, see <http://www.gnu.org/licenses/>.
 */
package pl.edu.icm.cermine.bx;

import java.io.IOException;
import org.apache.commons.cli.ParseException;
import pl.edu.icm.cermine.exception.AnalysisException;
import pl.edu.icm.cermine.exception.TransformationException;
import pl.edu.icm.cermine.structure.HierarchicalReadingOrderResolver;
import pl.edu.icm.cermine.structure.ReadingOrderResolver;
import pl.edu.icm.cermine.structure.model.BxDocument;

/**
 * @author Dominika Tkaczyk (d.tkaczyk@icm.edu.pl)
 */
public class BxReadingOrderSetter extends BxDocRewriter {

    public static void main(String[] args) throws ParseException, TransformationException, IOException, AnalysisException {
        BxReadingOrderSetter corrector = new BxReadingOrderSetter();
        corrector.run(args);
    }

    @Override
    protected BxDocument transform(BxDocument document) throws AnalysisException {
        ReadingOrderResolver roResolver = new HierarchicalReadingOrderResolver();
        return roResolver.resolve(document);
    }
}
