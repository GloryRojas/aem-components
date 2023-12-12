# AEM Components project template

This is a sample project template for AEM-based applications. It is intended as a best-practice set of examples as well as a potential starting point to develop your own functionality.

## Sample Components

### Button

It is a proxy component based on Button V2 of [AEM Core components](https://experienceleague.adobe.com/docs/experience-manager-core-components/using/get-started/using.html?lang=en). The styles were taken from this [figma](https://www.figma.com/file/QdQLlt2r107dx9niF0Bj46/Free-Design-system-by-Severovsky-(Community)?type=design&node-id=224-11431&mode=design&t=gwHG7qTsCNohfxXq-0) file.

### Card

It is a customization of [Teaser Core Component](https://experienceleague.adobe.com/docs/experience-manager-core-components/using/wcm-components/teaser.html?lang=en). The business logic for this component wasn't be modified, it has the logic of Teaser component using Sling delegation pattern. You could find or do customization of logic in 

`/core/src/main/java/com.adobe.aem.guides.aemcomponents.core/models/CardModel
`

For customize the markup you need to modify the html file placed at:

`ui.apps/src/main/content/jcr_root/apps/aem-components/card/v1/card
`

It has styles from this [figma file](https://www.figma.com/file/QdQLlt2r107dx9niF0Bj46/Free-Design-system-by-Severovsky-(Community)?type=design&node-id=224-15168&mode=design&t=gwHG7qTsCNohfxXq-0). 

### Tabs

It is a container component to allows the content authors to organize page content within multiple tabs. 
Currently, doesn't have any customization only styles based on [this design](https://www.figma.com/file/QdQLlt2r107dx9niF0Bj46/Free-Design-system-by-Severovsky-(Community)?node-id=210%3A37406&mode=dev).

## Clientlibs

Sometimes you will need to customize styles or client logic that needs to be executed at the client side. 

At the ui.frontend module you can build that logic or client interaction requirements with js files and styled
the components with css files. This module has all the basic configuration to create and export those files as a clientlib to be use by the ui.apps module.


## How to build

To build all the modules run in the project root directory the following command with Maven 3:

    mvn clean install

To build all the modules and deploy the `all` package to a local instance of AEM, run in the project root directory the following command:

    mvn clean install -PautoInstallSinglePackage

Or to deploy it to a publish instance, run

    mvn clean install -PautoInstallSinglePackagePublish

Or alternatively

    mvn clean install -PautoInstallSinglePackage -Daem.port=4503

Or to deploy only the bundle to the author, run

    mvn clean install -PautoInstallBundle

Or to deploy only a single content package, run in the sub-module directory (i.e `ui.apps`)

    mvn clean install -PautoInstallPackage
