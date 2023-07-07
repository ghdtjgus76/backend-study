package ghdtjgus76.core.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}