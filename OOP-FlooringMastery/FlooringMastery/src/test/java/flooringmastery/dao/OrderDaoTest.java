/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery.dao;

import flooringmastery.dto.Order;
import flooringmastery.dto.Product;
import flooringmastery.dto.Tax;
import java.io.File;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author shaharfin
 */
public class OrderDaoTest {

    private OrderDao testOrderDAO;
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "TestFolder/Orders";
        File folder = new File(testFile);
//        testOrderDAO = new OrderDaoFileImpl(testFile);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        testOrderDAO = ctx.getBean("orderDao", OrderDaoFileImpl.class);//LocalDate testDate = LocalDate.parse("2021-01-01");
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testAddAndGetOrder() throws Exception{
        
         LocalDate testDate = LocalDate.parse("10202020", DateTimeFormatter.ofPattern("MMddyyyy"));
        
         Order newOrder = new Order(1);
        newOrder.setCustomerName("Arfin");
        
        newOrder.setState(new Tax("CA"));
        newOrder.getState().setTaxRate(new BigDecimal("25.00"));
        
        newOrder.setProduct(new Product("Wood"));
        newOrder.setArea(new BigDecimal("100.00"));
        
        newOrder.getProduct().setCostPerSquareFoot(new BigDecimal("5.15"));
        newOrder.getProduct().setLaborCostPerSquareFoot(new BigDecimal("4.75"));
        
        newOrder.setMaterialCost(new BigDecimal("515.00"));
        newOrder.setLaborCost(new BigDecimal("475.00"));
        newOrder.setTax(new BigDecimal("247.50"));
        newOrder.setTotal(new BigDecimal("1237.50"));
        newOrder.setDate(testDate);

        System.out.println(newOrder);
       
        
        Order createdOrder = testOrderDAO.createOrder(testDate, newOrder);
        System.out.println(createdOrder);
    }

    /**
     * Test of createOrder method, of class OrderDao.
     */
//    @Test
//    public void testCreateOrder() throws Exception {
//        Order newOrder = new Order(1);
//        newOrder.setCustomerName("Arfin");
//        newOrder.setState(new Tax("CA"));
//        newOrder.getState().setTaxRate(new BigDecimal("25.00"));
//        newOrder.setProduct(new Product("Wood"));
//        newOrder.setArea(new BigDecimal("100.00"));
//        newOrder.getProduct().setCostPerSquareFoot(new BigDecimal("5.15"));
//        newOrder.getProduct().setLaborCostPerSquareFoot(new BigDecimal("4.75"));
//        newOrder.setMaterialCost(new BigDecimal("515.00"));
//        newOrder.setLaborCost(new BigDecimal("475.00"));
//        newOrder.setTax(new BigDecimal("247.50"));
//        newOrder.setTotal(new BigDecimal("1237.50"));
//
//        LocalDate testDate = LocalDate.parse("2021-01-01");
//
//        testOrderDAO.createOrder(testDate, newOrder);
//
//        assertEquals("Arfin", newOrder.getCustomerName());
//        assertNotEquals("Joe", newOrder.getCustomerName());
//        assertEquals(new BigDecimal("100").setScale(2, RoundingMode.HALF_UP), newOrder.getArea());
//        assertNotEquals(new BigDecimal("345").setScale(2, RoundingMode.HALF_UP), newOrder.getArea());
//    }
//
//    /**
//     * Test of readAllOrders method, of class OrderDao.
//     */
//    @Test
//    public void testReadAllOrders() throws Exception {
//
//        LocalDate testDate = LocalDate.parse("2021-01-02");
//
////        assertEquals(2, testOrderDAO.readAllOrders(testDate).size());
//    }
//
//    /**
//     * Test of readOrderById method, of class OrderDao.
//     */
//    @Test
//    public void testReadOrderById() throws Exception {
//        Order newOrder = new Order(1);
//        newOrder.setCustomerName("Arfin");
//        newOrder.setState(new Tax("CA"));
//        newOrder.getState().setTaxRate(new BigDecimal("25.00"));
//        newOrder.setProduct(new Product("Wood"));
//        newOrder.setArea(new BigDecimal("100.00"));
//        newOrder.getProduct().setCostPerSquareFoot(new BigDecimal("5.15"));
//        newOrder.getProduct().setLaborCostPerSquareFoot(new BigDecimal("4.75"));
//        newOrder.setMaterialCost(new BigDecimal("515.00"));
//        newOrder.setLaborCost(new BigDecimal("475.00"));
//        newOrder.setTax(new BigDecimal("247.50"));
//        newOrder.setTotal(new BigDecimal("1237.50"));
//
//        LocalDate testDate = LocalDate.parse("10202020", DateTimeFormatter.ofPattern("MMddyyyy"));
//
//        testOrderDAO.createOrder(testDate, newOrder);
//
//        Order fromDAO = testOrderDAO.readOrderById(testDate, 1);
//        assertEquals(fromDAO.getOrderNumber(), newOrder.getOrderNumber());
//    }

