package pages;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.ElementsCollection;

public class SecondLayerMenu {

    public final static ElementsCollection
        secondLayerMenuItems = $$(".sub-menu .menu-item");

}
