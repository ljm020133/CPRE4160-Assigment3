public class OrderProcessor {
    private OrderValidator validator;
    private DiscountService discountService;
    private OrderRepository orderRepository;

    public OrderProcessor(OrderValidator validator, DiscountService discountService, OrderRepository orderRepository) {
        this.validator = validator;
        this.discountService = discountService;
        this.orderRepository = orderRepository;
    }

    public void process(Order order) {
        validator.validate(order);
        Money total = discountService.calculate(order);
        order.setTotal(total);
        orderRepository.save(order);
    }
}
