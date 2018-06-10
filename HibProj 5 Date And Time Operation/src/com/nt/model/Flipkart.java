package com.nt.model;


import java.util.Date;



public class Flipkart {
	
	private int productID;
	private String ProductName;
	
	private Date BuyDate;
	
	private Date Delivary;
	
	private Date ConFormation;
	
	private byte[] image;
	@Lob
	private char[] text;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public Date getBuyDate() {
		return BuyDate;
	}

	public void setBuyDate(Date buyDate) {
		BuyDate = buyDate;
	}

	public Date getDelivary() {
		return Delivary;
	}

	public void setDelivary(Date delivary) {
		Delivary = delivary;
	}

	public Date getConFormation() {
		return ConFormation;
	}

	public void setConFormation(Date conFormation) {
		ConFormation = conFormation;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public char[] getText() {
		return text;
	}

	public void setText(char[] text) {
		this.text = text;
	}

	public Flipkart() {
		System.out.println("Flipkart.Flipkart 0 param Constrator()");
	}

	@Override
	public String toString() {
		return "Flipkart [productID=" + productID + ", ProductName=" + ProductName + ", BuyDate=" + BuyDate
				+ ", Delivary=" + Delivary + ", ConFormation=" + ConFormation + ", image=" + Arrays.toString(image)
				+ ", text=" + Arrays.toString(text) + "]";
	}

}