    /**
     * Test of updateOrder method, of class OrderDao.
     */
//    @Test
//    public void testUpdateOrder() throws Exception {
//        Order newOrder = new Order(1);
//        newOrder.setCustomerName("Arfin");
//        newOrder.setState(new Tax("CA"));
//        newOrder.getState().setTaxRate(new BigDecimal("25.00"));
//        newOrder.setProduct(new Product("Wood"));
//        newOrder.setArea(new BigDecimal("100.00"));
//        newOrder.getProduct().setCostPerSquareFoot(new BigDecimal("5.15"));
//        newOrder.getProduct().setLaborCostPerSquareFoot(new BigDecimal("4.75"));
//        newOrder.setMaterialCost(new BigDecimal("515.00"));
//        newOrder.setLaborCost(new BigDecimal("475.00"));
//        newOrder.setTax(new BigDecimal("247.50"));
//        newOrder.setTotal(new BigDecimal("1237.50"));
//
//        LocalDate testDate = LocalDate.parse("2021-01-01");
//
////        testOrderDAO.createOrder(testDate, newOrder);
//
//        Order updateOrder = new Order(1);
//        updateOrder.setCustomerName("Joe");
//        updateOrder.setState(new Tax("CA"));
//        updateOrder.getState().setTaxRate(new BigDecimal("25.00"));
//        updateOrder.setProduct(new Product("Wood"));
//        updateOrder.setArea(new BigDecimal("100.00"));
//        updateOrder.getProduct().setCostPerSquareFoot(new BigDecimal("5.15"));
//        updateOrder.getProduct().setLaborCostPerSquareFoot(new BigDecimal("4.75"));
//        updateOrder.setMaterialCost(new BigDecimal("515.00"));
//        updateOrder.setLaborCost(new BigDecimal("475.00"));
//        updateOrder.setTax(new BigDecimal("247.50"));
//        updateOrder.setTotal(new BigDecimal("1237.50"));
//
//        testOrderDAO.updateOrder(testDate, 1, updateOrder);
//
//        Order fromDAO = testOrderDAO.readOrderById(testDate, 1);
//
//        assertNotEquals("Arfin", fromDAO.getCustomerName());
//    }
//
//    /**
//     * Test of deleteOrder method, of class OrderDao.
//     */
//    @Test
//    public void testDeleteOrder() throws Exception {
//
//        LocalDate testDate = LocalDate.parse("2021-01-04");
//
//        testOrderDAO.readAllOrders(testDate);
//
//        testOrderDAO.deleteOrder(testDate, 2);
//        assertEquals(1, testOrderDAO.readAllOrders(testDate).size());
//        assertNull(testOrderDAO.readOrderById(testDate, 2));
//        assertNotNull(testOrderDAO.readOrderById(testDate, 3));
//   }
//
//    /**
//     * Test of getAllOrders method, of class OrderDao.
//     */
//    @Test
//    public void testGetAllOrders() throws FlooringPersistenceException {
//        try {
//            testOrderDAO.getAllOrders();
//        } catch (FlooringPersistenceException e) {
//            //assert
//            fail("Order files exist. No exception should have been thrown.");
//        }
//    }
}
