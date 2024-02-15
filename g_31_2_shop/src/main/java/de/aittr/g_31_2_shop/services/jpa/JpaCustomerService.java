package de.aittr.g_31_2_shop.services.jpa;

import de.aittr.g_31_2_shop.domain.dto.CustomerDto;
import de.aittr.g_31_2_shop.domain.interfaces.Product;
import de.aittr.g_31_2_shop.domain.jpa.JpaCart;
import de.aittr.g_31_2_shop.domain.jpa.JpaCustomer;
import de.aittr.g_31_2_shop.exception_handling.exceptions.CustomerNotFoundException;
import de.aittr.g_31_2_shop.exception_handling.exceptions.InactiveCustomerException;
import de.aittr.g_31_2_shop.exception_handling.exceptions.InactiveProductException;
import de.aittr.g_31_2_shop.exception_handling.exceptions.ProductNotFoundException;
import de.aittr.g_31_2_shop.repositories.jpa.JpaCustomerRepository;
import de.aittr.g_31_2_shop.services.interfaces.CustomerService;
import de.aittr.g_31_2_shop.services.interfaces.ProductService;
import de.aittr.g_31_2_shop.services.mapping.CustomerMappingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaCustomerService implements CustomerService {

    private JpaCustomerRepository repository;
    private CustomerMappingService mappingService;
    private JpaProductService productService;

    public JpaCustomerService(JpaCustomerRepository repository, CustomerMappingService mappingService, JpaProductService productService) {
        this.repository = repository;
        this.mappingService = mappingService;
        this.productService = productService;
    }

    @Override
    public CustomerDto save(CustomerDto dto) {
        JpaCustomer entity = mappingService.mapDtoToJpaCustomer(dto);
        JpaCart cart = new JpaCart();
        entity.setCart(cart);
        cart.setCustomer(entity);

        entity = repository.save(entity);


        return mappingService.mapCustomerEntityToDto(entity);
    }

    @Override
    public List<CustomerDto> getAllActiveCustomers() {
        return repository.findAll()
                .stream()
                .filter(c -> c.isActive())
                .map(c -> mappingService.mapCustomerEntityToDto(c))
                .toList();
    }

    @Override
    public CustomerDto getActiveCustomerById(int id) {
        JpaCustomer entity = repository.findById(id).orElse(null);

        if (entity != null && entity.isActive()) {
            return mappingService.mapCustomerEntityToDto(entity);
        }

        return null;
    }

    @Override
    public void update(CustomerDto customer) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void restoreById(int id) {

    }

    @Override
    public int getActiveCustomersCount() {
        return 0;
    }

    @Override
    public double getCartTotalPriceById(int customerId) {
        return 0;
    }

    @Override
    public double getAverageProductPriceById(int customerId) {
        return 0;
    }

    @Override
    @Transactional
    public void addProductToCart(int customerId, int productId) {
        Product product = productService.getActiveJpaProductById(productId);
        JpaCustomer customer = repository.findById(customerId).orElse(null);

        if (customer == null) {
            throw new CustomerNotFoundException(String.format(
                    "There is no customer with id [%d] in the database", customerId));
        }

        if (!customer.isActive()) {
            throw new InactiveCustomerException(String.format(
                    "Customer with id [%d] is inactive and adding of the Product cannot be done", customerId));
        }

        customer.getCart().addProduct(product);
    }

    @Override
    public void deleteProductFromCart(int customerId, int productId) {

    }

    @Override
    public void clearCartById(int customerId) {

    }
}