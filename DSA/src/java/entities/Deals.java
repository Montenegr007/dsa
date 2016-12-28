/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anton
 */
@Entity
@Table(name = "DEALS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deals.findAll", query = "SELECT d FROM Deals d"),
    @NamedQuery(name = "Deals.findById", query = "SELECT d FROM Deals d WHERE d.id = :id"),
    @NamedQuery(name = "Deals.findByContactId", query = "SELECT d FROM Deals d WHERE d.contactId = :contactId"),
    @NamedQuery(name = "Deals.findByAdults", query = "SELECT d FROM Deals d WHERE d.adults = :adults"),
    @NamedQuery(name = "Deals.findByChildrens", query = "SELECT d FROM Deals d WHERE d.childrens = :childrens"),
    @NamedQuery(name = "Deals.findBySource", query = "SELECT d FROM Deals d WHERE d.source = :source"),
    @NamedQuery(name = "Deals.findByComment", query = "SELECT d FROM Deals d WHERE d.comment = :comment"),
    @NamedQuery(name = "Deals.findByMainServiceType", query = "SELECT d FROM Deals d WHERE d.mainServiceType = :mainServiceType"),
    @NamedQuery(name = "Deals.findByServiceName", query = "SELECT d FROM Deals d WHERE d.serviceName = :serviceName"),
    @NamedQuery(name = "Deals.findByServiceDetails", query = "SELECT d FROM Deals d WHERE d.serviceDetails = :serviceDetails"),
    @NamedQuery(name = "Deals.findByAdditionalInfo", query = "SELECT d FROM Deals d WHERE d.additionalInfo = :additionalInfo"),
    @NamedQuery(name = "Deals.findByTouristTax", query = "SELECT d FROM Deals d WHERE d.touristTax = :touristTax"),
    @NamedQuery(name = "Deals.findByDeposite", query = "SELECT d FROM Deals d WHERE d.deposite = :deposite"),
    @NamedQuery(name = "Deals.findByWebUrl", query = "SELECT d FROM Deals d WHERE d.webUrl = :webUrl"),
    @NamedQuery(name = "Deals.findByAdditionalService1", query = "SELECT d FROM Deals d WHERE d.additionalService1 = :additionalService1"),
    @NamedQuery(name = "Deals.findByAdditionalService1DsaPrice", query = "SELECT d FROM Deals d WHERE d.additionalService1DsaPrice = :additionalService1DsaPrice"),
    @NamedQuery(name = "Deals.findByAdditionalService1PartnerPrice", query = "SELECT d FROM Deals d WHERE d.additionalService1PartnerPrice = :additionalService1PartnerPrice"),
    @NamedQuery(name = "Deals.findByAdditionalService2", query = "SELECT d FROM Deals d WHERE d.additionalService2 = :additionalService2"),
    @NamedQuery(name = "Deals.findByAdditionalService2DsaPrice", query = "SELECT d FROM Deals d WHERE d.additionalService2DsaPrice = :additionalService2DsaPrice"),
    @NamedQuery(name = "Deals.findByAdditionalService2PartnerPrice", query = "SELECT d FROM Deals d WHERE d.additionalService2PartnerPrice = :additionalService2PartnerPrice"),
    @NamedQuery(name = "Deals.findByP1StartDate", query = "SELECT d FROM Deals d WHERE d.p1StartDate = :p1StartDate"),
    @NamedQuery(name = "Deals.findByP1EndDate", query = "SELECT d FROM Deals d WHERE d.p1EndDate = :p1EndDate"),
    @NamedQuery(name = "Deals.findByP1AmountOfDays", query = "SELECT d FROM Deals d WHERE d.p1AmountOfDays = :p1AmountOfDays"),
    @NamedQuery(name = "Deals.findByP1DsaPrice", query = "SELECT d FROM Deals d WHERE d.p1DsaPrice = :p1DsaPrice"),
    @NamedQuery(name = "Deals.findByP1PartnerPrice", query = "SELECT d FROM Deals d WHERE d.p1PartnerPrice = :p1PartnerPrice"),
    @NamedQuery(name = "Deals.findByP1Fix", query = "SELECT d FROM Deals d WHERE d.p1Fix = :p1Fix"),
    @NamedQuery(name = "Deals.findByP2StartDate", query = "SELECT d FROM Deals d WHERE d.p2StartDate = :p2StartDate"),
    @NamedQuery(name = "Deals.findByP2EndDate", query = "SELECT d FROM Deals d WHERE d.p2EndDate = :p2EndDate"),
    @NamedQuery(name = "Deals.findByP2AmountOfDays", query = "SELECT d FROM Deals d WHERE d.p2AmountOfDays = :p2AmountOfDays"),
    @NamedQuery(name = "Deals.findByP2DsaPrice", query = "SELECT d FROM Deals d WHERE d.p2DsaPrice = :p2DsaPrice"),
    @NamedQuery(name = "Deals.findByP2PartnerPrice", query = "SELECT d FROM Deals d WHERE d.p2PartnerPrice = :p2PartnerPrice"),
    @NamedQuery(name = "Deals.findByP2Fix", query = "SELECT d FROM Deals d WHERE d.p2Fix = :p2Fix"),
    @NamedQuery(name = "Deals.findByP3StartDate", query = "SELECT d FROM Deals d WHERE d.p3StartDate = :p3StartDate"),
    @NamedQuery(name = "Deals.findByP3EndDate", query = "SELECT d FROM Deals d WHERE d.p3EndDate = :p3EndDate"),
    @NamedQuery(name = "Deals.findByP3AmountOfDays", query = "SELECT d FROM Deals d WHERE d.p3AmountOfDays = :p3AmountOfDays"),
    @NamedQuery(name = "Deals.findByP3DsaPrice", query = "SELECT d FROM Deals d WHERE d.p3DsaPrice = :p3DsaPrice"),
    @NamedQuery(name = "Deals.findByP3PartnerPrice", query = "SELECT d FROM Deals d WHERE d.p3PartnerPrice = :p3PartnerPrice"),
    @NamedQuery(name = "Deals.findByP3Fix", query = "SELECT d FROM Deals d WHERE d.p3Fix = :p3Fix"),
    @NamedQuery(name = "Deals.findByP4StartDate", query = "SELECT d FROM Deals d WHERE d.p4StartDate = :p4StartDate"),
    @NamedQuery(name = "Deals.findByP4EndDate", query = "SELECT d FROM Deals d WHERE d.p4EndDate = :p4EndDate"),
    @NamedQuery(name = "Deals.findByP4AmountOfDays", query = "SELECT d FROM Deals d WHERE d.p4AmountOfDays = :p4AmountOfDays"),
    @NamedQuery(name = "Deals.findByP4DsaPrice", query = "SELECT d FROM Deals d WHERE d.p4DsaPrice = :p4DsaPrice"),
    @NamedQuery(name = "Deals.findByP4PartnerPrice", query = "SELECT d FROM Deals d WHERE d.p4PartnerPrice = :p4PartnerPrice"),
    @NamedQuery(name = "Deals.findByP4Fix", query = "SELECT d FROM Deals d WHERE d.p4Fix = :p4Fix"),
    @NamedQuery(name = "Deals.findByDiscountDsaPerc", query = "SELECT d FROM Deals d WHERE d.discountDsaPerc = :discountDsaPerc"),
    @NamedQuery(name = "Deals.findByDiscountPartnerPerc", query = "SELECT d FROM Deals d WHERE d.discountPartnerPerc = :discountPartnerPerc"),
    @NamedQuery(name = "Deals.findByDiscountDsaEuro", query = "SELECT d FROM Deals d WHERE d.discountDsaEuro = :discountDsaEuro"),
    @NamedQuery(name = "Deals.findByDiscountPartnerEuro", query = "SELECT d FROM Deals d WHERE d.discountPartnerEuro = :discountPartnerEuro"),
    @NamedQuery(name = "Deals.findByAvansDsaPerc", query = "SELECT d FROM Deals d WHERE d.avansDsaPerc = :avansDsaPerc"),
    @NamedQuery(name = "Deals.findByAvansDsaEuro", query = "SELECT d FROM Deals d WHERE d.avansDsaEuro = :avansDsaEuro"),
    @NamedQuery(name = "Deals.findByAvansPartnerCalc", query = "SELECT d FROM Deals d WHERE d.avansPartnerCalc = :avansPartnerCalc"),
    @NamedQuery(name = "Deals.findByAvansPartnerPaid", query = "SELECT d FROM Deals d WHERE d.avansPartnerPaid = :avansPartnerPaid"),
    @NamedQuery(name = "Deals.findByCommonPriceDsa", query = "SELECT d FROM Deals d WHERE d.commonPriceDsa = :commonPriceDsa"),
    @NamedQuery(name = "Deals.findByCommonPricePartner", query = "SELECT d FROM Deals d WHERE d.commonPricePartner = :commonPricePartner"),
    @NamedQuery(name = "Deals.findByDeltaPartner", query = "SELECT d FROM Deals d WHERE d.deltaPartner = :deltaPartner"),
    @NamedQuery(name = "Deals.findByProfitDsa", query = "SELECT d FROM Deals d WHERE d.profitDsa = :profitDsa"),
    @NamedQuery(name = "Deals.findByManagerBonus", query = "SELECT d FROM Deals d WHERE d.managerBonus = :managerBonus"),
    @NamedQuery(name = "Deals.findByAgentBonus", query = "SELECT d FROM Deals d WHERE d.agentBonus = :agentBonus")})
