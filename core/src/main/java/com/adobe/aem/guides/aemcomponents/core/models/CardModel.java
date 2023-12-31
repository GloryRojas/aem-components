/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.adobe.aem.guides.aemcomponents.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.wcm.core.components.models.Teaser;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;
import lombok.experimental.Delegate;

@Model(adaptables = SlingHttpServletRequest.class,
        adapters = { ComponentExporter.class, Teaser.class },
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = CardModel.RESOURCE_TYPE)
@Exporter(
        name = ExporterConstants.SLING_MODEL_EXPORTER_NAME,
        extensions = ExporterConstants.SLING_MODEL_EXTENSION
)
public class CardModel implements Teaser, ComponentExporter {

    static final String RESOURCE_TYPE = "aem-components/components/card/v1/card";

    @Self
    @Delegate(excludes = DelegationExclusion.class)
    @Via(type = ResourceSuperType.class)
    Teaser teaser;

    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }

    interface DelegationExclusion {
        String getExportedType();
    }
}
