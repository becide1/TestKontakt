package test1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static test1.Locators.*;


public class KontaktForm implements LocatorsInterface{

    @Test
    public void goToKontaktPage(){
        //Configuration.browser = "firefox";
        //Configuration.holdBrowserOpen = true;
        open(url);
        $(cookiesAcceptButton).shouldBe(Condition.visible).click();
        $(kontaktLink).scrollTo().click();
        $(kontaktHeader).shouldBe(Condition.visible);
    }

    @Test(dependsOnMethods = "goToKontaktPage", dataProvider = "data")
    public void fillKontaktForm(String[] eingaben){
        $(nameKontaktForm).scrollTo().shouldBe(Condition.visible).setValue(eingaben[0]);
        $(emailKontaktForm).setValue(eingaben[1]);
        $(betreffKontaktForm).setValue(eingaben[2]);
        $(nachrichtKontaktForm).setValue(eingaben[3]);
        if (!$(acceptCheckBox).isSelected())
            $(acceptCheckBox).parent().click();
        $(sendenButton).click();
        if (eingaben[4].equals("false")){
            $$(errorMessage).shouldHave(CollectionCondition.sizeGreaterThan(0));
        }else{
            $$(errorMessage).shouldHave(CollectionCondition.size(0));
        }
    }

    @DataProvider
    public Object[][] data(){
        return new Object[][]  {
                {"Tutus Test User1", "", "", "Es wird nur Test gemacht", "false"},
                {"", "TEST", "", "Es wird nur Test gemacht", "false"},
                {"Tutus Test User4", "tetuser@tutcom", "Test", "", "false"},
                {"Tutus Test User3", "testuser@tutusmedia.com", "Test", "Es wird nur Test gemacht", "true"}
        };
    }
}