public class Deals implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONTACT_ID")
    private long contactId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADULTS")
    private int adults;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CHILDRENS")
    private int childrens;
    @Size(max = 255)
    @Column(name = "SOURCE")
    private String source;
    @Size(max = 255)
    @Column(name = "COMMENT")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "MAIN_SERVICE_TYPE")
    private String mainServiceType;
    @Size(max = 255)
    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @Size(max = 255)
    @Column(name = "SERVICE_DETAILS")
    private String serviceDetails;
    @Size(max = 255)
    @Column(name = "ADDITIONAL_INFO")
    private String additionalInfo;
    @Size(max = 255)
    @Column(name = "TOURIST_TAX")
    private String touristTax;
    @Column(name = "DEPOSITE")
    private Integer deposite;
    @Size(max = 255)
    @Column(name = "WEB_URL")
    private String webUrl;
    @Size(max = 255)
    @Column(name = "ADDITIONAL_SERVICE1")
    private String additionalService1;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ADDITIONAL_SERVICE1_DSA_PRICE")
    private Double additionalService1DsaPrice;
    @Column(name = "ADDITIONAL_SERVICE1_PARTNER_PRICE")
    private Double additionalService1PartnerPrice;
    @Size(max = 255)
    @Column(name = "ADDITIONAL_SERVICE2")
    private String additionalService2;
    @Column(name = "ADDITIONAL_SERVICE2_DSA_PRICE")
    private Double additionalService2DsaPrice;
    @Column(name = "ADDITIONAL_SERVICE2_PARTNER_PRICE")
    private Double additionalService2PartnerPrice;
    @Column(name = "P1_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date p1StartDate;
    @Column(name = "P1_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date p1EndDate;
    @Column(name = "P1_AMOUNT_OF_DAYS")
    private Integer p1AmountOfDays;
    @Column(name = "P1_DSA_PRICE")
    private Double p1DsaPrice;
    @Column(name = "P1_PARTNER_PRICE")
    private Double p1PartnerPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "P1_FIX")
    private String p1Fix;
    @Column(name = "P2_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date p2StartDate;
    @Column(name = "P2_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date p2EndDate;
    @Column(name = "P2_AMOUNT_OF_DAYS")
    private Integer p2AmountOfDays;
    @Column(name = "P2_DSA_PRICE")
    private Double p2DsaPrice;
    @Column(name = "P2_PARTNER_PRICE")
    private Double p2PartnerPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "P2_FIX")
    private String p2Fix;
    @Column(name = "P3_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date p3StartDate;
    @Column(name = "P3_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date p3EndDate;
    @Column(name = "P3_AMOUNT_OF_DAYS")
    private Integer p3AmountOfDays;
    @Column(name = "P3_DSA_PRICE")
    private Double p3DsaPrice;
    @Column(name = "P3_PARTNER_PRICE")
    private Double p3PartnerPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "P3_FIX")
    private String p3Fix;
    @Column(name = "P4_START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date p4StartDate;
    @Column(name = "P4_END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date p4EndDate;
    @Column(name = "P4_AMOUNT_OF_DAYS")
    private Integer p4AmountOfDays;
    @Column(name = "P4_DSA_PRICE")
    private Double p4DsaPrice;
    @Column(name = "P4_PARTNER_PRICE")
    private Double p4PartnerPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "P4_FIX")
    private String p4Fix;
    @Column(name = "DISCOUNT_DSA_PERC")
    private Integer discountDsaPerc;
    @Column(name = "DISCOUNT_PARTNER_PERC")
    private Integer discountPartnerPerc;
    @Column(name = "DISCOUNT_DSA_EURO")
    private Integer discountDsaEuro;
    @Column(name = "DISCOUNT_PARTNER_EURO")
    private Integer discountPartnerEuro;
    @Column(name = "AVANS_DSA_PERC")
    private Integer avansDsaPerc;
    @Column(name = "AVANS_DSA_EURO")
    private Integer avansDsaEuro;
    @Column(name = "AVANS_PARTNER_CALC")
    private Integer avansPartnerCalc;
    @Column(name = "AVANS_PARTNER_PAID")
    private Integer avansPartnerPaid;
    @Column(name = "COMMON_PRICE_DSA")
    private Double commonPriceDsa;
    @Column(name = "COMMON_PRICE_PARTNER")
    private Double commonPricePartner;
    @Column(name = "DELTA_PARTNER")
    private Double deltaPartner;
    @Column(name = "PROFIT_DSA")
    private Double profitDsa;
    @Column(name = "MANAGER_BONUS")
    private Double managerBonus;
    @Column(name = "AGENT_BONUS")
    private Double agentBonus;

    public Deals() {
    }

    public Deals(Long id) {
        this.id = id;
    }

    public Deals(Long id, long contactId, int adults, int childrens, String mainServiceType, String p1Fix, String p2Fix, String p3Fix, String p4Fix) {
        this.id = id;
        this.contactId = contactId;
        this.adults = adults;
        this.childrens = childrens;
        this.mainServiceType = mainServiceType;
        this.p1Fix = p1Fix;
        this.p2Fix = p2Fix;
        this.p3Fix = p3Fix;
        this.p4Fix = p4Fix;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildrens() {
        return childrens;
    }

    public void setChildrens(int childrens) {
        this.childrens = childrens;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMainServiceType() {
        return mainServiceType;
    }

    public void setMainServiceType(String mainServiceType) {
        this.mainServiceType = mainServiceType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getTouristTax() {
        return touristTax;
    }

    public void setTouristTax(String touristTax) {
        this.touristTax = touristTax;
    }

    public Integer getDeposite() {
        return deposite;
    }

    public void setDeposite(Integer deposite) {
        this.deposite = deposite;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getAdditionalService1() {
        return additionalService1;
    }

    public void setAdditionalService1(String additionalService1) {
        this.additionalService1 = additionalService1;
    }

    public Double getAdditionalService1DsaPrice() {
        return additionalService1DsaPrice;
    }

    public void setAdditionalService1DsaPrice(Double additionalService1DsaPrice) {
        this.additionalService1DsaPrice = additionalService1DsaPrice;
    }

    public Double getAdditionalService1PartnerPrice() {
        return additionalService1PartnerPrice;
    }

    public void setAdditionalService1PartnerPrice(Double additionalService1PartnerPrice) {
        this.additionalService1PartnerPrice = additionalService1PartnerPrice;
    }

    public String getAdditionalService2() {
        return additionalService2;
    }

    public void setAdditionalService2(String additionalService2) {
        this.additionalService2 = additionalService2;
    }

    public Double getAdditionalService2DsaPrice() {
        return additionalService2DsaPrice;
    }

    public void setAdditionalService2DsaPrice(Double additionalService2DsaPrice) {
        this.additionalService2DsaPrice = additionalService2DsaPrice;
    }

    public Double getAdditionalService2PartnerPrice() {
        return additionalService2PartnerPrice;
    }

    public void setAdditionalService2PartnerPrice(Double additionalService2PartnerPrice) {
        this.additionalService2PartnerPrice = additionalService2PartnerPrice;
    }

    public Date getP1StartDate() {
        return p1StartDate;
    }

    public void setP1StartDate(Date p1StartDate) {
        this.p1StartDate = p1StartDate;
    }

    public Date getP1EndDate() {
        return p1EndDate;
    }

    public void setP1EndDate(Date p1EndDate) {
        this.p1EndDate = p1EndDate;
    }

    public Integer getP1AmountOfDays() {
        return p1AmountOfDays;
    }

    public void setP1AmountOfDays(Integer p1AmountOfDays) {
        this.p1AmountOfDays = p1AmountOfDays;
    }

    public Double getP1DsaPrice() {
        return p1DsaPrice;
    }

    public void setP1DsaPrice(Double p1DsaPrice) {
        this.p1DsaPrice = p1DsaPrice;
    }

    public Double getP1PartnerPrice() {
        return p1PartnerPrice;
    }

    public void setP1PartnerPrice(Double p1PartnerPrice) {
        this.p1PartnerPrice = p1PartnerPrice;
    }

    public String getP1Fix() {
        return p1Fix;
    }

    public void setP1Fix(String p1Fix) {
        this.p1Fix = p1Fix;
    }

    public Date getP2StartDate() {
        return p2StartDate;
    }

    public void setP2StartDate(Date p2StartDate) {
        this.p2StartDate = p2StartDate;
    }

    public Date getP2EndDate() {
        return p2EndDate;
    }

    public void setP2EndDate(Date p2EndDate) {
        this.p2EndDate = p2EndDate;
    }

    public Integer getP2AmountOfDays() {
        return p2AmountOfDays;
    }

    public void setP2AmountOfDays(Integer p2AmountOfDays) {
        this.p2AmountOfDays = p2AmountOfDays;
    }

    public Double getP2DsaPrice() {
        return p2DsaPrice;
    }

    public void setP2DsaPrice(Double p2DsaPrice) {
        this.p2DsaPrice = p2DsaPrice;
    }

    public Double getP2PartnerPrice() {
        return p2PartnerPrice;
    }

    public void setP2PartnerPrice(Double p2PartnerPrice) {
        this.p2PartnerPrice = p2PartnerPrice;
    }

    public String getP2Fix() {
        return p2Fix;
    }

    public void setP2Fix(String p2Fix) {
        this.p2Fix = p2Fix;
    }

    public Date getP3StartDate() {
        return p3StartDate;
    }

    public void setP3StartDate(Date p3StartDate) {
        this.p3StartDate = p3StartDate;
    }

    public Date getP3EndDate() {
        return p3EndDate;
    }

    public void setP3EndDate(Date p3EndDate) {
        this.p3EndDate = p3EndDate;
    }

    public Integer getP3AmountOfDays() {
        return p3AmountOfDays;
    }

    public void setP3AmountOfDays(Integer p3AmountOfDays) {
        this.p3AmountOfDays = p3AmountOfDays;
    }

    public Double getP3DsaPrice() {
        return p3DsaPrice;
    }

    public void setP3DsaPrice(Double p3DsaPrice) {
        this.p3DsaPrice = p3DsaPrice;
    }

    public Double getP3PartnerPrice() {
        return p3PartnerPrice;
    }

    public void setP3PartnerPrice(Double p3PartnerPrice) {
        this.p3PartnerPrice = p3PartnerPrice;
    }

    public String getP3Fix() {
        return p3Fix;
    }

    public void setP3Fix(String p3Fix) {
        this.p3Fix = p3Fix;
    }

    public Date getP4StartDate() {
        return p4StartDate;
    }

    public void setP4StartDate(Date p4StartDate) {
        this.p4StartDate = p4StartDate;
    }

    public Date getP4EndDate() {
        return p4EndDate;
    }

    public void setP4EndDate(Date p4EndDate) {
        this.p4EndDate = p4EndDate;
    }

    public Integer getP4AmountOfDays() {
        return p4AmountOfDays;
    }

    public void setP4AmountOfDays(Integer p4AmountOfDays) {
        this.p4AmountOfDays = p4AmountOfDays;
    }

    public Double getP4DsaPrice() {
        return p4DsaPrice;
    }

    public void setP4DsaPrice(Double p4DsaPrice) {
        this.p4DsaPrice = p4DsaPrice;
    }

    public Double getP4PartnerPrice() {
        return p4PartnerPrice;
    }

    public void setP4PartnerPrice(Double p4PartnerPrice) {
        this.p4PartnerPrice = p4PartnerPrice;
    }

    public String getP4Fix() {
        return p4Fix;
    }

    public void setP4Fix(String p4Fix) {
        this.p4Fix = p4Fix;
    }

    public Integer getDiscountDsaPerc() {
        return discountDsaPerc;
    }

    public void setDiscountDsaPerc(Integer discountDsaPerc) {
        this.discountDsaPerc = discountDsaPerc;
    }

    public Integer getDiscountPartnerPerc() {
        return discountPartnerPerc;
    }

    public void setDiscountPartnerPerc(Integer discountPartnerPerc) {
        this.discountPartnerPerc = discountPartnerPerc;
    }

    public Integer getDiscountDsaEuro() {
        return discountDsaEuro;
    }

    public void setDiscountDsaEuro(Integer discountDsaEuro) {
        this.discountDsaEuro = discountDsaEuro;
    }

    public Integer getDiscountPartnerEuro() {
        return discountPartnerEuro;
    }

    public void setDiscountPartnerEuro(Integer discountPartnerEuro) {
        this.discountPartnerEuro = discountPartnerEuro;
    }

    public Integer getAvansDsaPerc() {
        return avansDsaPerc;
    }

    public void setAvansDsaPerc(Integer avansDsaPerc) {
        this.avansDsaPerc = avansDsaPerc;
    }

    public Integer getAvansDsaEuro() {
        return avansDsaEuro;
    }

    public void setAvansDsaEuro(Integer avansDsaEuro) {
        this.avansDsaEuro = avansDsaEuro;
    }

    public Integer getAvansPartnerCalc() {
        return avansPartnerCalc;
    }

    public void setAvansPartnerCalc(Integer avansPartnerCalc) {
        this.avansPartnerCalc = avansPartnerCalc;
    }

    public Integer getAvansPartnerPaid() {
        return avansPartnerPaid;
    }

    public void setAvansPartnerPaid(Integer avansPartnerPaid) {
        this.avansPartnerPaid = avansPartnerPaid;
    }

    public Double getCommonPriceDsa() {
        return commonPriceDsa;
    }

    public void setCommonPriceDsa(Double commonPriceDsa) {
        this.commonPriceDsa = commonPriceDsa;
    }

    public Double getCommonPricePartner() {
        return commonPricePartner;
    }

    public void setCommonPricePartner(Double commonPricePartner) {
        this.commonPricePartner = commonPricePartner;
    }

    public Double getDeltaPartner() {
        return deltaPartner;
    }

    public void setDeltaPartner(Double deltaPartner) {
        this.deltaPartner = deltaPartner;
    }

    public Double getProfitDsa() {
        return profitDsa;
    }

    public void setProfitDsa(Double profitDsa) {
        this.profitDsa = profitDsa;
    }

    public Double getManagerBonus() {
        return managerBonus;
    }

    public void setManagerBonus(Double managerBonus) {
        this.managerBonus = managerBonus;
    }

    public Double getAgentBonus() {
        return agentBonus;
    }

    public void setAgentBonus(Double agentBonus) {
        this.agentBonus = agentBonus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deals)) {
            return false;
        }
        Deals other = (Deals) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Deals[ id=" + id + " ]";
    }
    
}
