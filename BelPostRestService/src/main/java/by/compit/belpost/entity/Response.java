package by.compit.belpost.entity;

import java.io.Serializable;

/**
 * Класс Response предназначен для хранения и последующего отображения параметров ответа пользователю.
 */
public class Response implements Serializable {

    private String code;
    private String otoDate;
    private String operName;
    private String orgCur;
    private String zipCodeNext;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOtoDate() {
        return otoDate;
    }

    public void setOtoDate(String otoDate) {
        this.otoDate = otoDate;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOrgCur() {
        return orgCur;
    }

    public void setOrgCur(String orgCur) {
        this.orgCur = orgCur;
    }

    public String getZipCodeNext() {
        return zipCodeNext;
    }

    public void setZipCodeNext(String zipCodeNext) {
        this.zipCodeNext = zipCodeNext;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        if (code != null ? !code.equals(response.code) : response.code != null) return false;
        if (otoDate != null ? !otoDate.equals(response.otoDate) : response.otoDate != null) return false;
        if (operName != null ? !operName.equals(response.operName) : response.operName != null) return false;
        if (orgCur != null ? !orgCur.equals(response.orgCur) : response.orgCur != null) return false;
        return zipCodeNext != null ? zipCodeNext.equals(response.zipCodeNext) : response.zipCodeNext == null;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (otoDate != null ? otoDate.hashCode() : 0);
        result = 31 * result + (operName != null ? operName.hashCode() : 0);
        result = 31 * result + (orgCur != null ? orgCur.hashCode() : 0);
        result = 31 * result + (zipCodeNext != null ? zipCodeNext.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", otoDate='" + otoDate + '\'' +
                ", operName='" + operName + '\'' +
                ", orgCur='" + orgCur + '\'' +
                ", zipCodeNext='" + zipCodeNext + '\'' +
                '}';
    }
}
