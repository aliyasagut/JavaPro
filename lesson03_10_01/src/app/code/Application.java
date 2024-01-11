package app.code;

import app.staff.administration.Director;
import app.staff.administration.ProductionChief;
import app.staff.administration.SalesChief;
import app.staff.specialists.Secretary;
import app.staff.specialists.production.MachineOperator;
import app.staff.specialists.production.StoreKeeper;
import app.staff.specialists.sales.Merchandiser;
import app.staff.specialists.sales.SalesManager;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

////        версия кода без spring
// создаем линейных специалистов
//        MachineOperator machineOperator = new MachineOperator();
//        StoreKeeper storeKeeper = new StoreKeeper();
//
//        Merchandiser merchandiser = new Merchandiser();
//        SalesManager salesManager = new SalesManager();
//
//        Secretary secretary = new Secretary();
//
////        administration
//        ProductionChief productionChief = new ProductionChief();
//        productionChief.setMachineOperator(machineOperator);
//        productionChief.setStoreKeeper(storeKeeper);
//
//        SalesChief salesChief = new SalesChief();
//        salesChief.setSalesManager(salesManager);
//        salesChief.setMerchandiser(merchandiser);
//
//        Director director = new Director();
//        director.setSecretary(secretary);
//        director.setProductionChief(productionChief);
//        director.setSalesChief(salesChief);
//
////        запускаем предприятие
//        director.manageCompany();

//        Версия кода со спрингом, сконфигурированным с помощью xml
//        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//
////        Director director = (Director) context.getBean("dir");
//        Director director = context.getBean(Director.class);
//        director.manageCompany();

//        Версия кода со спрингом сконфигурированном при помощи специального класса конфигурации


    }
}
