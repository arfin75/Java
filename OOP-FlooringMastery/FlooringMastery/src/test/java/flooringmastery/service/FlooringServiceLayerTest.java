/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.service;

import flooringmastery.service.FlooringServiceLayer;
import flooringmastery.service.OrderValidationException;
import flooringmastery.service.NoOrdersFoundException;
import flooringmastery.service.NoTaxesFoundException;
import flooringmastery.service.NoProductsFoundException;
import flooringmastery.dao.FlooringPersistenceException;
import flooringmastery.dto.Order;
import flooringmastery.dto.Product;
import flooringmastery.dto.Tax;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author shaharfin
 */
public class FlooringServiceLayerTest {

    private FlooringServiceLayer service;


    public FlooringServiceLayerTest() {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        this.service =
                ctx.getBean("serviceLayer", FlooringServiceLayer.class);

    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }


    /**
     * Test of getTaxes method, of class FlooringServiceLayer.
     */
    @Test
    public void testGetTaxes() throws NoTaxesFoundException {
        //arrange
        //I have created a separate file with tax values within TestFolder, service is reading info from there
        //act
        List<Tax> taxes = service.getTaxes();
        int size = 4;
        int actualSize = taxes.size();
        //assert
        assertEquals(size, actualSize);
    }

    /**
     * Test of getProducts method, of class FlooringServiceLayer.
     */
    @Test
    public void testGetProducts() throws NoProductsFoundException {
        //arrange
        //I have created a separate file with product values within TestFolder, service is reading info from there
        //act
        List<Product> products = service.getProducts();
        int size = 4;
        int actualSize = products.size();
        //assert
        assertEquals(size, actualSize);
    }

    /**
     * Test of displayOrders method, of class FlooringServiceLayer.
     */
//    @Test
//    public void testDisplayOrders() throws Exception {
//        LocalDate testDate = LocalDate.parse("2021-01-01");
//        List<Order> order = service.displayOrders(testDate);
//
//        assertEquals(1, order.size());
//        assertEquals(1, order.get(0).getOrderNumber());
//    }

   
    /**
     * Test of removeOrder method, of class FlooringServiceLayer.
     */
    @Test
    public void testRemoveOrder() throws NoOrdersFoundException, FlooringPersistenceException {
        //arrange
        LocalDate testDate = LocalDate.parse("2021-01-01", DateTimeFormatter.ofPattern("MMddyyyy"));
        //act
        
        Order myOrder;
        
       myOrder = service.getOrder(testDate, 1);
        Order removedOrder = service.removeOrder(testDate, 1);
        //assert
        assertNull(removedOrder);
    }

