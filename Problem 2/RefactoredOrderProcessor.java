/**
 * Refactored OrderProcessor that follows the Single Responsibility Principle (SRP).
 * Dependencies are injected and each responsibility is handled by a dedicated class.
 */
public class OrderProcessor {
    private OrderValidator validator;
    private DiscountService discountService;
    private OrderRepository orderRepository;

    /**
     * Constructor-based dependency injection.
     */
    public OrderProcessor(OrderValidator validator, DiscountService discountService, OrderRepository orderRepository) {
        this.validator = validator;
        this.discountService = discountService;
        this.orderRepository = orderRepository;
    }

    /**
     * Processes an order by validating it, applying a discount, and persisting it.
     * Each step is delegated to a different collaborator for better cohesion.
     */
    public void process(Order order) {
        validator.validate(order);                  // Step 1: Validate the order
        Money total = discountService.calculate(order); // Step 2: Compute total with discounts
        order.setTotal(total);                      // Step 3: Update order total
        orderRepository.save(order);                // Step 4: Save to repository
    }
}
