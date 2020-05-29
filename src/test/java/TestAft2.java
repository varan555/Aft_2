
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import static junit.framework.TestCase.assertTrue;

public class TestAft2 extends TestBase{



    @ParameterizedTest
    @CsvSource({
            "Ivanov, Ivan, 26.05.2000, Иванов, Иван, Иванович, 26.05.1990, M, 1485, 123456, 25.02.2005, Кем-то",
            "Nikonov, Ars, 22.03.2001, Никонов, Арс, Нилович, 22.03.1991, M, 1421, 123451, 25.02.2006, Кем-то2",
            "Ivanov, Serg, 26.05.2000, Иванов, Серж, Иванович, 21.01.2010, M, 1485, 123459, 25.02.2020, Кем-то3"
    })
            public void sberban2kTest(@AggregateWith(TestIteracAggregator.class) TestIterace test) {
            goTo();

            click(By.xpath("//button//*[contains(text(), 'Страхование')]"));

            click((By.xpath("//div[@id='submenu-5']//*[text()='Страхование путешественников']")));

            isElementDisplayed(By.xpath("//div[@class = 'kit-col_xs_12 kit-col_md_0 kit-col_lg_6 " +
                    "kit-col_xs-bottom_20 kit-col_lg-bottom_10 kit-col_xs-top_20 kit-col_lg-top_40']" +
                    "//h2[contains(text(), 'Страхование путешественников')]"));

            click(By.xpath("//a[@href ='https://online.sberbankins.ru/store/vzr/index.html']"));

            click(By.xpath("//div[@class ='online-card-program selected']"));

            click(By.xpath("//button[text() ='Оформить']"));

            //ВВод данных
        isElementDisplayed(By.xpath("//h2[contains(text(), 'Страхование путешественников')]"));
        enter(By.xpath("//input[@placeholder='Surname']"), test.getSurnameStr());
        enter(By.xpath("//input[@placeholder='Name']"), test.getNameStr());
        enter(By.xpath("//input[@id = 'birthDate_vzr_ins_0' and contains(@placeholder, 'дд.мм.гггг')]"), test.getBDStr());
        enter(By.xpath("//input[@id='person_lastName']"), test.getSurname());
        enter(By.xpath("//input[@id='person_firstName']"), test.getName());
        enter(By.xpath("//input[@id='person_middleName']"), test.getMiddleName());
        enter(By.xpath("//input[@id='person_birthDate']"), test.getBD());
        if(test.getMale().equals("F")) {
            click(By.xpath("//label[contains(text(), 'Женский')]"));
        }
        enter(By.xpath("//input[@id='passportSeries']"), test.getPasS());
        enter(By.xpath("//input[@id='passportNumber']"), test.getPasN());
        enter(By.xpath("//input[@id='documentDate']"), test.getDateDeliv());
        enter(By.xpath("//input[@id='documentIssue']"), test.getPlaceDeliv());

        //Проверка введенных даных
        checkFields(By.xpath("//input[@placeholder='Surname']"), test.getSurnameStr());
        checkFields(By.xpath("//input[@placeholder='Name']"), test.getNameStr());
        checkFields(By.xpath("//input[@id = 'birthDate_vzr_ins_0' and contains(@placeholder, 'дд.мм.гггг')]"), test.getBDStr());
//        checkFields(By.xpath("//input[@id='person_lastName']"), test.getSurname());
        checkFields(By.xpath("//input[@id='person_firstName']"), test.getName());
        checkFields(By.xpath("//input[@id='person_middleName']"), test.getMiddleName());
   //     checkFields(By.xpath("//input[@id='person_birthDate']"), test.getBD());
        if(test.getMale().equals("F")) {
            assertTrue(driver.findElement(By.xpath("//label[@class ='btn ng-valid ng-touched ng-dirty active' and contains(text(),'Женский')]")).isDisplayed());
        }
//        checkFields(By.xpath("//input[@id='passportSeries']"), test.getPasS());
        checkFields(By.xpath("//input[@id='passportNumber']"), test.getPasN());
    //    checkFields(By.xpath("//input[@id='documentDate']"), test.getDateDeliv());
   //     checkFields(By.xpath("//input[@id='documentIssue']"), test.getPlaceDeliv());

        //Проверка появления поля после отправки
        click(By.xpath("//button[@class='btn btn-primary page__btn']"));
        isElementDisplayed(By.xpath("//div[@class='alert-form alert-form-error']"));
        }
}