    /**
     * Test of exportAllData method, of class FlooringServiceLayer.
     */
//    @Test
//    public void testExportAllData() throws Exception {
//        //arrange &act
//        File exportFile = new File("TestFolder/DataExport_test.txt");
//        service.exportAllData();
//        //assert
//        assertNotEquals(0, exportFile.length());
//        exportFile.delete();//deleting after completing the test
//    }
//
//    /**
//     * Test of calculateCostAndTax method, of class FlooringServiceLayer.
//     */
//    @Test
//    public void testCalculateCostAndTax() {
//        //arrange
//        Order newOrder = new Order(1);
//        newOrder.setCustomerName("Arfin");
//        newOrder.setState(new Tax("CA"));
//        newOrder.getState().setTaxRate(new BigDecimal("25.00"));
//        newOrder.setProduct(new Product("Wood"));
//        newOrder.setArea(new BigDecimal("100.00"));
//        newOrder.getProduct().setCostPerSquareFoot(new BigDecimal("5.15"));
//        newOrder.getProduct().setLaborCostPerSquareFoot(new BigDecimal("4.75"));
//
//        LocalDate testDate = LocalDate.parse("2021-01-01");
//
//        //act
//        service.calculateCostAndTax(newOrder);
//        //assert
//        assertEquals(new BigDecimal(515.00).setScale(2, RoundingMode.HALF_UP), newOrder.getMaterialCost().setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal(475.00).setScale(2, RoundingMode.HALF_UP), newOrder.getLaborCost().setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal(247.50).setScale(2, RoundingMode.HALF_UP), newOrder.getTax().setScale(2, RoundingMode.HALF_UP));
//        assertEquals(new BigDecimal(1237.50).setScale(2, RoundingMode.HALF_UP), newOrder.getTotal().setScale(2, RoundingMode.HALF_UP));
//    }
//    /**
//     * Test of validateDate method, of class FlooringServiceLayer.
//     */
//    @Test
//    public void testValidateDate() throws OrderValidationException {
//        //arrange
//        Order myOrder1 = new Order("Arfin", "CA", "Wood", new BigDecimal("120"));
//        LocalDate testDate1 = LocalDate.parse("2020-01-01");
//        myOrder1.setDate(testDate1);
//        //act
//        try {
//            service.validateDate(testDate1);
//            fail("Expected OrderValidationException was not thrown.");
//        } catch (OrderValidationException e) { //assert
//            return;
//        }
//
//        //assert
//        Order myOrder2 = new Order("Arfin", "TX", "Wood", new BigDecimal("120"));
//        LocalDate testDate2 = LocalDate.parse("2021-01-01");
//        myOrder1.setDate(testDate2);
//        //act
//        try {
//            service.validateDate(testDate2);
//        } catch (OrderValidationException e) {
//            //assert
//            fail("Order was valid. No exception should have been thrown.");
//        }
//    }
//
//    /**
//     * Test of validateData method, of class FlooringServiceLayer.
//     */
//    @Test
//    public void testValidateData() throws OrderValidationException {
//        //arrange
//        Order myOrder1 = new Order(" ", " ", "", null);
//        //act
//        try {
//            service.validateData(myOrder1);
//            fail("Expected OrderValidationException was not thrown.");
//        } catch (OrderValidationException e) { //assert
//            return;
//        }
//
//        //assert
//        Order myOrder2 = new Order("Arfin", "TX", "Wood", new BigDecimal("120"));
//        //act
//        try {
//            service.validateData(myOrder2);
//        } catch (OrderValidationException e) {
//            //assert
//            fail("Order was valid. No exception should have been thrown.");
//        }
//    }
//
//    /**
//     * Test of validateData method, of class FlooringServiceLayer.
//     */
//    @Test
//    public void testValidateUpdatedOrderInfo() throws OrderValidationException {
//        //arrange
//        Order myUpdatedOrder1 = new Order(" ", " ", " ", new BigDecimal("80"));
//        //act
//        try {
//            service.validateData(myUpdatedOrder1);
//            fail("Expected OrderValidationException was not thrown.");
//        } catch (OrderValidationException e) { //assert
//            return;
//        }
//
//        //assert
//        Order myUpdatedOrder2 = new Order(" ", "TX", "Wood", new BigDecimal("120"));
//        //act
//        try {
//            service.validateData(myUpdatedOrder2);
//        } catch (OrderValidationException e) {
//            //assert
//            fail("Order was valid. No exception should have been thrown.");
//        }
//    }
//
//
//    /**
//     * Test of validateProduct method, of class FlooringServiceLayer.
//     */
//    @Test
//    public void testValidateProduct() {
//        //arrange
//        Order myOrder1 = new Order("Arfin", "CA", "Wood", new BigDecimal("120"));
//        //act
//        try {
//            service.validateProduct(myOrder1);
//        } catch (OrderValidationException e) {
//            //assert
//            fail("Order was valid. No exception should have been thrown.");
//        }
//
//        //arrange
//        Order myOrder2 = new Order("Arfin", "CA", "Metal", new BigDecimal("120"));
//        //act
//        try {
//            service.validateProduct(myOrder2);
//            fail("Expected OrderValidationException was not thrown.");
//        } catch (OrderValidationException e) {
//            //assert
//            return;
//        }
//    }
//
//    /**
//     * Test of validateState method, of class FlooringServiceLayer.
//     */
//    @Test
//    public void testValidateState() {
//        //arrange
//        Order myOrder1 = new Order("Arfin", "CA", "Wood", new BigDecimal("120"));
//        //act
//        try {
//            service.validateState(myOrder1);
//        } catch (OrderValidationException e) {
//            //assert
//            fail("Order was valid. No exception should have been thrown.");
//        }
//
//        //arrange
//        Order myOrder2 = new Order("Arfin", "NY", "Wood", new BigDecimal("120"));
//        //act
//        try {
//            service.validateState(myOrder2);
//            fail("Expected OrderValidationException was not thrown.");
//        } catch (OrderValidationException e) {
//            //assert
//            return;
//        }
//    }
}

