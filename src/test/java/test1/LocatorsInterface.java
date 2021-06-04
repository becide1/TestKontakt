package test1;

import org.openqa.selenium.By;

public interface LocatorsInterface {

    By kontaktLink = By.xpath("//footer//a[text()='Kontakt & Support']");
    By kontaktHeader = By.xpath("//main//h1[text()='Kontakt']");
    By cookiesAcceptButton = By.xpath("//div[@id='cf-root']//span[text()='Akzeptiere alle']");

    // Kontakt Form Eingaben
    By nameKontaktForm = By.xpath("//label[text()='Name']//following-sibling::input");
    By emailKontaktForm = By.xpath("//label[text()='E-Mail Adresse']//following-sibling::input");
    By betreffKontaktForm = By.xpath("//label[text()='Betreff']//following-sibling::input");
    By nachrichtKontaktForm = By.xpath("//label[contains(text(),'Nachricht')]//following-sibling::textarea");
    By acceptCheckBox = By.cssSelector("#accept");
    By sendenButton = By.xpath("//button[@type='button']");
    By errorMessage = By.cssSelector(".srv-validation-message");

}
