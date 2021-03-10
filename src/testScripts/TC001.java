package testScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genric.ExcelLibrary;
import pom.OrderDeatils;

import pom.ProductListPage;


public class TC001 extends BaseTest {
	@DataProvider(name="MultipleProducts")
	public String[][] getData(){
		return ExcelLibrary.getMultipleCellData(XL_PATH," TC001");
		
	}
	@Test(description="Multiple Test Data" , dataProvider="MultipleProducts")	
	public void testToAddProduct(String menuItem,String productName,String color,String ram) {
		ProductListPage productsListPage = dashBoardPage.clickOnLink(menuItem);
		productsListPage.selectItem(productName);
		@SuppressWarnings("unused")
		OrderDeatils od=productDetails.ItemDetailPage(color, ram);
		
	}

}
