/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuonghx.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hoxua
 */
@Entity
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id")
    , @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
    , @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description")
    , @NamedQuery(name = "Product.findByImageURL", query = "SELECT p FROM Product p WHERE p.imageURL = :imageURL")
    , @NamedQuery(name = "Product.findByUrlLink", query = "SELECT p FROM Product p WHERE p.urlLink = :urlLink")
    , @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")
    , @NamedQuery(name = "Product.findByVisitedCnt", query = "SELECT p FROM Product p WHERE p.visitedCnt = :visitedCnt")
    , @NamedQuery(name = "Product.findByProductType", query = "SELECT p FROM Product p WHERE p.productType = :productType")
    , @NamedQuery(name = "Product.findByColor", query = "SELECT p FROM Product p WHERE p.color = :color")
    , @NamedQuery(name = "Product.findByOutOfStock", query = "SELECT p FROM Product p WHERE p.outOfStock = :outOfStock")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "ImageURL")
    private String imageURL;
    @Column(name = "UrlLink")
    private String urlLink;
    @Basic(optional = false)
    @Column(name = "Price")
    private double price;
    @Basic(optional = false)
    @Column(name = "VisitedCnt")
    private int visitedCnt;
    @Basic(optional = false)
    @Column(name = "ProductType")
    private String productType;
    @Column(name = "Color")
    private String color;
    @Basic(optional = false)
    @Column(name = "OutOfStock")
    private boolean outOfStock;
    @JoinColumn(name = "CatID", referencedColumnName = "Id")
    @ManyToOne
    private Category catID;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, double price, int visitedCnt, String productType, boolean outOfStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.visitedCnt = visitedCnt;
        this.productType = productType;
        this.outOfStock = outOfStock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getUrlLink() {
        return urlLink;
    }

    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVisitedCnt() {
        return visitedCnt;
    }

    public void setVisitedCnt(int visitedCnt) {
        this.visitedCnt = visitedCnt;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean getOutOfStock() {
        return outOfStock;
    }

    public void setOutOfStock(boolean outOfStock) {
        this.outOfStock = outOfStock;
    }

    public Category getCatID() {
        return catID;
    }

    public void setCatID(Category catID) {
        this.catID = catID;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vuonghx.entities.Product[ id=" + id + " ]";
    }
    
}
