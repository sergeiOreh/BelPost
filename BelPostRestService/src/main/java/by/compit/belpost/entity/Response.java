package by.compit.belpost.entity;

import org.hibernate.annotations.NamedNativeQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NamedNativeQuery(
        name = "functionCall",
        callable = true,
        query = "{? = call PKG_EXP_PORTAL.GET_OPER_4_PO(?)}",
        resultClass = Response.class)
public class Response implements Serializable{



//    private String code;
    private String otoDate;
    private String operName;
    private String orgCur;
    private String zipCodeNext;

    @Column(name = "OTO_DATE")
    public String getOtoDate() {
        return otoDate;
    }

    public void setOtoDate(String otoDate) {
        this.otoDate = otoDate;
    }

    @Column(name = "OPER_NAME")
    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    @Column(name = "ORG_CUR")
    public String getOrgCur() {
        return orgCur;
    }

    public void setOrgCur(String orgCur) {
        this.orgCur = orgCur;
    }

    @Id
    @Column(name = "ZIPCODE_NEXT")
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

        if (otoDate != null ? !otoDate.equals(response.otoDate) : response.otoDate != null) return false;
        if (operName != null ? !operName.equals(response.operName) : response.operName != null) return false;
        if (orgCur != null ? !orgCur.equals(response.orgCur) : response.orgCur != null) return false;
        return zipCodeNext != null ? zipCodeNext.equals(response.zipCodeNext) : response.zipCodeNext == null;
    }

    @Override
    public int hashCode() {
        int result = otoDate != null ? otoDate.hashCode() : 0;
        result = 31 * result + (operName != null ? operName.hashCode() : 0);
        result = 31 * result + (orgCur != null ? orgCur.hashCode() : 0);
        result = 31 * result + (zipCodeNext != null ? zipCodeNext.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Response{" +
                "otoDate='" + otoDate + '\'' +
                ", operName='" + operName + '\'' +
                ", orgCur='" + orgCur + '\'' +
                ", zipCodeNext='" + zipCodeNext + '\'' +
                '}';
    }


}
