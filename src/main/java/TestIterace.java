import java.util.stream.Stream;

public class TestIterace {

    private String surnameStr;
    private String nameStr;
    private String BDStr;
    private String name;
    private String surname;
    private String middleName;
    private String BD;
    private String male;
    private String pasS;
    private String pasN;
    private String dateDeliv;
    private String placeDeliv;

    public TestIterace(String surnameStr, String nameStr, String BDStr, String name, String surname, String middleName,
                       String BD, String male, String pasS, String pasN, String dateDeliv, String placeDeliv) {
        this.surnameStr = surnameStr;
        this.nameStr = nameStr;
        this.BDStr = BDStr;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.BD = BD;
        this.male = male;
        this.pasS = pasS;
        this.pasN = pasN;
        this.dateDeliv = dateDeliv;
        this.placeDeliv = placeDeliv;
    }

    public String getSurnameStr() {
        return surnameStr;
    }

    public void setSurnameStr(String surnameStr) {
        this.surnameStr = surnameStr;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
    }

    public String getBDStr() {
        return BDStr;
    }

    public void setBDStr(String BDStr) {
        this.BDStr = BDStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getBD() {
        return BD;
    }

    public void setBD(String BD) {
        this.BD = BD;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getPasS() {
        return pasS;
    }

    public void setPasS(String pasS) {
        this.pasS = pasS;
    }

    public String getPasN() {
        return pasN;
    }

    public void setPasN(String pasN) {
        this.pasN = pasN;
    }

    public String getDateDeliv() {
        return dateDeliv;
    }

    public void setDateDeliv(String dateDeliv) {
        this.dateDeliv = dateDeliv;
    }

    public String getPlaceDeliv() {
        return placeDeliv;
    }

    public void setPlaceDeliv(String placeDeliv) {
        this.placeDeliv = placeDeliv;
    }

// Setters and getters
}

